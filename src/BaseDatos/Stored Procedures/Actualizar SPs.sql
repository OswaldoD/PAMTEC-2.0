-- -----------------------------------------------------
-- Procedure: ActualizarEstudiante
-- Entradas: pViejoCorreo VARCHAR(50), pViejaCedula VARCHAR(45),
--						  pNombre VARCHAR(25), pApellido1 VARCHAR(25),
--			    		  pApellido2 VARCHAR(25), pCedula VARCHAR(45),
--						  pEmail VARCHAR(50), pTelefono1 VARCHAR(16),
--						  pTelefono2 VARCHAR(16)
-- Salidas: 0 si lo cambio como se solicita
--			1 si hubo algun error
-- Restricciones: Ninguno Null
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE ActualizarEstudiante(pViejoCorreo VARCHAR(50), pViejaCedula VARCHAR(45),
									pNombre VARCHAR(25), pApellido1 VARCHAR(25),
									pApellido2 VARCHAR(25), pCedula VARCHAR(45),
									pEmail VARCHAR(50), pTelefono1 VARCHAR(16),
									pTelefono2 VARCHAR(16))
BEGIN
	/*
	La gracia de este es hacer un disable al actual en la base de datos
	y luego insertar un nuevo.... para evitar DEADLOCKS!
	*/
	DECLARE _Bit BIT DEFAULT 1;
	DECLARE _checkViejoEstudiante INT;
	DECLARE _checNuevoEstudiante INT; 

	SELECT IdEstudiante FROM Estudiantes WHERE email = pViejoCorreo AND Cedula = pViejaCedula AND Enabled = 1 INTO _checkViejoEstudiante;
	-- Revisamos si hay alguna diferencia, pues si es igual no hace falta insertarlo
	SELECT IdEstudiante FROM Estudiantes WHERE email = pEmail AND Cedula = pCedula AND Enabled = 1
										 AND Nombre = PNombre AND Apellido1 = pApellido1 AND Cedula = pCedula
										 AND Telefono1 = pTelefono1 AND Telefono2 = pTelefono2 
										 INTO _checNuevoEstudiante;

	IF _checkViejoEstudiante IS NOT NULL AND _checNuevoEstudiante IS NULL THEN
		-- Disable al viejo 
		-- Insertamos el nuevo 
		UPDATE Estudiantes SET Enabled = 0 WHERE IdEstudiante = _checkViejoEstudiante;
		INSERT INTO Estudiantes (Nombre, Apellido1, Apellido2, Cedula, Email, Telefono1, Telefono2, Enabled, FechaRegistro) VALUES
								(pNombre, pApellido1, pApellido2, pCedula, pEmail, pTelefono1, pTelefono2, 1, NOW());
		-- y actualizamos los cursos en los que se encuentra
		UPDATE EstudiantesPorCurso SET IdEstudiante  = LAST_INSERT_ID() WHERE IdEstudiante = _checkViejoEstudiante AND Enabled = 1;
		SET _Bit = 0;
	ELSE 
		SET _Bit = 1;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;


-- -----------------------------------------------------
-- Procedure: ActualizarColaborador
-- Entradas: pViejoCorreo VARCHAR(50),
-- 			 pNombre VARCHAR(25), pApellido1 VARCHAR(25),
-- 			 pApellido2 VARCHAR(25),
--			 pEmail VARCHAR(50), pRol VARCHAR (50)
-- Salidas: 0 si lo cambio como se solicita
--			1 si hubo algun error
-- Restricciones: Ninguno Null
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE ActualizarColaborador(pViejoCorreo VARCHAR(50),
									pNombre VARCHAR(25), pApellido1 VARCHAR(25),
									pApellido2 VARCHAR(25),
									pEmail VARCHAR(50), pRol VARCHAR (50))
