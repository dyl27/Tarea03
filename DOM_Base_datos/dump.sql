-- MySQL dump 10.13  Distrib 8.0.46, for Linux (x86_64)
--
-- Host: localhost    Database: financiera_huanca
-- ------------------------------------------------------
-- Server version	8.0.46-0ubuntu0.24.04.4

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `dni` varchar(15) NOT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `fecha_registro` date DEFAULT (curdate()),
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Juan','Pérez Gómez','45678912','Av. Los Álamos 123, Lima','987654321','juan.perez@mail.com','2026-01-10'),(2,'María','López Ruiz','78912345','Jr. Las Flores 456, Lima','956123478','maria.lopez@mail.com','2026-02-15'),(3,'Carlos','Huamán Torres','32165498','Calle Real 789, Arequipa','912345678','carlos.huaman@mail.com','2026-03-01');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credito`
--

DROP TABLE IF EXISTS `credito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credito` (
  `id_credito` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `id_moneda` int NOT NULL,
  `fecha` date NOT NULL,
  `monto` decimal(12,2) NOT NULL,
  `periodo_meses` int NOT NULL,
  `cuota` decimal(12,2) NOT NULL,
  `tea` decimal(5,2) NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  PRIMARY KEY (`id_credito`),
  KEY `fk_credito_cliente` (`id_cliente`),
  KEY `fk_credito_moneda` (`id_moneda`),
  CONSTRAINT `fk_credito_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `fk_credito_moneda` FOREIGN KEY (`id_moneda`) REFERENCES `moneda` (`id_moneda`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credito`
--

LOCK TABLES `credito` WRITE;
/*!40000 ALTER TABLE `credito` DISABLE KEYS */;
INSERT INTO `credito` VALUES (2,2,2,'2026-04-15',1500.00,6,265.80,22.00,'2026-10-15'),(3,3,3,'2026-05-20',20000.00,24,980.10,15.75,'2028-05-20'),(4,2,2,'2026-09-19',34.00,43,345.00,435.00,'2026-09-12'),(5,1,1,'2026-10-02',5000.00,12,450.50,56.40,'2026-10-02');
/*!40000 ALTER TABLE `credito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moneda`
--

DROP TABLE IF EXISTS `moneda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `moneda` (
  `id_moneda` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `simbolo` varchar(5) NOT NULL,
  PRIMARY KEY (`id_moneda`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moneda`
--

LOCK TABLES `moneda` WRITE;
/*!40000 ALTER TABLE `moneda` DISABLE KEYS */;
INSERT INTO `moneda` VALUES (1,'Soles','S/.'),(2,'Dólares','US$'),(3,'Peso Mexicano','MXN'),(4,'Euro','€'),(5,'Libra Esterlina','£'),(6,'Yen Japonés','¥'),(7,'Franco Suizo','CHF'),(8,'Bitcoin','BTC'),(9,'Peso Colombiano','COL$');
/*!40000 ALTER TABLE `moneda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago_tarjeta`
--

DROP TABLE IF EXISTS `pago_tarjeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago_tarjeta` (
  `id_pago` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `mes` varchar(15) NOT NULL,
  `tarjeta` varchar(20) NOT NULL,
  `transaccion` varchar(60) NOT NULL,
  `gastos` decimal(12,2) DEFAULT NULL,
  `pagos` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`id_pago`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago_tarjeta`
--

LOCK TABLES `pago_tarjeta` WRITE;
/*!40000 ALTER TABLE `pago_tarjeta` DISABLE KEYS */;
INSERT INTO `pago_tarjeta` VALUES (1,'2021-01-01','enero','VISA','Peluquería',1000.00,3234.89),(2,'2021-01-02','enero','VISA','TV plasma (1 de 6)',2500.00,NULL),(3,'2021-01-03','enero','MASTERCARD','Vajilla Kit',2500.00,345.00),(4,'2021-01-04','enero','MASTERCARD','YouTube Premium',170.00,NULL),(5,'2021-01-05','enero','VISA','Pasaje Londres',25000.00,4567.90),(6,'2021-01-06','enero','MASTERCARD','Pago Mastercard',NULL,2670.00),(7,'2021-02-07','febrero','VISA','Teatro',150.00,1245.00),(8,'2021-02-08','febrero','VISA','Pago VISA',NULL,150.00),(9,'2021-02-09','febrero','MASTERCARD','Cine',23.00,4324.89),(10,'2021-02-10','febrero','MASTERCARD','Libros x 5',1400.00,NULL);
/*!40000 ALTER TABLE `pago_tarjeta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-10-27  1:01:02
