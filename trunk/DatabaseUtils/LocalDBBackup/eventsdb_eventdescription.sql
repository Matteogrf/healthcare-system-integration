CREATE DATABASE  IF NOT EXISTS `eventsdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `eventsdb`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: 192.168.1.41    Database: eventsdb
-- ------------------------------------------------------
-- Server version	5.5.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `eventdescription`
--

DROP TABLE IF EXISTS `eventdescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventdescription` (
  `IdEvent` int(11) NOT NULL,
  `DataOraEvento` datetime NOT NULL,
  `DataOraRegEvento` datetime NOT NULL,
  `TipoEventoCod` int(11) NOT NULL,
  `TipoEventoDescr` varchar(250) NOT NULL,
  `IdInterventoPratica` varchar(7) DEFAULT NULL,
  `ServizioCod` int(11) NOT NULL,
  `ServizioDescr` varchar(250) NOT NULL,
  `ProduttoreCod` int(11) NOT NULL,
  `UnitàOrganizzativaCod` int(11) NOT NULL,
  `UnitàOrganizzativaDescr` varchar(100) NOT NULL,
  `ProduttoreDescr` varchar(45) NOT NULL,
  PRIMARY KEY (`IdEvent`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventdescription`
--

LOCK TABLES `eventdescription` WRITE;
/*!40000 ALTER TABLE `eventdescription` DISABLE KEYS */;
INSERT INTO `eventdescription` VALUES (1,'2012-03-05 12:34:54','2012-03-05 16:00:00',1,'Inserimento Variazione Anagrafica','0001',900006099,'RSA',14,142,'COMPRENSORIO C4 - ALTA VALSUGANA','COMPRENSORIO C4 - ALTA VALSUGANA');
/*!40000 ALTER TABLE `eventdescription` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-03-05 18:13:18
