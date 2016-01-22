/*
Estos datos son los que deben de ir empotrados a 
comienzos de la BD :)

No soporta eñes (ñ)
*/

-- -----------------------------------------------------
-- Insertamos los niveles de severidad
-- -----------------------------------------------------
INSERT INTO NivelesDeSeveridad (Nombre) VALUES
("Error"), ("Fatal"), ("Exitoso"), ("Fallido"), ("Incompleto");

-- -----------------------------------------------------
-- Insertamos los tipos de evento
-- -----------------------------------------------------
INSERT INTO TiposDeEvento (Nombre, IdNivelDeSeveridad) VALUES
("Iniciar Sesion", 3);

-- -----------------------------------------------------
-- Insertamos los roles
-- -----------------------------------------------------
INSERT INTO Roles (Nombre, Enabled) VALUES
("Profesor", 1), ("Asistente", 1);

-- -----------------------------------------------------
-- Insertamos el usuario admin y el rol
-- -----------------------------------------------------
INSERT INTO RolesUsuarios (Rol, Enabled) VALUES ("Administrador", 1);
INSERT INTO UsuariosSistema (Username, Password, Enabled, IdRol) VALUES
("admina", MD5("admin"), 1, 1);
