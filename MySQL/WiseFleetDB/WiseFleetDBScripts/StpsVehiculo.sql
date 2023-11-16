-- METODOS ALMACENADOS PARA TABLA VEHICULO

-- Agregar
DELIMITER //
CREATE PROCEDURE stp_add_vehiculo (IN p_modelo NVARCHAR(50), 
									IN p_ano NVARCHAR(4), 
                                    IN p_color NVARCHAR(30), 
                                    IN p_placas NVARCHAR(20), 
                                    IN p_numTarjeta NVARCHAR(10),
                                    IN p_rendimientoKmsLt DOUBLE(5,2),
                                    IN p_disponible BOOL)
BEGIN
	INSERT INTO vehiculo(modelo, ano, color, placas, numTarjeta, rendimientoKmsLt, disponible) 
    VALUES (p_modelo, p_ano, p_color, p_placas, p_numTarjeta, p_rendimientoKmsLt, p_disponible);
END //
DELIMITER ;

CALL stp_add_vehiculo('SPTFIRE 200', '2020', 'VERDE', '48EHC9', 'G01573519', 27.00, TRUE);
SELECT * FROM vehiculo;


-- Eliminar
DELIMITER //
CREATE PROCEDURE stp_remove_vehiculo(IN p_idVehiculo INT)
BEGIN
	DELETE FROM estadisticas WHERE idVehiculoFK = p_idVehiculo;
    DELETE FROM reportes WHERE idVehiculoFK = p_idVehiculo;
	DELETE FROM vehiculo WHERE idVehiculo = p_idVehiculo;
END //
DELIMITER ;

CALL stp_remove_vehiculo(2);


-- Actualizar
DELIMITER //
CREATE PROCEDURE stp_update_vehiculo(IN p_modelo NVARCHAR(50), 
									IN p_ano NVARCHAR(4), 
                                    IN p_color NVARCHAR(30), 
                                    IN p_placas NVARCHAR(20), 
                                    IN p_numTarjeta NVARCHAR(10),
                                    IN p_rendimientoKmsLt DOUBLE(5,2),
                                    IN p_disponible BOOL,
                                    IN p_idVehiculo INT)
BEGIN
	UPDATE vehiculo SET
		modelo = p_modelo,
		ano = p_ano,
		color = p_color,
		placas = p_placas,
		numTarjeta = p_numTarjeta,
		rendimientoKmsLt = p_rendimientoKmsLt,
		disponible = p_disponible
    WHERE
		idVehiculo = p_idVehiculo;
END //
DELIMITER ;

CALL stp_update_vehiculo('SPTFIRE 200', '2020', 'VERDE', '48EHC9', 'G01573519', 27.00, FALSE, 3);


-- BuscarPorID
DELIMITER //
CREATE PROCEDURE stp_lookByID_vehiculo(IN p_idVehiculo INT)
BEGIN
	SELECT * FROM vehiculo WHERE idVehiculo = p_idVehiculo;
END //
DELIMITER ;

CALL stp_lookByID_vehiculo(3);


-- BuscarPorPlaca
DELIMITER //
CREATE PROCEDURE stp_lookByPlacas_vehiculo(IN p_placas NVARCHAR(20))
BEGIN
	SELECT * FROM vehiculo WHERE placas = p_placas;
END //
DELIMITER ;

CALL stp_lookByPlacas_vehiculo('48EHC9');

-- BuscarPorModelo
-- BuscarPorNumTarjeta