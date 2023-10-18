-- Creación de las tablas una por una con ON DELETE CASCADE y ON UPDATE CASCADE
CREATE TABLE empleado (
    idEmpleado SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidoP VARCHAR(50) NOT NULL,
    apellidoM VARCHAR(40) NOT NULL,
    numLicencia VARCHAR(12) NOT NULL UNIQUE,
    telefono VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE usuario (
    idUsuario SERIAL PRIMARY KEY,
    usuario VARCHAR(25) NOT NULL UNIQUE,
    contrasena VARCHAR(25) NOT NULL,
    permiso BOOLEAN NOT NULL,
    idEmpleadoFK INT NOT NULL UNIQUE,
    FOREIGN KEY (idEmpleadoFK) REFERENCES empleado(idEmpleado) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE vehiculo (
    idVehiculo SERIAL PRIMARY KEY,
    modelo VARCHAR(50) NOT NULL,
    ano VARCHAR(4) NOT NULL,
    color VARCHAR(30) NOT NULL,
    placas VARCHAR(20) NOT NULL UNIQUE,
    numTarjeta VARCHAR(10) NOT NULL UNIQUE,
    rendimientoKmsLt DOUBLE PRECISION NOT NULL,
    disponible BOOLEAN NOT NULL
);

CREATE TABLE estadisticas (
    idEstadistica SERIAL PRIMARY KEY,
    celcius DOUBLE PRECISION NOT NULL,
    ubicacion VARCHAR(50) NOT NULL,
    bateria VARCHAR(30) NOT NULL,
    idVehiculoFK INT NOT NULL,
    FOREIGN KEY (idVehiculoFK) REFERENCES vehiculo(idVehiculo) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE pedidos (
    idPedido SERIAL PRIMARY KEY,
    cliente VARCHAR(50),
    telCliente VARCHAR(10),
    descripcion VARCHAR(100) NOT NULL,
    total DOUBLE PRECISION NOT NULL,
    entregado BOOLEAN NOT NULL,
    cancelado BOOLEAN NOT NULL,
    idEmpleadoFK INT NOT NULL,
    FOREIGN KEY (idEmpleadoFK) REFERENCES empleado(idEmpleado) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE reportes (
    idReporte SERIAL PRIMARY KEY,
    descripcion VARCHAR(100) NOT NULL,
    idVehiculoFK INT NOT NULL,
    idEmpleadoFK INT NOT NULL,
    FOREIGN KEY (idVehiculoFK) REFERENCES vehiculo(idVehiculo) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (idEmpleadoFK) REFERENCES empleado(idEmpleado) ON DELETE CASCADE ON UPDATE CASCADE
);
