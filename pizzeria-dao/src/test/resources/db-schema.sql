DROP TABLE IF EXISTS `pizza`;
DROP TABLE IF EXISTS `performance`;
CREATE TABLE IF NOT EXISTS `pizza` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categorie` varchar(255) DEFAULT NULL,
  `code_pizza` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prix` decimal(19,2) DEFAULT NULL,
  `url_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `performance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `tempsexecution` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);