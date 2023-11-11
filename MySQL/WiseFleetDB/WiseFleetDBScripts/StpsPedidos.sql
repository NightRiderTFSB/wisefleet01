-- PROCEDIMIENTOS ALMACENADOS DE PEDIDOS
-- Agregar
DELIMITER //
CREATE PROCEDURE stp_add_pedidos(IN p_cliente NVARCHAR(50),
									IN p_telCliente NVARCHAR(10),
                                    IN p_descripcion NVARCHAR(100),
									IN p_total DOUBLE(6,2),
                                    IN p_entregado BOOL,
                                    IN p_cancelado BOOl,
                                    IN p_idEmpleadoFK INT)
BEGIN
	INSERT INTO pedidos (cliente, telCliente, descripcion, total, entregado, cancelado, idEmpleadoFK)
    VALUES (p_cliente, p_telCliente, p_descripcion, p_total, p_entregado, p_cancelado, p_idEmpleadoFK);
END //
DELIMITER ;


-- Eliminar
DELIMITER //
CREATE PROCEDURE stp_remove_pedidos(IN p_idPedido INT)
BEGIN
	DELETE FROM pedidos WHERE idPedido = p_idPedido;
END //
DELIMITER ;


-- Actualizar
DELIMITER //
CREATE PROCEDURE stp_update_pedidos(IN p_cliente NVARCHAR(50),
									IN p_telCliente NVARCHAR(10),
                                    IN p_descripcion NVARCHAR(100),
									IN p_total DOUBLE(6,2),
                                    IN p_entregado BOOL,
                                    IN p_cancelado BOOl,
                                    IN p_idEmpleadoFK INT,
                                    IN p_idPedido INT)
BEGIN
	UPDATE pedidos SET
		cliente = p_cliente,
        telCliente = p_telCliente,
        descripcion = p_descripcion,
        total = p_total,
        entregado = p_entregado,
        cancelado = p_cancelado,
        idEmpleadoFK = p_idEmpleadoFK
	WHERE 
		idPedido = p_idPedido;
END //
DELIMITER ;


-- Buscar por empleado
DELIMITER //
CREATE PROCEDURE stp_lookByEmpleado_pedidos(IN p_idEmpleadoFK INT)
BEGIN
	SELECT * FROM pedidos WHERE idEmpleadoFK = p_idEmpleadoFK;
END //
DELIMITER ;


-- Buscar por id
DELIMITER //
CREATE PROCEDURE stp_lookByID_pedidos(IN p_idPedido INT)
BEGIN
	SELECT * FROM pedidos WHERE idPedido = p_idPedido; 
END //
DELIMITER ;
