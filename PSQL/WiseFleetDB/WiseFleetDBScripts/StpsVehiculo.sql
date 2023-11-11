-- METODOS ALMACENADOS PARA VEHICULOS

-- AGREGAR
CREATE OR REPLACE FUNCTION stp_add_vehiculo(
	p_modelo VARCHAR(50),
	p_ano VARCHAR(4),
	p_color VARCHAR(30),
	p_placas VARCHAR(10),
	p_numTarjeta VARCHAR(10),
	p_rendimientoKmsLt FLOAT,
	p_disponible BOOL
)RETURNS VOID AS $$
BEGIN
	INSERT INTO vehiculo(modelo, ano, color, placas, numTarjeta, rendimientoKmsLt, disponible)
	VALUES (p_modelo, p_ano, p_color, p_placas, p_numTarjeta, p_rendimientoKmsLt, p_disponible);
END;
$$ LANGUAGE plpgsql;


-- ELIMINAR
CREATE OR REPLACE FUNCTION stp_remove_vehiculo(
	p_idVehiculo INT
)RETURNS VOID AS $$
BEGIN
	DELETE FROM vehiculo WHERE idVehicilo = p_idVehiculo;
END;
$$ LANGUAGE plpgsql;


-- ACTUALIZAR
CREATE OR REPLACE FUNCTION stp_update_vehiculo(
	p_modelo VARCHAR(50),
	p_ano VARCHAR(4),
	p_color VARCHAR(30),
	p_placas VARCHAR(10),
	p_numTarjeta VARCHAR(10),
	p_rendimientoKmsLt FLOAT,
	p_disponible BOOL,
	p_idVehiculo INT
)RETURNS VOID AS $$
BEGIN
	UPDATE vehiculo 
	SET
		modelo = p_modelo,
		ano = p_ano,
		color = p_color,
		placas = p_placas,
		numTarjeta = p_numTarjeta,
		rendimientoKmsLt = p_rendimientoKmsLt,
		disponible = p_disponible
	WHERE
		idVehiculo = p_idVehiculo;
END;
$$ LANGUAGE plpgsql;


-- BUSCAR POR ID
CREATE OR REPLACE FUNCTION stp_lookByID_vehiculo(
	p_idVehiculo INT
)RETURNS TABLE(
	idVehiculo INT,
	modelo VARCHAR(50),
	ano VARCHAR(4),
	color VARCHAR(30),
	placas VARCHAR(20),
	numTarjeta VARCHAR(10),
	rendimientoKmsLt FLOAT,
	disponible BOOL
)AS $$
BEGIN
	RETURN QUERY 
	SELECT * FROM vehiculo WHERE idVehiculo = p_idVehiculo;
END;
$$ LANGUAGE plpgsql;

-- BUSCAR POR PLACAS
CREATE OR REPLACE FUNCTION stp_lookByPlacas_vehiculo(
	p_placas VARCHAR(20)
)RETURNS TABLE(
	idVehiculo INT,
	modelo VARCHAR(50),
	ano VARCHAR(4),
	color VARCHAR(30),
	placas VARCHAR(20),
	numTarjeta VARCHAR(10),
	rendimientoKmsLt FLOAT,
	disponible BOOL
)AS $$
BEGIN
	RETURN QUERY 
	SELECT * FROM vehiculo WHERE placas = p_placas;
END;
$$ LANGUAGE plpgsql;


-- BUSCAR POR NUM TARJETA
-- pendiente

-- BUSCAR POR MODELO
-- pendiente