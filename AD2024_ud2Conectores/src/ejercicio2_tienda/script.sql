-- Crear la base de datos
CREATE DATABASE tienda;

-- Usar la base de datos
USE tienda;

-- Crear la tabla productos
CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    seccion VARCHAR(100),
    precio DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL
);

-- Crear la tabla pedidos
CREATE TABLE pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idproducto INT NOT NULL,
    fecha DATETIME,
    cantidad INT NOT NULL,
    cliente VARCHAR(100) NOT NULL,
    FOREIGN KEY (idproducto) REFERENCES productos(id)
);

-- Insertar productos en la tabla productos
INSERT INTO productos (nombre, seccion, precio, stock) VALUES
('Camisa', 'Ropa', 25.50, 100),
('Pantalones', 'Ropa', 45.99, 150),
('Zapatillas', 'Calzado', 60.00, 200),
('Chaqueta', 'Ropa', 120.00, 50),
('Bolso', 'Accesorios', 35.00, 80);

-- Insertar pedidos en la tabla pedidos
INSERT INTO pedidos (idproducto, cantidad, cliente) VALUES
(1, 2, 'Juan Pérez'),
(2, 1, 'María García'),
(3, 4, 'Carlos López'),
(4, 1, 'Ana Torres'),
(5, 2, 'Luis Martínez');
