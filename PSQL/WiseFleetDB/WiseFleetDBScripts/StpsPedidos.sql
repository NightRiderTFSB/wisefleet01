-- PROCEDIMIENTOS ALMACENADOS PARA PEDIDOS

-- AGREGAR
CREATE OR REPLACE FUNCTION stp_add_pedido(
	p_cliente VARCHAR(50),
	p_telCliente VARCHAR(10),
	p_descripcion VARCHAR(100),
	p_total FLOAT,
	p_entregado BOOL,
	p_cancelado BOOL,
	p_idEmpleadoFK INT
)RETURNS VOID AS $$
BEGIN
	INSERT INTO pedidos (cliente, telCliente, descripcion, total, entregado, cancelado, idempleadofk)
	VALUES (p_cliente, p_telCliente, p_descripcion, p_total, p_entregado, p_cancelado, p_idEmpleadoFK);
END;
$$ LANGUAGE plpgsql;

-- ELIMINAR
CREATE OR REPLACE FUNCTION stp_remove_pedido(
	p_idPedido INT
)RETURNS VOID AS $$
BEGIN
	DELETE FROM pedidos WHERE idPedido = p_idPedido;
END;
$$ LANGUAGE plpgsql;

-- ACTUALIZAR
CREATE OR REPLACE FUNCTION spt_update_pedido(
	p_cliente VARCHAR(50),
	p_telCliente VARCHAR(10),
	p_descripcion VARCHAR(100),
	p_total FLOAT,
	p_entregado BOOL,
	p_cancelado BOOL,
	p_idEmpleadoFK INT,
	p_idPedido INT
)RETURNS VOID AS $$
BEGIN
	UPDATE pedidos
	SET
		cliente = p_cliente,
		telCliente = p_telCliente,
		descripcion = p_descripcion,
		total = p_total,
		entregado = p_entregado,
		cancelado = p_cancelado,
		idEmpleadoFK = p_idEmpleadoFK
	WHERE 
		idPedido = p_idPedido;
END;
$$ LANGUAGE plpgsql;

-- BUSCAR POR ID
CREATE OR REPLACE FUNCTION stp_lookByID_pedido(
	p_idPedido INT
)RETURNS TABLE(
	idPedido INT,
	cliente VARCHAR(50),
	telCliente VARCHAR(10),
	descripcion VARCHAR(100),
	total FLOAT,
	entregado BOOL,
	cancelado BOOL,
	idEmpleadoFK INT
)AS $$
BEGIN
	RETURN QUERY
	SELECT * FROM pedidos WHERE idPedido = p_idPedido;
END;
$$ LANGUAGE plpgsql;


-- BUSCAR POR EMPLEADO
CREATE OR REPLACE FUNCTION stp_lookByEmpleado_pedido(
	p_idEmpleadoFK INT
)RETURNS TABLE(
	idPedido INT,
	cliente VARCHAR(50),
	telCliente VARCHAR(10),
	descripcion VARCHAR(100),
	total FLOAT,
	entregado BOOL,
	cancelado BOOL,
	idEmpleadoFK INT
)AS $$
BEGIN
	RETURN QUERY
	SELECT * FROM pedidos WHERE idEmpleadoFK = p_idEmpleadoFK;
END;
$$ LANGUAGE plpgsql;