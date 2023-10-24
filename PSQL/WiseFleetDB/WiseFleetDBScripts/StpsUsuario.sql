-- PROCEDIMIENTOS ALMACENADOS PARA USUARIO

-- AGREGAR
CREATE OR REPLACE FUNCTION spt_add_usuario(
	p_usuario VARCHAR(25),
	p_contrasena VARCHAR(25),
	p_permiso BOOL,
	p_idEmpleadoFK INT
)RETURNS VOID AS $$
BEGIN
	INSERT INTO usuario(usuario, contrasena, permiso, idempleadofk)
	VALUES (p_usuario, p_contrasena, p_permiso, p_idEmpleadoFK);
END;
$$ LANGUAGE plpgsql;

-- ELIMINAR
CREATE OR REPLACE FUNCTION stp_remove_usuario(
	p_idUsuario INT
)RETURNS VOID AS $$
BEGIN
	DELETE FROM usuario WHERE idUsuario = p_idUsuario;
END;
$$ LANGUAGE plpgsql;


-- ACTUALIZAR
CREATE OR REPLACE FUNCTION stp_update_usuario(
	p_usuario VARCHAR(25),
	p_contrasena VARCHAR(25),
	p_permiso BOOL,
	p_idEmpleadoFK INT,
	p_idUsuario INT
)RETURNS VOID AS $$
BEGIN
	UPDATE usuario
	SET
		usuario = p_usuario,
		contrasena = p_contrasena,
		permiso = p_permiso,
		idEmpleadoFK = p_idEmpleadoFK
	WHERE
		idUsuario = p_idUsuario;
END;
$$ LANGUAGE plpgsql;


-- BUSCAR POR ID
CREATE OR REPLACE FUNCTION stp_lookByID_usuario(
	p_idUsuario INT
)RETURNS TABLE(
	idUsuario INT,
	usuario VARCHAR(25),
	contrasena VARCHAR(25),
	permiso BOOL,
	idEmpleadoFK INT
)AS $$
BEGIN
	RETURN QUERY
	SELECT * FROM usuario WHERE idUsuario = p_idUsuario;
END;
$$ LANGUAGE plpgsql;


-- BUSCAR POR USUARIO
CREATE OR REPLACE FUNCTION stp_lookByUsuario_usuario(
	p_usuario INT
)RETURNS TABLE(
	idUsuario INT,
	usuario VARCHAR(25),
	contrasena VARCHAR(25),
	permiso BOOL,
	idEmpleadoFK INT
)AS $$
BEGIN
	RETURN QUERY
	SELECT * FROM usuario WHERE usuario = p_usuario;
END;
$$ LANGUAGE plpgsql;

