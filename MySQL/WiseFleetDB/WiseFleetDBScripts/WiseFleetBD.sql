-- Creacion de la base de datos
CREATE DATABASE WiseFleetBD;
USE WiseFleetBD;

-- Creacion de las tablas una por una
CREATE TABLE empleado(
	idEmpleado INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre NVARCHAR(50) NOT NULL,
    apellidoP NVARCHAR(50) NOT NULL,
    apellidoM NVARCHAR(40) NOT NULL,
    numLicencia NVARCHAR(12) NOT NULL UNIQUE,
    telefono NVARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE usuario(
	idUsuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    usuario NVARCHAR(25) NOT NULL UNIQUE,
    contrasena NVARCHAR(25) NOT NULL,
    permiso BOOL NOT NULL,
    idEmpleadoFK INT NOT NULL UNIQUE
);


CREATE TABLE vehiculo(
	idVehiculo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    modelo NVARCHAR(50) NOT NULL,
    ano NVARCHAR(4) NOT NULL,
    color NVARCHAR(30) NOT NULL,
    placas NVARCHAR(20) NOT NULL UNIQUE,
    numTarjeta NVARCHAR(10) NOT NULL UNIQUE,
    rendimientoKmsLt DOUBLE(5,2) NOT NULL,
    disponible BOOL NOT NULL
);

CREATE TABLE estadisticas(
	idEstadistica INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    celcius DOUBLE(5,2) NOT NULL,
    ubicacion NVARCHAR(50) NOT NULL,
    bateria NVARCHAR(30) NOT NULL,
    idVehiculoFK INT NOT NULL
);

CREATE TABLE pedidos(
	idPedido INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cliente NVARCHAR(50),
    telCliente NVARCHAR(10),
    descripcion NVARCHAR(100) NOT NULL,
    total DOUBLE(6,2) NOT NULL,
    entregado BOOL NOT NULL,
    cancelado BOOL NOT NULL,
    idEmpleadoFK INT NOT NULL
);

CREATE TABLE reportes(
	idReporte INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descripcion NVARCHAR(100) NOT NULL,
    idVehiculoFK INT NOT NULL,
    idEmpleadoFK INT NOT NULL
);

-- Creacion de las llaves foraneas
-- Llave foranea de reportes en vehiculo
ALTER TABLE reportes ADD CONSTRAINT 
FK_reportes_vehiculo FOREIGN KEY (idVehiculoFK) REFERENCES vehiculo(idVehiculo);

-- Llave foranea de estadisticas a vehiculo
ALTER TABLE estadisticas ADD CONSTRAINT
FK_estadisticas_vehiculo FOREIGN KEY (idVehiculoFK) REFERENCES vehiculo(idVehiculo);

-- Llave foranea de reportes a empleado
ALTER TABLE reportes ADD CONSTRAINT
FK_reportes_empleado FOREIGN KEY (idEmpleadoFK) REFERENCES empleado(idEmpleado);

-- Llave foranea de usuario a empleado
ALTER TABLE usuario ADD CONSTRAINT
FK_usuario_empleado FOREIGN KEY (idEmpleadoFK) REFERENCES empleado(idEmpleado);

ALTER TABLE pedidos ADD CONSTRAINT
FK_pedidos_empleado FOREIGN KEY (idEmpleadoFK) REFERENCES empleado(idEmpleado);
