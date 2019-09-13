CREATE TABLE cliente (
  id int(11) NOT NULL AUTO_INCREMENT,
  nif varchar(15) NOT NULL UNIQUE,
  nombre varchar(50) NOT NULL,
  apellido varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;