
# Este fichero sql creará los 5 procedimientos almacenados invocados desde la clase Controller:
# - eliminarCliente: 
# Recibe un entero como parámetro de entrada. Representa el identificador del cliente a eliminar.
# - obtenerCliente:
# Recibe un entero como parámetro de entrada. Representa el identificador del cliente a cargar. Se obtiene el nombre, apellido y NIF de dicho cliente.
# - obtenerClientes:
# No recibe parámetros de entrada. Se obtiene el identificador, nombre y NIF de todos los clientes de la tabla ordenados por nombre.
# - insertarCliente:
# Recibe como parámetros de entrada el nombre, apellido y NIF del cliente a insertar.
# - modificarCliente:
# Recibe como parámetro de entrada el identificador del cliente a modificar, el nuevo nombre, apellido y NIF.

# BORRAR CLIENTE POR ID
DELIMITER $$
DROP PROCEDURE IF EXISTS eliminarCliente$$
CREATE PROCEDURE eliminarCliente(id INT(11))
BEGIN
	DELETE FROM cliente
	WHERE cliente.id = id;
END
$$


# OBTENER EL NIF, NOMBRE Y APELLIDO DE UN CLIENTE
DELIMITER $$
DROP PROCEDURE IF EXISTS obtenerCliente$$
CREATE PROCEDURE obtenerCliente(id INT(11))
BEGIN
	SELECT nif, nombre, apellido
	FROM cliente
	WHERE cliente.id = id;
END
$$

# OBTENER EL NIF, NOMBRE, APELLIDO DE TODOS LOS CLIENTES
DELIMITER $$
DROP PROCEDURE IF EXISTS obtenerClientes$$
CREATE PROCEDURE obtenerClientes()
BEGIN
	SELECT id, nif, nombre
	FROM cliente
	ORDER BY nombre;
END
$$

# INSERTAR UN NUEVO CLIENTE
DELIMITER $$
DROP PROCEDURE IF EXISTS insertarCliente$$
CREATE PROCEDURE insertarCliente(nif VARCHAR(15), nombre VARCHAR(50), apellido VARCHAR(50))
BEGIN
	INSERT INTO cliente (nif, nombre, apellido)
	VALUES (nif, nombre, apellido);
END
$$

# MODIFICAR EL NIF, NOMBRE Y APELLIDO DE UN CLIENTE POR ID
DELIMITER $$
DROP PROCEDURE IF EXISTS modificarCliente$$
CREATE PROCEDURE modificarCliente(id INT(11), nif VARCHAR(15), nombre VARCHAR(50), apellido VARCHAR(50))
BEGIN
	UPDATE cliente
	SET cliente.nif = nif,
		cliente.nombre = nombre,
		cliente.apellido = apellido
	WHERE cliente.id = id;
END
$$
 