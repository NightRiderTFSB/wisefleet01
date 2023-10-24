-- PROCEDIMIENTOS ALMACENADOS PARA REPORTES

-- AGREGAR
CREATE OR REPLACE FUNCTION stp_add_reporte(
	p_descripcion VARCHAR(100),
	p_idVehiculoFK INT,
	p_idEmpleadoFK INT
)RETURNS VOID AS $$
BEGIN
	INSERT INTO reportes(descripcion, idvehiculofk, idempleadofk)
	VALUES(p_descripcion, p_idVehiculoFK, p_idEmpleadoFK);
END;
$$ LANGUAGE plpgsql;

-- ELIMINAR
CREATE OR REPLACE FUNCTION stp_remove_reporte(
	p_idReporte INT
)RETURNS VOID AS $$
BEGIN
	DELETE FROM reportes WHERE idReporte = p_idReporte;
END;
$$ LANGUAGE plpgsql;

-- ACTUALIZAR
CREATE OR REPLACE FUNCTION stp_update_reporte(
	p_descripcion VARCHAR(100),
	p_idVehiculoFK INT,
	p_idEmpleadoFK INT,
	p_idReporte INT
)RETURNS VOID AS $$
BEGIN
	UPDATE reportes
	SET
		descripcion = p_descripcion,
		idVehiculoFK = p_idVehiculoFK,
		idEmpleadoFK = p_idEmpleadoFK
	WHERE
		idReporte = p_idReporte;
END;
$$ LANGUAGE plpgsql;

-- BUSCAR POR ID
CREATE OR REPLACE FUNCTION stp_lookbyid_reporte(
	p_idReporte INT
)RETURNS TABLE(
	idReporte INT,
	descripcion VARCHAR(100),
	idVehiculoFK INT,
	idEmpleadoFK INT
)AS $$
BEGIN
	RETURN QUERY
	SELECT * FROM reportes WHERE idReporte = p_idReporte;
END;
$$ LANGUAGE plpgsql;

-- BUSCAR POR VEHICULO
CREATE OR REPLACE FUNCTION stp_lookbyvehiculo_reporte(
	p_idVehiculoFK INT
)RETURNS TABLE(
	idReporte INT,
	descripcion VARCHAR(100),
	idVehiculoFK INT,
	idEmpleadoFK INT
)AS $$
BEGIN
	RETURN QUERY
	SELECT * FROM reportes WHERE idVehiculoFK = p_idVehiculoFK;
END;
$$ LANGUAGE plpgsql;

-- BUSCAR POR EMPLEADO
CREATE OR REPLACE FUNCTION stp_lookbyEmpleado_reporte(
	p_idEmpleadoFK INT
)RETURNS TABLE(
	idReporte INT,
	descripcion VARCHAR(100),
	idVehiculoFK INT,
	idEmpleadoFK INT
)AS $$
BEGIN
	RETURN QUERY
	SELECT * FROM reportes WHERE idEmpleadoFK = p_idEmpleadoFK;
END;
$$ LANGUAGE plpgsql;
