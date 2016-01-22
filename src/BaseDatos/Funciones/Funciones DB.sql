/*Funciones*/
DELIMITER $$
CREATE Function CupoDisponible (pCodCurso VARCHAR(20), pNumeroGrupo TINYINT) RETURNS TINYINT
BEGIN
	DECLARE _cupo TINYINT;
	DECLARE _cantidad TINYINT;

	SELECT COUNT(EpC.IdEstudiante) from estudiantesporcurso as EpC
	INNER JOIN Cursos Cur ON EpC.IdCurso = Cur.IdCurso 
	WHERE EpC.Enabled = 1 AND Cur.Codigo = pCodCurso AND cur.NumeroGrupo = pNumeroGrupo INTO _cantidad;
	SELECT Cupo from Cursos WHERE Codigo = pCodCurso AND Enabled = 1 INTO _cupo;
	RETURN (_cupo - _cantidad);
END$$
DELIMITER ;


DELIMITER $$
CREATE Function CantidadEstudiantesEnCurso (pCodCurso VARCHAR(20), pNumeroGrupo TINYINT) RETURNS TINYINT
BEGIN
	DECLARE _cantidad TINYINT;
	SELECT COUNT(EpC.IdEstudiante) from estudiantesporcurso as EpC
	INNER JOIN Cursos Cur ON EpC.IdCurso = Cur.IdCurso 
	WHERE EpC.Enabled = 1 AND Cur.Codigo = pCodCurso INTO _cantidad;
	RETURN _cantidad;
END$$
DELIMITER ;



