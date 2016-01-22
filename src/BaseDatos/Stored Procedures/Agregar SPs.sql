-- -----------------------------------------------------
-- Procedure: InsertarEstudiante
-- Entradas: Nombre VARCHAR, Apellido 1 VARCHAR, 
--			 Apellido 2 VARCHAR, Cedula VARCHAR, 
--			 email VARCHAR, Telefono1 VARCHAR, 
--			 Telefono 2 VARCHAR
-- Salidas: 0 si lo inserto como se debe
--			1 si hubo error
-- Restricciones: Solo el Telefono 2 puede ser null, 
--  			  pero puede dar problemas, mejor un caracter
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE InsertarEstudiante(pNombre VARCHAR(25), pApellido1 VARCHAR(25),
									pApellido2 VARCHAR(25), pCedula VARCHAR(45),
									pEmail VARCHAR(50), pTelefono1 VARCHAR(16),
									pTelefono2 VARCHAR(16))
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkEstudiante INT;
	SELECT IdEstudiante FROM Estudiantes WHERE email = pEmail AND Enabled = 1 AND Cedula = pCedula INTO _checkEstudiante;
	IF _checkEstudiante IS NULL THEN
		-- Insertamos porque no existe tal usuario activo
		INSERT INTO Estudiantes (Nombre, Apellido1, Apellido2, Cedula, Email, Telefono1, Telefono2, Enabled, FechaRegistro) VALUES
								(pNombre, pApellido1, pApellido2, pCedula, pEmail, pTelefono1, pTelefono2, 1, NOW());
		SET _Bit = 0;
	ELSE 
		SET _Bit = 1;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;

-- -----------------------------------------------------
-- Procedure: InsertarColaborador
-- Entradas: pNombre VARCHAR, pApellido1 VARCHAR,
-- 					 pApellido2 VARCHAR,pEmail VARCHAR,
-- 					 pRol VARCHAR
-- Salidas: 0 si lo inserto como se debe
--			1 si hubo error
-- Restricciones: None
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE InsertarColaborador(pNombre VARCHAR(25), pApellido1 VARCHAR(25),
									pApellido2 VARCHAR(25),	pEmail VARCHAR(50),
									pRol VARCHAR(45))
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkColaborador INT;
	DECLARE _idRol TINYINT;
	SELECT IdColaborador FROM Colaboradores WHERE email = pEmail AND Enabled = 1 INTO _checkColaborador;
	SELECT IdRol FROM ROLES WHERE Nombre = pRol AND Enabled = 1 INTO _idRol;
	IF _checkColaborador IS NULL AND _idRol IS NOT NULL THEN
		-- Insertamos porque no existe ese colaborador activo
		INSERT INTO Colaboradores (Nombre, Apellido1, Apellido2, Email, Enabled, FechaRegistro, IdRol) VALUES
								(pNombre, pApellido1, pApellido2, pEmail, 1, NOW(), _idRol);
		SET _Bit = 0;
	ELSE 
		SET _Bit = 1;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;

-- -----------------------------------------------------
-- Procedure: InsertarCurso
-- Entradas: pNombre VARCHAR(25), pCodigo VARCHAR(25), 
-- 			 pNumeroGrupo TINYINT, pDetalles VARCHAR(25), 
-- 			 pCupo TINYINT
-- Salidas: 0 si lo inserto como se debe
--			1 si hubo error
-- Restricciones: Ninguno null, Ya los emails de los 
-- colaboradores tiene que venir confirmados
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE InsertarCurso(pNombre VARCHAR(25), pCodigo VARCHAR(25), 
							  pNumeroGrupo TINYINT, pDetalles VARCHAR(25), 
							  pCupo TINYINT, pEmailProfe VARCHAR(50), 
							  pEmailAsis1 VARCHAR(50), pEmailAsis2 VARCHAR(50))
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkCurso INT;
	DECLARE _colaborador INT;
	SELECT IdCurso FROM Cursos WHERE Codigo = pCodigo AND Enabled = 1 AND NumeroGrupo = pNumeroGrupo INTO _checkCurso;
	IF _checkCurso IS NULL AND pCupo > 0 AND pCupo < 128 THEN
		-- Insertamos porque no existe ese curso activo y metemos los colaboradores previamente 
		-- comprobados
		INSERT INTO Cursos (Nombre, Codigo, Enabled, FechaCreacion, Detalles, Cupo, NumeroGrupo) VALUES
								(pNombre, pCodigo, 1, NOW(), pDetalles, pCupo, pNumeroGrupo);
		SELECT IdColaborador FROM Colaboradores WHERE Enabled = 1 AND email = pEmailProfe INTO _colaborador;
		INSERT INTO ColaboradoresPorCurso (Enabled, IdColaborador, IdCurso) VALUES
										  (1, _colaborador, _checkCurso);
		SELECT IdColaborador FROM Colaboradores WHERE Enabled = 1 AND email = pEmailAsis1 INTO _colaborador;
		INSERT INTO ColaboradoresPorCurso (Enabled, IdColaborador, IdCurso) VALUES
										  (1, _colaborador, _checkCurso);
		SELECT IdColaborador FROM Colaboradores WHERE Enabled = 1 AND email = pEmailAsis2 INTO _colaborador;
		INSERT INTO ColaboradoresPorCurso (Enabled, IdColaborador, IdCurso) VALUES
										  (1, _colaborador, _checkCurso);
		SET _Bit = 0;
	ELSE 
		SET _Bit = 1;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;