-- PROCEDIMIENTOS ALMACENADOS PARA EMPLEADOS

-- AGREGAR
CREATE OR REPLACE FUNCTION stp_add_empleado(
	p_nombre VARCHAR(50),
	p_apellidoP VARCHAR(50),
	p_apellidoM VARCHAR(40),
	p_numLicencia VARCHAR(12),
	p_telefono VARCHAR(10)
)RETURNS VOID AS $$
BEGIN
	INSERT INTO empleado(nombre, apellidop, apellidom, numlicencia, telefono)
	VALUES (p_nombre, p_apellidoP, p_apellidoM, p_numLicencia, p_telefono);
END;
$$ LANGUAGE plpgsql;

-- ELIMINAR
CREATE OR REPLACE FUNCTION stp_remove_empleado(
	p_idEmpleado INT
)RETURNS VOID AS $$
BEGIN
	DELETE FROM empleado WHERE idEmpleado = p_idEmpleado;
END;
$$ LANGUAGE plpgsql;

-- ACTUALIZAR
CREATE OR REPLACE FUNCTION stp_update_empleado(
	p_nombre VARCHAR(50),
	p_apellidoP VARCHAR(50),
	p_apellidoM VARCHAR(40),
	p_numLicencia VARCHAR(12),
	p_telefono VARCHAR(10),
	p_idEmpleado INT
)RETURNS VOID AS $$
BEGIN
	UPDATE empleado
	SET	
		nombre = p_nombre,
		apellidoP = p_apellidoP,
		apellidoM = p_apellidoM,
		numLicencia = p_numLicencia,
		telefono = p_telefono
	WHERE
		idEmpleado = p_idEmpleado;
END;
$$ LANGUAGE plpgsql;

-- BUSCAR POR ID
CREATE OR REPLACE FUNCTION stp_lookByID_empleado(
	p_idEmpleado INT
)RETURNS TABLE(
	idEmpleado INT,
	usuario VARCHAR(50),
	apellidoP VARCHAR(50),
	apellidoM VARCHAR(40),
	numLicencia VARCHAR(12),
	telefono VARCHAR(10)
)AS $$
BEGIN
	RETURN QUERY
	SELECT * FROM empleado WHERE idEmpleado = p_idEmpleado;
END;
$$ LANGUAGE plpgsql;

-- BUSCAR POR NUM LICENCIA
CREATE OR REPLACE FUNCTION stp_lookByLicencia_empleado(
	p_numLicencia VARCHAR(12)
)RETURNS TABLE(
	idEmpleado INT,
	usuario VARCHAR(50),
	apellidoP VARCHAR(50),
	apellidoM VARCHAR(40),
	numLicencia VARCHAR(12),
	telefono VARCHAR(10)
)AS $$
BEGIN
	RETURN QUERY
	SELECT * FROM empleado WHERE numLicencia = p_numLicencia;
END;
$$ LANGUAGE plpgsql;