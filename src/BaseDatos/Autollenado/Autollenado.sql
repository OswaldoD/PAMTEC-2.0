/*
Hacemos este autollenado para hacer pruebas
No es necesario de correr, pero la vagancia
no me deja meter datos a mano (:
*/

-- -----------------------------------------------------
-- Creamos una tabla auxiliar para insertar los nombres
-- que vamos a escoger aleatoriamente
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `pamtecdb`.`Nombres` (
  `IdNombre` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`IdNombre`))
ENGINE = InnoDB;

-- Insertamos todos los nombres, hay mas de 30
INSERT INTO Nombres (Nombre) VALUES ("Eliecer"), 
("Alex"),    ("Rosa"),      ("Juan"),
("Mateo"),   ("Felipe"),    ("Estefani"),
("Andrea"),  ("Jairo"),     ("Raquelle"),
("Angel"),   ("Cristiano"), ("Dominic"),
("Harry"),   ("Mario"),     ("Roberto"),
("David"),   ("Abraham"),   ("Maria Fernanda"),
("Fernando"),("Andrey"),    ("Jose"),
("Isabelle"),("Karol"),     ("Keren"),
("Kristel"), ("Daniel"),    ("Bill"),
("Isamel"),  ("Silvia"),    ("Adriana"),
("Luci"),   ("Angela"),     ("Alexander");


CREATE TABLE IF NOT EXISTS `pamtecdb`.`Apellidos1` (
  `IdApellido` INT NOT NULL AUTO_INCREMENT,
  `Apellido` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`IdApellido`))
ENGINE = InnoDB;

-- Insertamos todos los apellidos, hay mas de 33
INSERT INTO Apellidos1 (Apellido) VALUES ("Alán"), 
("Sanchez"),    ("Cascante"),  ("Alvarado"),
("Nuñez"),      ("Carillo"),   ("Contreras"),
("Guzman"),     ("Espinoza"),  ("Aguero"),
("Benzabidez"), ("Sandi"),     ("Bonilla"),
("Poter"),      ("Perez"),     ("Ortiz"),
("Obando"),     ("Lincoln"),   ("Fernandez"),
("Solis"),      ("Bustamante"),("Cascante"),
("Allende"),    ("Campos"),    ("Castillo"),
("Navarro"),    ("Cespedes"),  ("Carrillo"),
("Murillo"),    ("Fallas"),    ("Lopez"),
("Vargas"),     ("Viales"),    ("Mora");


CREATE TABLE IF NOT EXISTS `pamtecdb`.`Apellidos2` (
  `IdApellido` INT NOT NULL AUTO_INCREMENT,
  `Apellido` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`IdApellido`))
ENGINE = InnoDB;

-- Insertamos todos los segundos apellidos
INSERT INTO Apellidos2 (Apellido) VALUES ("Guiardia"), 
("Aguilar"),  ("Chacon"),    ("Iglesias"),
("Aguilera"), ("Diaz"),      ("Iniesta"),
("Alba"),     ("Duran"),     ("Juarez"),
("Barba"),    ("Escobar"),   ("Losa"),
("Bolaños"),  ("Ferrer"),    ("Marin"),
("Bravo"),    ("Fuentes"),   ("Mateus"),
("Bustos"),   ("Rios"),      ("Oviedo"),
("Calvo"),    ("Fuster"),    ("Olivares"),
("Cano"),     ("Granados"),  ("Ochoa"),
("Cervantes"),("Hernandez"), ("Peña"),
("Cortes"),   ("Herrero"),   ("Pereira");


-- -----------------------------------------------------
-- Creamos una tabla con los bits 1 y 0 para escoger con
-- un random entre esos dos valores y asignarlos a las 
--            entidades que les ocupen
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `pamtecdb`.`TablaBits`(
  `IdBit` INT NOT NULL AUTO_INCREMENT,
  `Valor` BIT NOT NULL,
  PRIMARY KEY(`IdBit`))
ENGINE = InnoDB;

-- Insertamos los bits que corresponden!
INSERT INTO TablaBits (Valor) VALUES 
(1) , (0);


