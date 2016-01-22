/*
Aqui vamos a poner todos los SPs que devuelven datos especificos
*/

-- -----------------------------------------------------
-- Procedure: CantProfCurso
-- Entradas: pCodigo VARCHAR(50), pNumeroGrupo TINYINT
-- Salidas: un numero con la cantidad de profesores que
--			posee un curso
-- Restricciones: ninguno null
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE CantProfCurso(pCodigo VARCHAR(50), pNumeroGrupo TINYINT)
BEGIN
	SELECT Count(CpC.IdColaborador) from colaboradores col
	INNER JOIN ColaboradoresPorCurso CpC ON CpC.IdColaborador = col.IdColaborador
	INNER JOIN Roles Rol on col.IdRol = Rol.IdRol AND Rol.Nombre = "Profesor"
	INNER JOIN Cursos Cur on Cur.IdCurso = CpC.IdCurso AND Cur.Codigo = pCodigo AND Cur.NumeroGrupo = pNumeroGrupo AND Cur.Enabled = 1;
END //
DELIMITER ;

-- -----------------------------------------------------
-- Procedure: CantAsisCurso
-- Entradas: pCodigo VARCHAR(50), pNumeroGrupo TINYINT
-- Salidas: un numero con la cantidad de asistentes que
--			posee un curso
-- Restricciones: ninguno null
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE CantAsisCurso(pCodigo VARCHAR(50), pNumeroGrupo TINYINT)
BEGIN
	SELECT Count(CpC.IdColaborador) from colaboradores col
	INNER JOIN ColaboradoresPorCurso CpC ON CpC.IdColaborador = col.IdColaborador
	INNER JOIN Roles Rol on col.IdRol = Rol.IdRol AND Rol.Nombre = "Asistente"
	INNER JOIN Cursos Cur on Cur.IdCurso = CpC.IdCurso AND Cur.Codigo = pCodigo AND Cur.NumeroGrupo = pNumeroGrupo;
END //
DELIMITER ;


-- -----------------------------------------------------
-- Procedure: ExisteCurso
-- Entradas: pCodigo VARCHAR(50), pNumeroGrupo TINYINT
-- Salidas: 1 si existe
--			0 si no existe
-- Restricciones: ninguno null
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE ExisteCurso(pCodigo VARCHAR(50), pNumeroGrupo TINYINT)
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkCurso INT;
	SELECT IdCurso FROM Cursos WHERE Codigo = pCodigo AND pNumeroGrupo = pNumeroGrupo AND Enabled = 1 INTO _checkCurso;
	IF _checkCurso IS NOT NULL THEN
		SET _Bit = 1;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;


-- -----------------------------------------------------
-- Procedure: ExisteEstudiante
-- Entradas: pCedula VARCHAR(50), pEmail VARCHAR(50)
-- Salidas: 1 si existe
--			0 si no existe
-- Restricciones: ninguno null
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE ExisteEstudiante(pCedula VARCHAR(50), pEmail VARCHAR(50))
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkEstudiante INT;
	SELECT IdEstudiante FROM Estudiantes WHERE Cedula = pCedula AND email = pEmail AND Enabled = 1 INTO _checkEstudiante;
	IF _checkEstudiante IS NOT NULL THEN
		SET _Bit = 1;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;


-- -----------------------------------------------------
-- Procedure: ExisteColaborador
-- Entradas: pEmail VARCHAR(50)
-- Salidas: 1 si existe
--			0 si no existe
-- Restricciones: ninguno null
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE ExisteColaborador(pEmail VARCHAR(50))
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkColaborador INT;
	SELECT IdColaborador FROM colaboradores WHERE email = pEmail AND Enabled = 1 INTO _checkColaborador;
	IF _checkColaborador IS NOT NULL THEN
		SET _Bit = 1;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;

