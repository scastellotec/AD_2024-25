-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS tienda;

-- Usar la base de datos
USE tienda;

-- Crear la tabla productos
CREATE TABLE IF NOT EXISTS productos (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL
);