-- -----------------------------------------------------
-- Creamos una tabla con fechas de registro al azar 
-- para asignar algunas fecha aleatorias a los usuarios
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pamtecdb`.`FechasRegistros`(
  `IdFechaNacimiento` BIGINT NOT NULL AUTO_INCREMENT,
  `FechaRegistro` DATE NOT NULL,
  PRIMARY KEY (`IdFechaNacimiento`))
ENGINE = InnoDB;

-- Algunas Fechas de registro
INSERT INTO FechasRegistros (FechaRegistro) VALUES
("2003-01-29"), ("2004-01-29"), ("2006-01-29"), 
("2005-01-29"), ("2005-06-05"), ("2006-01-20"),
("2007-01-29"), ("2008-08-05"), ("2008-02-09"),
("2009-05-15"), ("2009-07-29"), ("2009-12-29"),
("2010-03-29"), ("2010-08-11"), ("2010-11-25"), 
("2010-04-04"), ("2011-04-01"), ("2011-01-01"),
("2011-08-06"), ("2011-11-15"), ("2011-12-21"),
("2012-03-31"), ("2012-03-31"), ("2012-07-03"),  
("2013-05-05"), ("2013-07-16"), ("2013-01-05"),
("2013-08-08"), ("2013-12-12"), ("2013-05-12"),
("2014-01-29"), ("2014-03-29"); 


-- -----------------------------------------------------
-- 	Insertamos datos random!
-- -----------------------------------------------------

delimiter //

CREATE PROCEDURE meterCursoRandom(pIdEstudiante INT)
BEGIN

  	DECLARE _IdCurso INT;

	SELECT IdCurso FROM Cursos ORDER BY RAND() LIMIT 1 INTO _IdCurso;

	INSERT INTO EstudiantesPorCurso (Enabled, IdCurso, IdEstudiante)
	VALUES (
	  1, 
	  _IdCurso, 
	  pIdEstudiante);
end //

delimiter ;


-- -----------------------------------------------------
-- Procedure: generarCursosRandom
-- Entradas: cantidad INT
-- Salidas: void
-- Restricciones: cantidad >= 1
-- -----------------------------------------------------

delimiter //

CREATE PROCEDURE generarCursosRandom(pCantidad INT)
BEGIN
	DECLARE _lastCurso INT;
	DECLARE _postDate DATETIME;
	DECLARE contadorText VARCHAR(15);
	DECLARE _rand TINYINT;

	SELECT CURRENT_TIMESTAMP INTO _postDate;
	WHILE pCantidad > 0 DO 
		SET contadorText = CONVERT(pCantidad, CHAR(10));

		INSERT INTO Cursos (Nombre, Codigo, FechaCreacion, Detalles, Cupo, Enabled, NumeroGrupo)
		VALUES (
		  CONCAT("Curso", contadorText), 
		  CONCAT("C - ", contadorText), 
		  _postDate,
		  "Estos son los detalles... :)",
		  25,
		  1,
		  pCantidad);
		SET pCantidad = pCantidad - 1;
		END WHILE;
end //

delimiter ;

call generarCursosRandom(18);


-- -----------------------------------------------------
-- Procedure: generarEstudiantesRandom
-- Entradas: cantidad INT
-- Salidas: void
-- Restricciones: cantidad >= 1
-- -----------------------------------------------------

delimiter //

CREATE PROCEDURE generarEstudiantes(pCantidad INT)
BEGIN

  DECLARE _nombre VARCHAR(20);
  DECLARE _apellido1 VARCHAR(20);
  DECLARE _apellido2 VARCHAR(20);
  DECLARE _fecharegistro DATE;
  DECLARE contadorText CHAR(10);
  DECLARE _Rand TINYINT;
  DECLARE _idEstudianteCreado INT;

  WHILE pCantidad > 0 DO 
    SELECT Nombre FROM Nombres ORDER BY RAND() LIMIT 1 INTO _nombre;
    SELECT Apellido FROM Apellidos1 ORDER BY RAND() LIMIT 1 INTO _apellido1;
    SELECT Apellido FROM Apellidos2 ORDER BY RAND() LIMIT 1 INTO _apellido2;
    SELECT FechaRegistro FROM FechasRegistros ORDER BY RAND() LIMIT 1 INTO _fecharegistro;
    

    SET contadorText = CONVERT(pCantidad, CHAR(10));

    INSERT INTO Estudiantes (Nombre, Apellido1, Apellido2, email, FechaRegistro, Enabled, Telefono1, Telefono2, Cedula)
    VALUES (
      _nombre, 
      _apellido1, 
      _apellido2,
      CONCAT(_nombre,_apellido1,contadorText,"@gmail.com"),
      NOW(),
      1,
      "tel 1",
      "tel 2",
      CONCAT("CED - ", contadorText));
   
   	SELECT IdEstudiante from Estudiantes ORDER BY IdEstudiante desc limit 1 INTO _idEstudianteCreado;
   
   	-- Ahora vemos a ver si lo metemos a un curso...
   	SELECT (RAND()*10) into _rand;

   	IF _rand < 5 THEN call meterCursoRandom(_idEstudianteCreado);
	END IF;
   
   	SET pCantidad = pCantidad - 1;
   	END WHILE;
end //

delimiter ;

call generarEstudiantes(50);

-- -----------------------------------------------------
-- asignamos el colaborador a un curso; este mae no valida nada :)
-- -----------------------------------------------------
delimiter //
CREATE PROCEDURE generarColaboradorPorCurso (pIdColaborador INT)
BEGIN
	DECLARE _IdCurso INT;

	SELECT IdCurso FROM Cursos ORDER BY RAND() LIMIT 1 INTO _IdCurso;

	INSERT INTO ColaboradoresPorCurso (Enabled, IdCurso, IdColaborador)
	VALUES (
	  1, 
	  _IdCurso, 
	  pIdColaborador);

END //
delimiter ;


-- -----------------------------------------------------
-- 	Insertamos colaboradores
-- -----------------------------------------------------

delimiter //

CREATE PROCEDURE generarColaboradores(pCantidad INT)
BEGIN 
  DECLARE _nombre VARCHAR(20);
  DECLARE _apellido1 VARCHAR(20);
  DECLARE _apellido2 VARCHAR(20);
  DECLARE _fecharegistro DATE;
  DECLARE contadorText CHAR(10);
  DECLARE _Rand TINYINT;
  DECLARE _idRol TINYINT;
  DECLARE _idColaboradorCreado INT;

  WHILE pCantidad > 0 DO 
    SELECT Nombre FROM Nombres ORDER BY RAND() LIMIT 1 INTO _nombre;
    SELECT Apellido FROM Apellidos1 ORDER BY RAND() LIMIT 1 INTO _apellido1;
    SELECT Apellido FROM Apellidos2 ORDER BY RAND() LIMIT 1 INTO _apellido2;
    SELECT FechaRegistro FROM FechasRegistros ORDER BY RAND() LIMIT 1 INTO _fecharegistro;
	SELECT IdRol FROM Roles ORDER BY RAND() LIMIT 1 INTO _idRol;

    SET contadorText = CONVERT(pCantidad, CHAR(10));

    INSERT INTO Colaboradores (Nombre, Apellido1, Apellido2, email, FechaRegistro, Enabled, IdRol)
    VALUES(
      _nombre, 
      _apellido1, 
      _apellido2,
      CONCAT(_nombre,_apellido1,contadorText,"@gmail.com"),
      NOW(),
      1,
      _idRol);
   
   	SELECT IdColaborador from Colaboradores ORDER BY IdColaborador desc limit 1 INTO _idColaboradorCreado;
   
   	-- Ahora vemos a ver si lo asignamos a un curso o no
   	SELECT (RAND()*10) into _rand;

   	IF _rand < 5 THEN CALL generarColaboradorPorCurso(_idColaboradorCreado);
	END IF;
   
   	SET pCantidad = pCantidad - 1;
   	END WHILE;
END //

delimiter ;


call generarColaboradores(25);