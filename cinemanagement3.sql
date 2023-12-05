CREATE DATABASE  IF NOT EXISTS `cinemanagement` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cinemanagement`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cinemanagement
-- ------------------------------------------------------
-- Server version	8.0.33

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

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `idcategoria` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Ciencia ficcion'),(2,'Comedia'),(3,'Accion'),(4,'Aventura'),(5,'Animacion'),(6,'Terror');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrada` (
  `codentrada` int unsigned NOT NULL AUTO_INCREMENT,
  `precio` int unsigned NOT NULL,
  `fecha` date NOT NULL,
  `HoraInicio` time NOT NULL,
  `IDSala` int unsigned NOT NULL,
  `nroUsuario` int NOT NULL,
  PRIMARY KEY (`codentrada`),
  KEY `Ent_Func_idx` (`fecha`,`HoraInicio`,`IDSala`),
  KEY `fk_entrada_usuario_idx` (`nroUsuario`),
  CONSTRAINT `Ent_Func` FOREIGN KEY (`fecha`, `HoraInicio`, `IDSala`) REFERENCES `funcion` (`fecha`, `HoraInicio`, `IDSala`),
  CONSTRAINT `fk_entrada_usuario` FOREIGN KEY (`nroUsuario`) REFERENCES `usuario` (`nrousuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` VALUES (1,2500,'2024-12-27','09:00:00',1,1);
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcion`
--

DROP TABLE IF EXISTS `funcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcion` (
  `fecha` date NOT NULL,
  `HoraInicio` time NOT NULL,
  `HoraFin` time NOT NULL,
  `IDSala` int unsigned NOT NULL,
  `IDPelicula` int unsigned NOT NULL,
  PRIMARY KEY (`fecha`,`HoraInicio`,`IDSala`),
  KEY `IDSala_idx` (`IDSala`),
  KEY `IDpelicula_idx` (`IDPelicula`),
  CONSTRAINT `IDpelicula` FOREIGN KEY (`IDPelicula`) REFERENCES `pelicula` (`idpelicula`),
  CONSTRAINT `IDsala` FOREIGN KEY (`IDSala`) REFERENCES `sala` (`idsala`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcion`
--

LOCK TABLES `funcion` WRITE;
/*!40000 ALTER TABLE `funcion` DISABLE KEYS */;
INSERT INTO `funcion` VALUES ('2024-12-24','09:00:00','10:45:00',1,1),('2024-12-24','09:00:00','10:45:00',2,2),('2024-12-24','09:00:00','10:45:00',3,3),('2024-12-24','11:00:00','12:45:00',1,3),('2024-12-24','11:00:00','12:45:00',2,1),('2024-12-24','11:00:00','12:45:00',3,2),('2024-12-24','13:00:00','14:45:00',1,2),('2024-12-24','13:00:00','14:45:00',2,3),('2024-12-24','13:00:00','14:45:00',3,1),('2024-12-25','09:00:00','10:45:00',1,1),('2024-12-25','11:00:00','12:45:00',2,2),('2024-12-25','13:00:00','14:45:00',3,3),('2024-12-26','09:00:00','10:45:00',1,3),('2024-12-26','11:00:00','12:45:00',2,2),('2024-12-26','13:00:00','14:45:00',3,1),('2024-12-27','09:00:00','10:45:00',1,1),('2024-12-27','11:00:00','12:45:00',2,2),('2024-12-27','13:00:00','14:45:00',3,3),('2024-12-28','09:00:00','10:45:00',1,2),('2024-12-28','11:00:00','12:45:00',2,1),('2024-12-28','13:00:00','14:45:00',3,3),('2024-12-29','09:00:00','10:45:00',1,2),('2024-12-29','11:00:00','12:45:00',2,3),('2024-12-29','13:00:00','14:45:00',3,1),('2025-01-01','15:00:00','17:00:00',1,4),('2025-01-01','17:30:00','19:30:00',2,5),('2025-01-01','20:00:00','22:00:00',3,6),('2025-01-02','15:00:00','17:00:00',3,4),('2025-01-02','17:30:00','19:30:00',2,6),('2025-01-02','20:00:00','22:00:00',1,5),('2025-01-03','15:00:00','17:00:00',3,6),('2025-01-03','17:30:00','19:30:00',2,5),('2025-01-03','20:00:00','22:00:00',1,4),('2025-01-04','15:00:00','17:00:00',2,5),('2025-01-04','17:30:00','19:30:00',3,6),('2025-01-04','20:00:00','22:00:00',1,4),('2025-01-05','17:30:00','19:30:00',3,5),('2025-01-05','20:00:00','22:00:00',2,6),('2025-01-05','22:00:00','17:00:00',1,4);
/*!40000 ALTER TABLE `funcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula` (
  `idpelicula` int unsigned NOT NULL AUTO_INCREMENT,
  `idcategoria` int unsigned NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idpelicula`),
  KEY `idcategoria_idx` (`idcategoria`),
  CONSTRAINT `idcategoria` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`idcategoria`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (1,1,'La noche de ciencia ficcion'),(2,2,'Pura Comedia'),(3,3,'Accion Turbo'),(4,4,'Ace Ventura'),(5,5,'Animation Toon'),(6,6,'La noche de terror 1');
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reseña`
--

DROP TABLE IF EXISTS `reseña`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reseña` (
  `codigo` int unsigned NOT NULL,
  `descripcion` text NOT NULL,
  `fecha` date NOT NULL,
  `IDPelicula` int unsigned NOT NULL,
  `nrousuario` int NOT NULL,
  PRIMARY KEY (`codigo`,`IDPelicula`),
  KEY `IDPelicula_idx` (`IDPelicula`),
  KEY `nrousuario_idx` (`nrousuario`),
  CONSTRAINT `ID_Pelicula` FOREIGN KEY (`IDPelicula`) REFERENCES `pelicula` (`idpelicula`),
  CONSTRAINT `nrousuario` FOREIGN KEY (`nrousuario`) REFERENCES `usuario` (`nrousuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reseña`
--

LOCK TABLES `reseña` WRITE;
/*!40000 ALTER TABLE `reseña` DISABLE KEYS */;
INSERT INTO `reseña` VALUES (1,'Es una buena pelicula','2024-12-25',1,5);
/*!40000 ALTER TABLE `reseña` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sala` (
  `idsala` int unsigned NOT NULL AUTO_INCREMENT,
  `capacidadmax` int unsigned NOT NULL,
  PRIMARY KEY (`idsala`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala`
--

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` VALUES (1,15),(2,10),(3,15);
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `nrousuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL,
  `Tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nrousuario`),
  UNIQUE KEY `mail_UNIQUE` (`mail`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','admin','lp@g.com','lucio123','Admin'),(2,'alejo','pereira','af@g.com','ale123','Cliente'),(3,'tomas','salva','admin@g.com','asd','Cliente'),(4,'matias','secchini','lb@g.com','lea123','Cliente'),(5,'tomas','soto','mc@g.com','mati123','Cliente'),(6,'luigi','mario','lg@g.com','lg123','Cliente'),(7,'violeta','martines','vt@g.com','tieppo123','Cliente');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-05 17:11:50
