-- -----------------------------------------------------
-- Procedure: InformacionCursos
-- Entradas: VOID
-- Salidas: Nombre, Codigo, NumeroGrupo, CupoDisponible
-- Restricciones: Ninguno
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE InformacionCursos()
BEGIN
	SELECT Cur.Nombre "Nombre", Cur.Codigo "Codigo", Cur.NumeroGrupo "NumeroGrupo", (cur.Cupo - count(*)) "CupoDisponible" from EstudiantesPorCurso EpC
	INNER JOIN cursos cur on cur.IdCurso = EpC.IdCurso AND EpC.Enabled = 1
	WHERE Cur.Enabled = 1
	GROUP BY (EPC.IdCurso);
END //
DELIMITER ;

-- -----------------------------------------------------
-- Procedure: InformacionCursos
-- Entradas: VOID
-- Salidas: Nombre, Codigo, NumeroGrupo, Cupo
-- Restricciones: Ninguno
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE InformacionGeneralCursos()
BEGIN
	SELECT Cur.Nombre "Nombre", Cur.Codigo "Codigo", Cur.NumeroGrupo "NumeroGrupo", cur.Cupo "Cupo" from EstudiantesPorCurso EpC
	INNER JOIN cursos cur on cur.IdCurso = EpC.IdCurso AND EpC.Enabled = 1
	WHERE Cur.Enabled = 1
	GROUP BY (EPC.IdCurso);
END //
DELIMITER ;


-- -----------------------------------------------------
-- Procedure: InformacionExcelEstudiantes
-- Entradas: El grupo que quiere averiguar
-- Salidas: Apellidos, Nombre, Telefono1, Telefono2
-- Restricciones: Ninguno
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE InformacionExcelEstudiantes(pCodigo VARCHAR(50),  pNumeroGrupo TINYINT)
BEGIN
	SELECT Concat(Est.Apellido1, " ", Est.Apellido2) "Apellidos", Est.Nombre, Est.Telefono1, Est.Telefono2 FROM Estudiantes Est
	INNER JOIN EstudiantesPorCurso EpC ON Est.IdEstudiante = EpC.IdEstudiante AND EpC.Enabled = 1 
	INNER JOIN Cursos Cur ON Cur.IdCurso = EpC.IdCurso AND Cur.Enabled = 1 AND Cur.Codigo = pCodigo AND Cur.NumeroGrupo = pNumeroGrupo
	WHERE Est.Enabled = 1
END //
DELIMITER ;


-- -----------------------------------------------------
-- Procedure: InformacionColaboradores
-- Entradas: El grupo que quiere averiguar
-- Salidas: Apellidos, Nombre, Email, rol
-- Restricciones: Ninguno
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE InformacionColaboradores()
BEGIN
	SELECT Concat(Col.Apellido1, " ", Col.Apellido2) "Apellidos", Col.Nombre, Col.Email, Rol.Nombre "Rol" FROM Colaboradores Col
	INNER JOIN Roles Rol ON Col.IdRol = Rol.IdRol AND Rol.Enabled = 1
	WHERE Col.Enabled = 1;
END //
DELIMITER ;


-- -----------------------------------------------------
-- Procedure: ColaboradorDeCurso
-- Entradas: El grupo que quiere averiguar
-- Salidas: Nombre, Codigo , NumeroGrupo , 
-- Restricciones: Ninguno
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE ColaboradorDeCurso()
BEGIN
	SELECT Cur.Nombre, Cur.Codigo, Cur.NumeroGrupo, Concat(Col.Nombre, " ", Col.Apellido1, " ", Col.Apellido2) "Colaborador", Rol.Nombre "Rol" FROM Cursos Cur
	INNER JOIN ColaboradoresPorCurso CpC ON Cur.IdCurso = CpC.IdCurso AND CpC.Enabled = 1
	INNER JOIN Colaboradores Col ON CpC.IdColaborador = Col.IdColaborador AND Col.Enabled = 1
	INNER JOIN Roles Rol ON Col.IdRol = Rol.IdRol AND Rol.Enabled = 1
	WHERE Cur.Enabled = 1
	ORDER BY (Cur.Codigo);
END //
DELIMITER ;




