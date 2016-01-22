SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `pamtecdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `pamtecdb` ;

-- -----------------------------------------------------
-- Table `pamtecdb`.`Estudiantes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pamtecdb`.`Estudiantes` (
  `IdEstudiante` INT NOT NULL,
  `Nombre` VARCHAR(25) NOT NULL,
  `Apellido1` VARCHAR(25) NOT NULL,
  `Apellido2` VARCHAR(25) NOT NULL,
  `Cedula` VARCHAR(45) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `FechaRegistro` DATE NOT NULL,
  `Enabled` BIT NOT NULL,
  `Telefono1` VARCHAR(16) NOT NULL,
  `Telefono2` VARCHAR(16) NULL,
  PRIMARY KEY (`IdEstudiante`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pamtecdb`.`Cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pamtecdb`.`Cursos` (
  `IdCurso` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(20) NOT NULL,
  `Enabled` BIT NOT NULL,
  `Codigo` VARCHAR(10) NOT NULL,
  `FechaCreacion` DATETIME NOT NULL,
  `Detalles` VARCHAR(200) NOT NULL,
  `Cupo` TINYINT NOT NULL,
  `NumeroGrupo` TINYINT NOT NULL,
  PRIMARY KEY (`IdCurso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pamtecdb`.`EstudiantesPorCurso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pamtecdb`.`EstudiantesPorCurso` (
  `Enabled` BIT NOT NULL,
  `IdCurso` INT NOT NULL,
  `IdEstudiante` INT NOT NULL,
  INDEX `fk_EstudiantesPorCurso_Cursos_idx` (`IdCurso` ASC),
  INDEX `fk_EstudiantesPorCurso_Estudiantes1_idx` (`IdEstudiante` ASC),
  CONSTRAINT `fk_EstudiantesPorCurso_Cursos`
    FOREIGN KEY (`IdCurso`)
    REFERENCES `pamtecdb`.`Cursos` (`IdCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EstudiantesPorCurso_Estudiantes1`
    FOREIGN KEY (`IdEstudiante`)
    REFERENCES `pamtecdb`.`Estudiantes` (`IdEstudiante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pamtecdb`.`Roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pamtecdb`.`Roles` (
  `IdRol` TINYINT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(20) NOT NULL,
  `Enabled` BIT NOT NULL,
  PRIMARY KEY (`IdRol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pamtecdb`.`Colaboradores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pamtecdb`.`Colaboradores` (
  `IdColaborador` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(20) NOT NULL,
  `Apellido1` VARCHAR(20) NOT NULL,
  `Apellido2` VARCHAR(20) NOT NULL,
  `Enabled` BIT NOT NULL,
  `Correo` VARCHAR(50) NOT NULL,
  `FechaRegistro` VARCHAR(45) NOT NULL,
  `IdRol` TINYINT NOT NULL,
  PRIMARY KEY (`IdColaborador`),
  INDEX `fk_Colaboradores_Roles1_idx` (`IdRol` ASC),
  CONSTRAINT `fk_Colaboradores_Roles1`
    FOREIGN KEY (`IdRol`)
    REFERENCES `pamtecdb`.`Roles` (`IdRol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pamtecdb`.`ColaboradoresPorCurso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pamtecdb`.`ColaboradoresPorCurso` (
  `Enabled` BIT NOT NULL,
  `IdCurso` INT NOT NULL,
  `IdColaborador` INT NOT NULL,
  INDEX `fk_ColaboradoresPorCurso_Colaboradores1_idx` (`IdColaborador` ASC),
  CONSTRAINT `fk_ColaboradoresPorCurso_Cursos1`
    FOREIGN KEY (`IdCurso`)
    REFERENCES `pamtecdb`.`Cursos` (`IdCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ColaboradoresPorCurso_Colaboradores1`
    FOREIGN KEY (`IdColaborador`)
    REFERENCES `pamtecdb`.`Colaboradores` (`IdColaborador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pamtecdb`.`NivelesDeSeveridad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pamtecdb`.`NivelesDeSeveridad` (
  `IdNivelDeSeveridad` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`IdNivelDeSeveridad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pamtecdb`.`TiposDeEvento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pamtecdb`.`TiposDeEvento` (
  `IdTipoEvento` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(50) NOT NULL,
  `IdNivelDeSeveridad` INT NOT NULL,
  PRIMARY KEY (`IdTipoEvento`),
  INDEX `fk_TiposDeEvento_NivelesDeSeveridad1_idx` (`IdNivelDeSeveridad` ASC),
  CONSTRAINT `fk_TiposDeEvento_NivelesDeSeveridad1`
    FOREIGN KEY (`IdNivelDeSeveridad`)
    REFERENCES `pamtecdb`.`NivelesDeSeveridad` (`IdNivelDeSeveridad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = swe7;


-- -----------------------------------------------------
-- Table `pamtecdb`.`BitacoraEventos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pamtecdb`.`BitacoraEventos` (
  `IdBitacora` BIGINT NOT NULL,
  `Descripcion` VARCHAR(600) NOT NULL,
  `Fecha` DATETIME NOT NULL,
  `UserName` VARCHAR(50) NOT NULL,
  `ComputerName` VARCHAR(80) NOT NULL,
  `PostDate` DATETIME NOT NULL,
  `CheckSum` VARBINARY(500) NOT NULL,
  `Referencia1` VARCHAR(70) NOT NULL,
  `Referencia2` VARCHAR(70) NOT NULL,
  `IdTipoEvento` INT NOT NULL,
  `BitacoraEventoscol` VARCHAR(45) NULL,
  `BitacoraEventoscol1` VARCHAR(45) NULL,
  PRIMARY KEY (`IdBitacora`),
  INDEX `fk_BitacoraEventos_TiposDeEvento1_idx` (`IdTipoEvento` ASC),
  CONSTRAINT `fk_BitacoraEventos_TiposDeEvento1`
    FOREIGN KEY (`IdTipoEvento`)
    REFERENCES `pamtecdb`.`TiposDeEvento` (`IdTipoEvento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pamtecdb`.`RolesUsuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pamtecdb`.`RolesUsuarios` (
  `IdRol` TINYINT NOT NULL AUTO_INCREMENT,
  `Rol` VARCHAR(45) NOT NULL,
  `Enabled` BIT NOT NULL,
  PRIMARY KEY (`IdRol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pamtecdb`.`UsuariosSistema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pamtecdb`.`UsuariosSistema` (
  `IdUsuario` INT NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(45) NOT NULL,
  `Password` BINARY(180) NOT NULL,
  `Enabled` BIT NOT NULL,
  `IdRol` TINYINT NOT NULL,
  PRIMARY KEY (`IdUsuario`),
  INDEX `fk_UsuariosSistema_RolesUsuarios1_idx` (`IdRol` ASC),
  CONSTRAINT `fk_UsuariosSistema_RolesUsuarios1`
    FOREIGN KEY (`IdRol`)
    REFERENCES `pamtecdb`.`RolesUsuarios` (`IdRol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
