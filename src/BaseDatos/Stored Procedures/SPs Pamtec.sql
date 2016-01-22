-- -----------------------------------------------------
-- Procedure: MatricularEstudiante
-- Entradas: pRol VARCHAR
-- Salidas: 0 si lo cambio como se solicita
--			1 si hubo algun error
-- 			2 problemas con el cupo
-- Restricciones: Ninguno Null
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE MatricularEstudiante(pEmail VARCHAR(50), pCedula VARCHAR(50), pCodigo VARCHAR(50), pNumeroGrupo TINYINT)
BEGIN
	DECLARE _Bit TINYINT DEFAULT 0;
	DECLARE _checkEstudiante INT;
	DECLARE _checkCurso INT;
	DECLARE _matriculados TINYINT;
	DECLARE _cupo TINYINT;
	DECLARE _checkMatricula INT;

	SELECT IdCurso FROM Cursos WHERE NumeroGrupo = pNumeroGrupo AND Codigo = pCodigo AND Enabled = 1 INTO _checkCurso;
	SELECT IdEstudiante FROM Estudiantes WHERE Cedula = pCedula AND Email = pEmail AND Enabled = 1 INTO _checkEstudiante;
	-- Sacamos la cantidad actual de estudiantes en el curso, el cupo del curso y si el estudiante ya esta matriculado
	SELECT COUNT(IdEstudiante) FROM EstudiantesPorCurso WHERE IdCurso = _checkCurso AND Enabled = 1 INTO _matriculados;
	SELECT Cupo FROM Cursos WHERE IdCurso = _checkCurso AND Enabled = 1 INTO _cupo;
	SELECT IdEstudiante FROM EstudiantesPorCurso WHERE IdCurso = _checkCurso AND IdEstudiante = _checkEstudiante AND Enabled = 1 INTO _checkMatricula;

	IF _checkCurso IS NOT NULL AND _checkEstudiante IS NOT NULL AND _matriculados IS NOT NULL AND _cupo IS NOT NULL AND _checkMatricula IS NULL THEN
		IF (_cupo - _matriculados) > 0 THEN
			INSERT INTO EstudiantesPorCurso (Enabled, IdEstudiante, IdCurso) VALUES
											(1, _checkEstudiante, _checkCurso);
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


-- -----------------------------------------------------
-- Procedure: DesmatricularEstudiante
-- Entradas: pEmail VARCHAR(50), pCedula VARCHAR(50), 
--			 pCodigo VARCHAR(50), pNumeroGrupo TINYINT
-- Salidas: 0 si lo cambio como se solicita
--			1 si hubo algun error
-- Restricciones: Ninguno Null
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE DesmatricularEstudiante(pEmail VARCHAR(50), pCedula VARCHAR(50), pCodigo VARCHAR(50), pNumeroGrupo TINYINT)
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkEstudiante INT;
	DECLARE _checkCurso INT;
	DECLARE _checkMatricula INT;

	SELECT IdCurso FROM Cursos WHERE NumeroGrupo = pNumeroGrupo AND Codigo = pCodigo AND Enabled = 1 INTO _checkCurso;
	SELECT IdEstudiante FROM Estudiantes WHERE Cedula = pCedula AND Email = pEmail AND Enabled = 1 INTO _checkEstudiante;
	SELECT IdEstudiante FROM EstudiantesPorCurso WHERE IdEstudiante = _checkEstudiante AND IdCurso = _checkCurso AND Enabled = 1 INTO _checkMatricula;
	IF _checkCurso IS NOT NULL AND _checkEstudiante IS NOT NULL AND _checkMatricula IS NOT NULL THEN
		UPDATE EstudiantesPorCurso SET Enabled = 0 WHERE IdEstudiante = _checkEstudiante AND IdCurso = _checkCurso AND Enabled = 1;
		SET _bit = 0;
	ELSE 
		SET _Bit = 1;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;

-- -----------------------------------------------------
-- Procedure: AsignarColaborador
-- Entradas: pRol VARCHAR
-- Salidas: 0 si lo cambio como se solicita
--			1 si hubo algun error
-- 			2 problemas con el cupo
-- Restricciones: No esta listo!!!!!!!
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE AsignarProfesor(pEmail VARCHAR(50), pCodigo VARCHAR(50), pNumeroGrupo TINYINT)
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkProfesorINT;
	DECLARE _checkRol INT;
	DECLARE _checkProfesor INT;
	DECLARE _checkMatricula INT;

	SELECT IdCurso FROM Cursos WHERE NumeroGrupo = pNumeroGrupo AND Codigo = pCodigo AND Enabled = 1 INTO _checkCurso;
	SELECT IdEstudiante FROM Estudiantes WHERE Cedula = pCedula AND Email = pEmail AND Enabled = 1 INTO _checkEstudiante;
	SELECT IdEstudiante FROM EstudiantesPorCurso WHERE IdEstudiante = _checkEstudiante AND IdCurso = _checkCurso AND Enabled = 1 INTO _checkMatricula;
	IF _checkCurso IS NOT NULL AND _checkEstudiante IS NOT NULL AND _checkMatricula IS NOT NULL THEN
		UPDATE EstudiantesPorCurso SET Enabled = 0 WHERE IdEstudiante = _checkEstudiante AND IdCurso = _checkCurso AND Enabled = 1;
		SET _bit = 0;
	ELSE 
		SET _Bit = 1;
	END IF;
	SELECT _Bit;
END //
DELIMITER ;




