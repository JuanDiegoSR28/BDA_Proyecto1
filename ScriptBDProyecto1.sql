CREATE DATABASE  IF NOT EXISTS `ecommercelibros` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ecommercelibros`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: ecommercelibros
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `carritocompras`
--

DROP TABLE IF EXISTS `carritocompras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carritocompras` (
  `id_Orden` int DEFAULT NULL,
  `isbn` varchar(15) DEFAULT NULL,
  KEY `id_Orden` (`id_Orden`),
  KEY `isbn` (`isbn`),
  CONSTRAINT `carritocompras_ibfk_1` FOREIGN KEY (`id_Orden`) REFERENCES `orden` (`id_Orden`),
  CONSTRAINT `carritocompras_ibfk_2` FOREIGN KEY (`isbn`) REFERENCES `libro` (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carritocompras`
--

LOCK TABLES `carritocompras` WRITE;
/*!40000 ALTER TABLE `carritocompras` DISABLE KEYS */;
INSERT INTO `carritocompras` VALUES (1,'123ESO');
/*!40000 ALTER TABLE `carritocompras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_Cliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `contraseña` varchar(20) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `teléfono` varchar(10) DEFAULT NULL,
  `dirección` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_Cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Padrino P','pacifico','pepaps@taringa.com','1111100000','ITSON Centro'),(2,'Paty Pecas','papitas','pepaps@hotmail.com','1212121212','ITSON Guaymas'),(3,'Pedrinho de pap','pap','pepaps@itson.com','2111111112','ITSON Centro'),(4,'Pedro Picaso','patatas','pepaps@taringa.com','1010101010','ITSON Centro');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprasrealizadas`
--

DROP TABLE IF EXISTS `comprasrealizadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comprasrealizadas` (
  `id_Compra` int NOT NULL,
  `id_ClienteComprador` int NOT NULL,
  `isbnLibro` varchar(15) NOT NULL,
  `cantidad_Libro` int NOT NULL,
  `fechaCompra` date NOT NULL,
  PRIMARY KEY (`id_Compra`),
  KEY `id_ClienteComprador_idx` (`id_ClienteComprador`),
  KEY `isbnLibro_idx` (`isbnLibro`),
  CONSTRAINT `id_ClienteComprador` FOREIGN KEY (`id_ClienteComprador`) REFERENCES `cliente` (`id_Cliente`),
  CONSTRAINT `isbnLibro` FOREIGN KEY (`isbnLibro`) REFERENCES `libro` (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprasrealizadas`
--

LOCK TABLES `comprasrealizadas` WRITE;
/*!40000 ALTER TABLE `comprasrealizadas` DISABLE KEYS */;
INSERT INTO `comprasrealizadas` VALUES (1,2,'123ESO',2,'2020-02-02'),(3,2,'123ESO',2,'2020-02-02');
/*!40000 ALTER TABLE `comprasrealizadas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero` (
  `id_genero` int NOT NULL AUTO_INCREMENT,
  `nombreGenero` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_genero`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Terror');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `isbn` varchar(15) NOT NULL,
  `titulo` varchar(150) DEFAULT NULL,
  `autor` varchar(150) DEFAULT NULL,
  `descripcion` text,
  `precio` int DEFAULT NULL,
  `ultimaReedicion` date DEFAULT NULL,
  `cantidadLibro` int DEFAULT NULL,
  `id_genero` int DEFAULT NULL,
  PRIMARY KEY (`isbn`),
  KEY `id_genero` (`id_genero`),
  CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`id_genero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES ('123ESO','El Payaso Eso','Stephen King','Payaso marciano',150,'2020-01-01',0,1);
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden`
--

DROP TABLE IF EXISTS `orden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orden` (
  `id_Orden` int NOT NULL AUTO_INCREMENT,
  `cantidad` int DEFAULT NULL,
  `fechaCreacion` date DEFAULT NULL,
  `numeroConfirmacion` int DEFAULT NULL,
  `id_Cliente` int DEFAULT NULL,
  PRIMARY KEY (`id_Orden`),
  KEY `id_Cliente` (`id_Cliente`),
  CONSTRAINT `orden_ibfk_1` FOREIGN KEY (`id_Cliente`) REFERENCES `cliente` (`id_Cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden`
--

LOCK TABLES `orden` WRITE;
/*!40000 ALTER TABLE `orden` DISABLE KEYS */;
INSERT INTO `orden` VALUES (1,2,'2022-01-01',42,1);
/*!40000 ALTER TABLE `orden` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-24 23:54:28
