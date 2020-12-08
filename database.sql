CREATE DATABASE IF NOT EXISTS `dbrest`; 
USE `dbrest`;

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO `customer` VALUES 
	(1,'Nikola','Ciric','nidza@gmail.com'),
	(2,'Jovan','Jovanovic','joca@gmail.com'),
	(3,'Aleksa','Aleksic','aca@yahoo.com'),
	(4,'Marko','Markovic','mare@yahoo.com'),
	(5,'Petar','Petrovic','pera@gmail.com');