-- -----------------------------------------------------
-- Procedure: HayCampo
-- Entradas: pCodigo VARCHAR(50), pNumeroGrupo VARCHAR(50)
-- Salidas: 1 si hay campo
--			0 si no hay
-- Restricciones: ninguno null
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE HayCampo(pCodigo VARCHAR(50), pNumeroGrupo VARCHAR(50))
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkCurso INT;
	DECLARE _cupo TINYINT;
	DECLARE _metidos;
	-- Buscamos los datos
	SELECT IdCurso FROM Cursos WHERE Codigo = pCodigo AND NumeroGrupo = pNumeroGrupo AND Enabled = 1 INTO _checkCurso;
	SELECT Cupo FROM Cursos WHERE Codigo = pCodigo AND NumeroGrupo = pNumeroGrupo AND Enabled = 1 INTO _cupo;
	SELECT Count(IdEstudiatne) FROM EstudiantesPorCurso WHERE IdCurso = _checkCurso AND Enabled = 1 INTO _metidos;
	
	IF _checkCurso IS NOT NULL AND _cupo IS NOT NULL AND _metidos IS NOT NULL THEN
		IF (_cupo - _metidos) > 0 THEN
			SET _Bit = 1;
		END IF;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;


-- -----------------------------------------------------
-- Procedure: isProfe
-- Entradas: pEmail VARCHAR(50)
-- Salidas: 1 si es
--			0 si no es
-- Restricciones: ninguno null
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE isProfe(pEmail VARCHAR(50))
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkColaborador INT;

	SELECT Col.IdColaborador from colaboradores Col
	INNER JOIN Roles Rol on Col.IdRol = rol.idrol AND rol.nombre = "Profesor" AND 
							Col.Enabled = 1  AND Col.Email = pEmail INTO _checkColaborador;
	IF _checkColaborador IS NOT NULL THEN
		SET _Bit = 1;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;


-- -----------------------------------------------------
-- Procedure: isAsistente
-- Entradas: pEmail VARCHAR(50)
-- Salidas: 1 si es
--			0 si no es
-- Restricciones: ninguno null
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE isAsistente(pEmail VARCHAR(50))
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkColaborador INT;

	SELECT Col.IdColaborador from colaboradores Col
	INNER JOIN Roles Rol on Col.IdRol = rol.idrol AND rol.nombre = "Asistente" AND 
							Col.Enabled = 1  AND Col.Email = pEmail INTO _checkColaborador;
	IF _checkColaborador IS NOT NULL THEN
		SET _Bit = 1;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;



-- -----------------------------------------------------
-- Procedure: EstaEstudiante
-- Entradas: pEmail VARCHAR(50)
-- Salidas: 1 si esta
--			0 si no esta
-- Restricciones: ninguno null y ya debe de venir
-- comprobado la existencia del estudiante y del curso
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE EstaEstudianteMatriculado(pEmail VARCHAR(50), pCedula VARCHAR(50), pCodigo VARCHAR(50), pNumeroGrupo TINYINT)
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkEstudiante INT;
	DECLARE _checkCurso INT;
	DECLARE _checkMatriculado INT;

	SELECT IdEstudiante FROM Estudiantes WHERE email = pEmail AND Cedula = pCedula AND Enabled = 1 INTO _checkEstudiante;
	SELECT IdCurso FROM Cursos WHERE Codigo = pCodigo AND NumeroGrupo = pNumeroGrupo AND Enabled = 1 INTO _checkCurso;
	SELECT IdEstudiante FROM EstudiantesPorCurso WHERE IdEstudiante = _checkEstudiante 
												 AND IdCurso = _checkCurso AND 
												 Enabled = 1 INTO _checkMatriculado; 
	IF _checkMatriculado IS NOT NULL THEN
		SET _Bit = 1;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;


-- -----------------------------------------------------
-- Procedure: ExisteUsuario
-- Entradas: pNombre VARCHAR(50)
-- Salidas: 1 si esta
--			0 si no esta
-- Restricciones: ninguno null
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE ExisteUsuario(pNombre VARCHAR(50))
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkUsuario INT;

	SELECT IdUsuario FROM UsuariosSistema WHERE Username = pNombre AND Enabled = 1 INTO _checkUsuario;

	IF _checkUsuario IS NOT NULL THEN
		SET _Bit = 1;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;
