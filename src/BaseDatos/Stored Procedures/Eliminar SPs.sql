-- -----------------------------------------------------
-- Procedure: EliminarEstudiante
-- Entradas: email VARCHAR, cedula VARCHAR
-- Salidas: 0 si lo eliminó como se debe
--			1 si hubo algun error
-- Restricciones: Ninguno Null
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE EliminarEstudiante(pEmail VARCHAR(50), pCedula VARCHAR(16))
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkEstudiante INT;
	SELECT IdEstudiante FROM Estudiantes WHERE email = pEmail AND Cedula = pCedula AND Enabled = 1 INTO _checkEstudiante;
	IF _checkEstudiante IS NOT NULL THEN
		-- Desactivamos el usuario
		UPDATE Estudiantes SET Enabled = 0 WHERE IdEstudiante = _checkEstudiante;
		UPDATE EstudiantesPorCurso SET Enabled = 0 WHERE IdEstudiante = _checkEstudiante;
		SET _Bit = 0;
	ELSE 
		SET _Bit = 1;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;


-- -----------------------------------------------------
-- Procedure: EliminarColaborador
-- Entradas: pEmail VARCHAR
-- Salidas: 0 si lo eliminó como se debe
--			1 si hubo algun error
-- Restricciones: Ninguno Null
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE EliminarColaborador(pEmail VARCHAR(50))
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkColaborador INT;
	SELECT IdColaborador FROM Colaboradores WHERE email = pEmail AND Enabled = 1 INTO _checkColaborador;
	IF _checkColaborador IS NOT NULL THEN
		-- Desactivamos el colaborador
		UPDATE Colaboradores SET Enabled = 0 WHERE IdColaborador = _checkColaborador;
		UPDATE ColaboradoresPorCurso SET enabled = 0 WHERE Enabled = 1 AND IdColaborador = _checkColaborador;
		SET _Bit = 0;
	ELSE 
		SET _Bit = 1;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;

-- -----------------------------------------------------
-- Procedure: EliminarCurso
-- Entradas: pCodigoCurso VARCHAR(50), pNumeroGrupo TINYINT
-- Salidas: 0 si lo eliminó como se debe
--			1 si hubo algun error
-- Restricciones: Ninguno Null
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE EliminarCurso(pCodigoCurso VARCHAR(50), pNumeroGrupo TINYINT)
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkCurso INT;
	SELECT IdCurso FROM Cursos WHERE Codigo = pCodigo AND Enabled = 1 AND NumeroGrupo = pNumeroGrupo INTO _checkCurso;
	IF _checkCurso IS NOT NULL THEN
		-- Desactivamos el curso y todas sus llaves foraneas
		UPDATE Cursos SET Enabled = 0 WHERE IdCurso = _checkCurso;
		UPDATE EstudiantesPorCurso SET Enabled = 0 WHERE IdCurso = _checkCurso AND Enabled = 1;
		UPDATE ColaboradoresPorCurso SET Enabled = 0 WHERE IdCurso = _checkCurso AND Enabled = 1;
		SET _Bit = 0;
	ELSE 
		SET _Bit = 1;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;