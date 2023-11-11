-- PROCEDIMIENTOS ALMACENADOS PARA ESTADISTICAS

-- AGREGAR
CREATE OR REPLACE FUNCTION stp_add_estadistica(
	p_celcius FLOAT,
	p_ubicacion VARCHAR(50),
	p_bateria VARCHAR(30),
	p_idVehiculoFK INT
)RETURNS VOID AS $$
BEGIN
	INSERT INTO estadisticas (celcius, ubicacion, bateria, idvehiculofk)
	VALUES (p_celcius, p_ubicacion, p_bateria, p_idVehiculoFK);
END;
$$ LANGUAGE plpgsql;

-- ELIMINAR
CREATE OR REPLACE FUNCTION stp_remove_estadistica(
	p_idEstadistica INT
)RETURNS VOID AS $$
BEGIN
	DELETE FROM estadisticas WHERE idEstadistica = p_idEstadistica;
END;
$$ LANGUAGE plpgsql;

-- ACTUALIZAR
CREATE OR REPLACE FUNCTION stp_update_estadistica(
	p_celcius FLOAT,
	p_ubicacion VARCHAR(50),
	p_bateria VARCHAR(30),
	p_idVehiculoFK INT,
	p_idEstadistica INT
)RETURNS VOID AS $$
BEGIN
	UPDATE estadisticas
	SET
		celcius = p_celcius,
		ubicacion = p_ubicacion,
		bateria = p_bateria,
		idVehiculoFK = p_idVehiculoFK
	WHERE
		idEstadistica = p_idEstadistica;
END;
$$ LANGUAGE plpgsql;

-- BUSCAR POR ID
CREATE OR REPLACE FUNCTION stp_lookByID_estadistica(
	p_idEstadistica INT
)RETURNS TABLE(
	idEstadistica INT,
	celcius FLOAT,
	ubicacion VARCHAR(50),
	bateria VARCHAR(30),
	idVehiculoFK INT
)AS $$
BEGIN
	RETURN QUERY
	SELECT * FROM estadisticas WHERE idEstadistica = p_idEstadistica;
END;
$$ LANGUAGE plpgsql;

-- BUSCAR POR VEHICULO
CREATE OR REPLACE FUNCTION stp_lookByVehiculo_estadistica(
	p_idVehiculoFK INT
)RETURNS TABLE(
	idEstadistica INT,
	celcius FLOAT,
	ubicacion VARCHAR(50),
	bateria VARCHAR(30),
	idVehiculoFK INT
)AS $$
BEGIN
	RETURN QUERY
	SELECT * FROM estadisticas WHERE idVehiculoFK = p_idVehiculoFK;
END;
$$ LANGUAGE plpgsql;
