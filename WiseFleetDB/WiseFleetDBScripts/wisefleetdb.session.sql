-- Creacion de las tablas una por una
CREATE TABLE empleado(
	idEmpleado INT NOT NULL SERIAL PRIMARY KEY,
    nombre NVARCHAR(50) NOT NULL,
    apellidoP NVARCHAR(50) NOT NULL,
    apellidoM NVARCHAR(40) NOT NULL,
    numLicencia NVARCHAR(12) NOT NULL UNIQUE,
    telefono NVARCHAR(10) NOT NULL UNIQUE
);