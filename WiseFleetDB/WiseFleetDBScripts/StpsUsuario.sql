-- PROCEDIMIENTO ALMACENADOS PARA USUARIO
-- Agregar
DELIMITER //
CREATE PROCEDURE stp_add_usuario(IN p_usuario NVARCHAR(25),
									IN p_contrasena NVARCHAR(25),
									IN p_permiso BOOL,
                                    IN p_idEmpleadoFK INT)
BEGIN
	INSERT INTO usuario (usuario, contrasena, permiso, idEmpleadoFK) 
    VALUES (p_usuario, p_contrasena, p_permiso, p_idEmpleadoFK);
END //
DELIMITER ;


-- Eliminar
DELIMITER //
CREATE PROCEDURE stp_remove_usuario(IN p_idUsuario INT)
BEGIN
	DECLARE idEmpleado INT;
    SELECT idEmpleadoFK INTO idEmpleado FROM usuario WHERE idUsuario = p_idUsuario;
	CALL stp_remove_empleado(idEmpleado);
    DELETE FROM usuario WHERE idUsuario = p_idUsuario;
END //
DELIMITER ;


-- Actualizar
DELIMITER //
CREATE PROCEDURE stp_update_usuario(IN p_usuario NVARCHAR(25),
									IN p_contrasena NVARCHAR(25),
									IN p_permiso BOOL,
                                    IN p_idEmpleadoFK INT,
                                    IN p_idUsuario INT)
BEGIN
	UPDATE usuario SET
		usuario = p_usuario,
        contrasena = p_contrasena,
        permiso = p_permiso,
        idEmpleadoFK = p_idEmpleadoFK
	WHERE
		idUsuario = p_idUsuario;
END //
DELIMITER ;


-- Buscar por id
DELIMITER //
CREATE PROCEDURE stp_lookByID_usuario(IN p_idUsuario INT)
BEGIN
	SELECT * FROM usuario WHERE idUsuario = p_idUsuario;
END //
DELIMITER ;


-- Buscar por usuario
DELIMITER //
CREATE PROCEDURE stp_lookByUsuario_usuario(IN p_usuario NVARCHAR(25))
BEGIN
	SELECT * FROM usuario WHERE usuario = p_usuario;
END //
DELIMITER ;


-- Buscar por empleado
DELIMITER //
CREATE PROCEDURE stp_lookByEmpleadoFK_usuario(IN p_idEmpleadFK INT)
BEGIN
	SELECT * FROM usuario WHERE idEmpleadoFK = p_idEmpleadoFK;
END //
DELIMITER ;

