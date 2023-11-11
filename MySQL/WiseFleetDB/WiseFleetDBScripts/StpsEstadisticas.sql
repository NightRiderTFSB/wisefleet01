-- PROCEDIMIENTOS ALMACENADOS PARA ESTADISTICAS

-- Agregar
DELIMITER //
CREATE PROCEDURE stp_add_estadisticas(IN p_celcius DOUBLE(5,2),
										IN p_ubicacion NVARCHAR(50),
                                        IN p_bateria NVARCHAR(30),
                                        IN p_idVehiculoFK INT)
BEGIN
	INSERT INTO estadisticas (celcius, ubicacion, bateria, idVehiculoFK)
    VALUES (p_celcius, p_ubicacion, p_bateria, p_idVehiculoFK);
END //
DELIMITER ;

CALL stp_add_estadisticas(100, '21°00''43.7"N 101°51''04.5"W', '95%', 3);

SELECT * FROM vehiculo;
SELECT * FROM estadisticas;

-- Eliminar
DELIMITER //
CREATE PROCEDURE stp_remove_estadisticas(IN p_idEstadistica INT)
BEGIN
	DELETE FROM estadisticas WHERE idEstadistica = p_idEstadistica;
END //
DELIMITER ;

CALL stp_remove_estadisticas(1)


-- Buscar por vehiculo

DELIMITER //
CREATE PROCEDURE stp_lookByVehiculo_estadisticas(IN p_idVehiculoFK INT)
BEGIN
	SELECT * FROM estadisticas WHERE idVehiculoFK = p_idVehiculoFK;
END //
DELIMITER ;

CALL stp_lookByVehiculo_estadisticas(3);