BEGIN
	/*
	La gracia de este es hacer un disable al actual en la base de datos
	y luego insertar un nuevo.... para evitar DEADLOCKS!
	*/
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkViejoColaborador INT;
	DECLARE _checkNuevoColaborador INT;
	DECLARE _checkRol TINYINT;

	SELECT IdColaborador FROM Colaboradores WHERE email = pViejoCorreo AND Enabled = 1 INTO _checkViejoColaborador;
	SELECT IdRol FROM Roles WHERE Nombre = pRol AND enabled = 1 into _checkRol;
	SELECT IdColaborador FROM Colaboradores WHERE email = pEmail AND Enabled = 1 
												AND Nombre = pNombre AND Apellido1 = pApellido1
												AND Apellido2 = pApellido2 AND IdRol = _checkRol
												INTO _checkNuevoColaborador;
	IF _checkViejoColaborador IS NOT NULL AND  _checkNuevoColaborador IS NULL AND _checkRol IS NOT NULL THEN
		-- Disable al viejo 
		-- Insertamos el nuevo 
		UPDATE Colaboradores SET Enabled = 0 WHERE IdColaborador = _checkViejoColaborador;
		INSERT INTO Colaboradores (Nombre, Apellido1, Apellido2, Email, Enabled, FechaRegistro, IdRol) VALUES
								  (pNombre, pApellido1, pApellido2, pEmail, 1, NOW(), _checkRol);
		UPDATE ColaboradoresPorCurso SET IdColaborador  = LAST_INSERT_ID() WHERE IdColaborador = _checkViejoColaborador AND Enabled = 1;
		SET _Bit = 0;
	ELSE 
		SET _Bit = 1;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;


-- -----------------------------------------------------
-- Procedure: ActualizarCurso
-- Entradas: pNumeroGrupoViejo TINYINT, pCodigoViejo VARCHAR(50),
--			 pNombre VARCHAR(25), pCodigo VARCHAR(25), pNumeroGrupo TINYINT,
-- 			 pDetalles VARCHAR(25), pCupo TINYINT
-- Salidas: 0 si lo cambio como se solicita
--			1 si hubo algun error
-- 			2 problemas con el cupo
-- Restricciones: Ninguno Null
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE ActualizarCurso(pNumeroGrupoViejo TINYINT, pCodigoViejo VARCHAR(50),
								 pNombre VARCHAR(25), pCodigo VARCHAR(25), pNumeroGrupo TINYINT,
							     pDetalles VARCHAR(25), pCupo TINYINT)
BEGIN
	/*
	La gracia de este es hacer un disable al actual en la base de datos
	y luego insertar un nuevo.... para evitar DEADLOCKS!
	*/
	DECLARE _Bit TINYINT DEFAULT 0;
	DECLARE _checkViejoCurso INT;
	DECLARE _checkNuevoCurso INT;
	DECLARE _cupoActual TINYINT;

	SELECT IdCurso FROM Cursos WHERE NumeroGrupo = pNumeroGrupo AND Codigo = pCodigo AND Enabled = 1 INTO _checkViejoCurso;
	SELECT IdCurso FROM Cursos WHERE NumeroGrupo = pNumeroGrupo AND Enabled = 1 
												AND Nombre = pNombre AND Codigo = pCodigo 
												AND Detalles = pDetalles AND pCupo = pCupo
												INTO _checkNuevoCurso;
	-- Sacamos la cantidad actual de estudiantes y el cupo para ver si no van a dejar gente afuera
	SELECT COUNT(IdEstudiante) FROM EstudiantesPorCurso WHERE IdCurso = _checkViejoCurso AND Enabled = 1 INTO _cupoActual;
	-- SELECT Cupo FROM Cursos WHERE IdCurso = _checkViejoCurso AND Enabled = 1 INTO _cupoActual
	IF _checkViejoCurso IS NOT NULL AND  _checkNuevoCurso IS NULL AND _cupoActual IS NOT NULL THEN
		IF (_cupoActual - pCupo) > 0 THEN
			-- Disable El curso
			-- Insert del nuevo curso
			-- Update de las tablas intermedias
			UPDATE Cursos SET Enabled = 0  WHERE IdCurso = _checkViejoCurso;
			INSERT INTO Cursos (Nombre, Codigo, Enabled, FechaCreacion, Detalles, Cupo, NumeroGrupo) VALUES
								(pNombre, pCodigo, 1, NOW(), pDetalles, pCupo, pNumeroGrupo);
			UPDATE EstudiantesPorCurso SET IdCurso = LAST_INSERT_ID() WHERE IdCurso = _checkViejoCurso AND Enabled = 1;
			UPDATE ColaboradoresPorCurso SET IdCurso = LAST_INSERT_ID() WHERE IdCurso = _checkViejoCurso AND Enabled = 1;
			SET _Bit = 0;
		ELSE 
			SET _Bit = 2;
		END IF;
	ELSE 
		SET _Bit = 1;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;