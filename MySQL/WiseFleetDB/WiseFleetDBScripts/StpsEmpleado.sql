-- PROCEDIMIENTOS ALMACENADOS EMPLEADO

-- Agregar
DELIMITER //
CREATE PROCEDURE stp_add_empleado(IN p_nombre NVARCHAR(50),
									IN p_apellidoP NVARCHAR(50),
                                    IN p_apellidoM NVARCHAR(50),
                                    IN p_numLicencia NVARCHAR(12),
                                    IN p_telefono NVARCHAR(10))
BEGIN
	INSERT INTO empleado (nombre, apellidoP, apellidoM, numLicencia, telefono)
    VALUES (p_nombre, p_apellidoP, p_apellidoM, p_numLicencia, p_telefono);
END //
DELIMITER ;


-- Eliminar
DELIMITER //
CREATE PROCEDURE stp_remove_empleado(IN p_idEmpleado INT)
BEGIN
	DELETE FROM reportes WHERE idEmpleadoFK = p_idEmpleado;
    DELETE FROM pedidos WHERE idEmpleadoFK = p_idEmpleado;
    DELETE FROM usuario WHERE idEmpleadoFK = p_idEmpleado;
	DELETE FROM empleado WHERE idEmpleado = p_idEmpleado;
END //
DELIMITER ;


-- Actualizar
DELIMITER //
CREATE PROCEDURE stp_update_empleado(IN p_nombre NVARCHAR(50),
									IN p_apellidoP NVARCHAR(50),
                                    IN p_apellidoM NVARCHAR(50),
                                    IN p_numLicencia NVARCHAR(12),
                                    IN p_telefono NVARCHAR(10),
                                    IN p_idEmpleado INT)
BEGIN
	UPDATE empleado SET
		nombre = p_nombre,
        apellidoP = p_apellidoP,
        apellidoM = p_apellidoM,
        numLicencia = p_numLicencia,
        telefono = p_telefono
	WHERE
		idEmpleado = p_idEmpleado;
END //
DELIMITER ;


-- Buscar por id
DELIMITER //
CREATE PROCEDURE stp_lookByID_empleado(IN p_idEmpleado INT)
BEGIN
	SELECT * FROM empleado WHERE idEmpleado = p_idEmpleado;
END //
DELIMITER ;

-- Buscar por licencia
DELIMITER //
CREATE PROCEDURE stp_lookByNumLicencia_empleado(IN p_numLicencia NVARCHAR(12))
BEGIN
	SELECT * FROM empleado WHERE numLicencia = p_numLicencia;
END //
DELIMITER ;

-- Buscar por telefono
DELIMITER //
CREATE PROCEDURE stp_lookByTelefono_empleado(IN p_telefono NVARCHAR(10))
BEGIN
	SELECT * FROM empleado WHERE telefono = p_telefono;
END //
DELIMITER ;








