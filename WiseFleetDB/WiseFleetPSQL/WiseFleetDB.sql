-- CREACION DE TABLAS DE WISEFLEET EN PSQL

CREATE TABLE empleado(
	idEmpleado SERIAL PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	apellidoP VARCHAR(50) NOT NULL,
	apellidoM VARCHAR(50) NOT NULL,
	numLicencia VARCHAR(12) NOT NULL,
	telefono VARCHAR(10) NOT NULL
);

CREATE TABLE usuario(
	idUsuario SERIAL PRIMARY KEY,
	usuario VARCHAR(25) NOT NULL,
	contrasena VARCHAR(25) NOT NULL,
	permiso BOOLEAN NOT NULL,
	idEmpleadoFK INT NOT NULL
);

CREATE TABLE pedido(
	idPedido SERIAL PRIMARY KEY,
	cliente VARCHAR(50),
	telCliente VARCHAR(10),
	detalle VARCHAR(10),
	total NUMERIC(10,2) NOT NULL,
	entregado BOOLEAN NOT NULL,
	cancelado BOOLEAN NOT NULL,
	idEmpleadoFK INT NOT NULL
);

CREATE TABLE reporte(
	idReporte SERIAL PRIMARY KEY,
	descripcion VARCHAR(100) NOT NULL,
	idVehiculoFK INT NOT NULL,
	idEmpleadoFK INT NOT NULL
);

CREATE TABLE vehiculo(
	idVehiculo SERIAL PRIMARY KEY,
	modelo VARCHAR(50) NOT NULL,
	ano VARCHAR(4) NOT NULL,
	color VARCHAR(30) NOT NULL,
	placas VARCHAR(8) NOT NULL,
	numTarjeta VARCHAR(10) NOT NULL,
	rendimientoKmsLt NUMERIC(10,2) NOT NULL,
	disponible BOOLEAN NOT NULL
);

CREATE TABLE estadisticas(
	idEstadistica SERIAL PRIMARY KEY,
	celcius NUMERIC(10,2),
	ubicacion VARCHAR(100),
	idVehiculoFK INT NOT NULL
);

-- Llave foranea de usuario proveniente de empleado (idEmpleado)
ALTER TABLE usuario ADD CONSTRAINT fk_usuario_empleado_idEmpleado
FOREIGN KEY (idEmpleadoFK) REFERENCES empleado(idEmpleado)
ON DELETE CASCADE ON UPDATE CASCADE;


-- Llave foranea de pedido proveniente de empleado (idEmpleado)
ALTER TABLE pedido ADD CONSTRAINT fk_pedido_empleado_idEmpleado
FOREIGN KEY (idEmpleadoFK) REFERENCES empleado(idEmpleado)
ON DELETE CASCADE ON UPDATE CASCADE;


-- Llave foranea de repore proveniente de empleado (idEmpleado)
ALTER TABLE reporte ADD CONSTRAINT fk_reporte_empleado_idEmpleado
FOREIGN KEY (idEmpleadoFK) REFERENCES empleado(idEmpleado)
ON DELETE CASCADE ON UPDATE CASCADE;

-- Llave foranea de repote proveniente de vehiculo (idVehiculo)
ALTER TABLE reporte ADD CONSTRAINT fk_reporte_vehiculo_idVehiculo
FOREIGN KEY (idVehiculoFK) REFERENCES vehiculo(idVehiculo)
ON DELETE CASCADE ON UPDATE CASCADE;

-- Llave foranea de estadisticas proveniente de vehiculo (idVehiculo)
ALTER TABLE estadisticas ADD CONSTRAINT fk_estadisticas_vehiculo_idVehiculo
FOREIGN KEY (idVehiculoFK) REFERENCES vehiculo(idVehiculo)
ON DELETE CASCADE ON UPDATE CASCADE;










