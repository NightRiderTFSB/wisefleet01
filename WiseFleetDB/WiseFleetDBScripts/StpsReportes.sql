-- PROCEDIMIENTOS ALMACENADOS PARA REPORTES

-- Agregar
DELIMITER //
CREATE PROCEDURE stp_add_reportes(IN p_descripcion NVARCHAR(100),
									IN p_idVehiculoFK INT,
                                    IN p_idEmpleadoFK INT)
BEGIN
	INSERT INTO reportes (descripcion, idVehiculoFK, idEmpleadoFK) 
    VALUES (p_descripcion, p_idVehiculoFK, p_idEmpleadoFK);
END //
DELIMITER ;

-- Eliminar
DELIMITER //
CREATE PROCEDURE stp_remove_reportes(IN p_idReporte INT)
BEGIN
	DELETE FROM reportes WHERE idReporte = p_idReporte;
END //
DELIMITER ;

-- Actualizar
DELIMITER //
CREATE PROCEDURE stp_update_reportes(IN p_descripcion NVARCHAR(100),
									IN p_idVehiculoFK INT,
                                    IN p_idEmpleadoFK INT,
									IN p_idReporte INT)
BEGIN
	UPDATE reportes SET
		descripcion = p_descripcion,
        idVehiculo = p_idVehiculo,
        idEmpleado = p_idEmpleado
	WHERE
		idReporte = p_idReporte;

END //
DELIMITER ;


-- Buscar por vehiculo
DELIMITER //
CREATE PROCEDURE stp_lookByVehiculo_reportes(IN p_idVehiculoFK INT)
BEGIN
	SELECT * FROM reportes WHERE idVehiculoFK = p_idVehiculoFK;
END //
DELIMITER ;


-- Buscar por empleado
DELIMITER //
CREATE PROCEDURE stp_lookByEmpleado_reportes(IN p_idEmpleadoFK INT)
BEGIN
	SELECT * FROM reportes WHERE idEmpleadoFK = p_idEmpleadoFK;
END // 
DELIMITER ;
