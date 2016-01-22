-- -----------------------------------------------------
-- Procedure: IniciarSesion
-- Entradas: pNombre VARCHAR(50)
-- Salidas: 1 si es
--			0 si no es
-- Restricciones: El nombre del usuario ya tuvo que haber
-- sido comprobado
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE IniciarSesion(pNombre VARCHAR(50), pContrasena VARCHAR (50))
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkUsuario INT;
	DECLARE _contraCheck VARBINARY(180);
	DECLARE _passwordBinary VARBINARY(180);

	SELECT IdUsuario FROM UsuariosSistema WHERE Username = pNombre AND Enabled = 1 INTO _checkUsuario;
	SELECT CONVERT(MD5(pContrasena), BINARY(180)) INTO _passwordBinary;
	SELECT Password FROM UsuariosSistema WHERE UserName = pNombre AND Enabled = 1 INTO _contraCheck;
	SELECT _contraCheck;
	SELECT _passwordBinary;
	IF _contraCheck=_passwordBinary THEN
		SET _Bit =1;
	END IF;
  SELECT _Bit;
END //
DELIMITER ;


-- -----------------------------------------------------
-- Procedure: InsertarUsuario
-- Entradas: pNombre VARCHAR(50)
-- Salidas: 1 si lo metio
--			0 si no lo metio
-- Restricciones: El nombre del usuario ya tuvo que haber
-- sido comprobado su existencia
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE InsertarUsuario(pNombre VARCHAR(50), pContrasena VARCHAR (50), pRolUsuario VARCHAR(50))
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkRol TINYINT;

	SELECT IdRol FROM RolesUsuarios WHERE Rol = pRolUsuario AND Enabled = 1 INTO _checkRol;

	IF _checkRol IS NOT NULL THEN
		INSERT INTO UsuariosSistema (UserName, Password, Enabled, IdRol) VALUES
									(pNombre, MD5(pContrasena), 1, _checkRol);
		SET _Bit = 1;
	END IF;
  SELECT _Bit;
END //
DELIMITER ;


-- -----------------------------------------------------
-- Procedure: InsertarUsuario
-- Entradas: pNombre VARCHAR(50)
-- Salidas: 1 si lo ELIMINO
--			0 si no lo ELIMINO
-- Restricciones: El nombre del usuario ya tuvo que haber
-- sido comprobado su existencia
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE EliminarUsuario(pNombre VARCHAR(50))
BEGIN
	DECLARE _Bit BIT DEFAULT 0;
	DECLARE _checkUsuario TINYINT;

	SELECT IdUsuario FROM UsuariosSistema WHERE Username = pNombre AND Enabled = 1 INTO _checkUsuario;

	IF _checkUsuario IS NOT NULL THEN
		UPDATE UsuariosSistema SET Enabled = 0 WHERE IdUsuario = _checkUsuario AND Enabled = 1;
		SET _Bit = 1;
	END IF;
  SELECT _Bit;
END //
DELIMITER ;