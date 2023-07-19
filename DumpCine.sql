CREATE DATABASE /*!32312 IF NOT EXISTS*/ `cinemanagement` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `cinemanagement`;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Ciencia ficcion'), (2,'Comedia'), (3,'Accion');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` int NOT NULL,
  `apellido` int NOT NULL,
  `mail` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mail_UNIQUE`(`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Lucio','Pecoraro','lp@g.com','lucio123','cliente'), (2,'Alejandro','Foresi','af@g.com','ale123','cliente'), (3,'Usuario','Administrador','admin@g.com','asd','admin'), (4,'Leandro','Berto','lb@g.com','lea123','cliente'),(5,'Matias','Camarotti','mc@g.com','mati123','cliente'),(6,'Laureano','Godoy','lg@g.com','lg123','cliente'),(7,'Valentino','Tieppo','vt@g.com','tieppo123','cliente');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idCategoria` int NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pelicula_id_categoria_idx` (`idCategoria`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  CONSTRAINT `pelicula_id_categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (1,3,'Rapidos y Furiosos'),(2,2,'Los Tres Chiflados'),(3,1,'Avatar'), (4,2,'Scary Movie'), (5,3,'John Wick'), (6,2,'Un espia y medio'), (7,1,'Harry Potter');
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sala` (
  `id` int NOT NULL AUTO_INCREMENT,
  `capacidadMax` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` VALUES (1,'15'),(2,'20'),(3,'20'),(4,'30'),(5,'30'),(6,'20');
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `funcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcion` (
  `id_sala` int NOT NULL,
  `id_pelicula` int NOT NULL,
  `fecha` date NOT NULL,
  `inicio` time NOT NULL,
  `fin` time not NULL,
  PRIMARY KEY (`id_sala`,`fecha`,`inicio`),
  KEY `funcion_id_sala_id_pelicula_fk_idx` (`id_sala`,`id_pelicula`),
  CONSTRAINT `funcion_id_sala_fk` FOREIGN KEY (`id_sala`) REFERENCES `sala` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `funcion_id_pelicula_fk` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `funcion` WRITE;
/*!40000 ALTER TABLE `funcion` DISABLE KEYS */;
INSERT INTO `funcion` VALUES (1,1,'2023-07-18','13:00:00','15:00:00'),(1,2,'2023-07-18','15:30:00','17:00:00'),(1,3,'2023-07-18','17:30:00','19:00:00'),(1,4,'2023-07-18','19:30:00','21:00:00'),(1,5,'2023-07-18','21:30:00','23:00:00'),(2,1,'2023-07-18','13:00:00','15:00:00'),(2,2,'2023-07-18','15:30:00','17:00:00'),(2,3,'2023-07-18','17:30:00','19:00:00'),(2,4,'2023-07-18','19:30:00','21:00:00'),(2,5,'2023-07-18','21:30:00','23:00:00'),(3,1,'2023-07-18','13:00:00','15:00:00'),(3,2,'2023-07-18','15:30:00','17:00:00'),(3,3,'2023-07-18','17:30:00','19:00:00'),(3,4,'2023-07-18','19:30:00','21:00:00'),(3,5,'2023-07-18','21:30:00','23:00:00'),(4,1,'2023-07-18','13:00:00','15:00:00'),(4,2,'2023-07-18','15:30:00','17:00:00'),(4,3,'2023-07-18','17:30:00','19:00:00'),(4,4,'2023-07-18','19:30:00','21:00:00'),(4,5,'2023-07-18','21:30:00','23:00:00'),(5,1,'2023-07-18','13:00:00','15:.00:00'),(5,2,'2023-07-18','15:30:00','17:00:00'),(5,3,'2023-07-18','17:30:00','19:00:00'),(5,6,'2023-07-18','19:30:00','21:00:00'),(5,7,'2023-07-18','21:30:00','23:00:00'),(6,1,'2023-07-18','13:00:00','15:00:00'),(6,2,'2023-07-18','15:30:00','17:00:00'),(6,3,'2023-07-18','17:30:00','19:00:00'),(6,6,'2023-07-18','19:30:00','21:00:00'),(6,7,'2023-07-18','21:30:00','23:00:00');
/*!40000 ALTER TABLE `funcion` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrada` (
  `cod` int NOT NULL AUTO_INCREMENT,
  `precio` double NOT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` VALUES (1,1000),(2,1000),(3,1000),(4,1000),(5,1000),(6,1000),(7,1000),(8,1000),(9,1000),(10,1000),(11,1000),(12,1000),(13,1000),(14,1000),(15,1000);
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `entrada_funcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrada_funcion` (
  `idCliente` int NOT NULL,
  `codEntrada` int NOT NULL,
  `fechaFuncion` date NOT NULL,
  `horaInicio` time NOT NULL,
  `idSala` int NOT NULL,
  `idPelicula` int NOT NULL,
  
  PRIMARY KEY (`idCliente`,`codEntrada`,`fechaFuncion`,`horaInicio`,`idSala`,`idPelicula`),
  KEY `entrada_funcion_fk_idx` (`codEntrada`,`fechaFuncion`,`horaInicio`,`idSala`) /*!80000 INVISIBLE */,
  CONSTRAINT `entrada_funcion_entrada_fk` FOREIGN KEY (`codEntrada`) REFERENCES `entrada` (`cod`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `entrada_funcion_funcion_fk` FOREIGN KEY (`idSala`,`idPelicula`,`fechaFuncion`,`horaInicio`) REFERENCES `funcion` (`id_sala`,`id_pelicula`,`fecha`,`inicio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `entrada_funcion_cliente_fk` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `entrada_funcion` WRITE;
/*!40000 ALTER TABLE `entrada_funcion` DISABLE KEYS */;
INSERT INTO `entrada_funcion` VALUES (1,1,'2023-07-18','13:00:00',1,1),(1,2,'2023-07-18','13:00:00',1,1),(4,3,'2023-07-18','13:00:00',1,1),(4,4,'2023-07-18','13:00:00',1,1),(4,5,'2023-07-18','13:00:00',1,1),(2,6,'2023-07-18','13:00:00',1,1),(2,7,'2023-07-18','13:00:00',1,1),(2,8,'2023-07-18','13:00:00',1,1),(5,9,'2023-07-18','13:00:00',1,1),(5,10,'2023-07-18','13:00:00',1,1),(6,11,'2023-07-18','13:00:00',1,1),(6,12,'2023-07-18','13:00:00',1,1),(6,13,'2023-07-18','13:00:00',1,1),(7,14,'2023-07-18','13:00:00',1,1),(7,15,'2023-07-18','13:00:00',1,1);
/*!40000 ALTER TABLE `entrada_funcion` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `reseña_pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reseña_pelicula` (
  `idCliente` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `idPelicula` int NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `calificacion` int NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id`,`idCliente`,`idPelicula`,`fecha`),
  KEY `reseña_incluida_nombreCliente_idPelicula_fecha_fk_idx` (`idCliente`,`idPelicula`) /*!80000 INVISIBLE */,
  CONSTRAINT `reseña_pelicula_idCliente_nombreCliente_fk` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reseña_pelicula_idPelicula_fk` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `reseña_pelicula` WRITE;
/*!40000 ALTER TABLE `reseña_pelicula` DISABLE KEYS */;
INSERT INTO `reseña_pelicula` VALUES ();
/*!40000 ALTER TABLE `reseña_pelicula` ENABLE KEYS */;
UNLOCK TABLES;




/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

drop user if exists 'lionel'@'%';
create user 'lionel'@'%' identified by 'messi';
GRANT SELECT, INSERT, UPDATE, DELETE ON `cinemanagement`.* TO 'lionel'@'%';