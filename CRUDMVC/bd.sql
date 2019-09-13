use tienda;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nif` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `apellido` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nif` (`nif`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarCliente`(id INT(11))
BEGIN
	DELETE FROM cliente
	WHERE cliente.id = id;
END$$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarCliente`(nif VARCHAR(15), nombre VARCHAR(50), apellido VARCHAR(50))
BEGIN
	INSERT INTO cliente (nif, nombre, apellido)
	VALUES (nif, nombre, apellido);
END$$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarCliente`(id INT(11), nif VARCHAR(15), nombre VARCHAR(50), apellido VARCHAR(50))
BEGIN
	UPDATE cliente
	SET cliente.nif = nif,
		cliente.nombre = nombre,
		cliente.apellido = apellido
	WHERE cliente.id = id;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerCliente`(id INT(11))
BEGIN
	SELECT nif, nombre, apellido
	FROM cliente
	WHERE cliente.id = id;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerClientes`()
BEGIN
	SELECT id, nif, nombre
	FROM cliente
	ORDER BY nombre;
END$$
DELIMITER ;

