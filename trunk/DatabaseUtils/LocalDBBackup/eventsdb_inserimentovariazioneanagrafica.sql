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
-- Table structure for table `inserimentovariazioneanagrafica`
--

DROP TABLE IF EXISTS `inserimentovariazioneanagrafica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inserimentovariazioneanagrafica` (
  `ComuneNascitaDescr` varchar(255) NOT NULL,
  `StatoCivileCod` int(11) NOT NULL,
  `StatoCivileDescr` varchar(255) NOT NULL,
  `NazionalitaCod` int(11) NOT NULL,
  `NazionalitaDescr` varchar(255) NOT NULL,
  `ComuneDiResidenzaDescr` varchar(255) NOT NULL,
  `Sesso` varchar(1) NOT NULL,
  `Via` varchar(255) NOT NULL,
  `CAP` varchar(5) NOT NULL,
  `CittadinanzaCod` int(11) NOT NULL,
  `CittadinanzaDescr` varchar(255) NOT NULL,
  `AssSocialeCod` int(11) NOT NULL,
  `AssSocialeCognome` varchar(100) NOT NULL,
  `AssSocialeNome` varchar(100) NOT NULL,
  `EventoAssociato` int(11) NOT NULL,
  `EventoInviato` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`EventoAssociato`),
  UNIQUE KEY `EventoAssociato_UNIQUE` (`EventoAssociato`),
  KEY `FK_Evento` (`EventoAssociato`),
  CONSTRAINT `FK_Evento` FOREIGN KEY (`EventoAssociato`) REFERENCES `events` (`idEvent`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inserimentovariazioneanagrafica`
--

LOCK TABLES `inserimentovariazioneanagrafica` WRITE;
/*!40000 ALTER TABLE `inserimentovariazioneanagrafica` DISABLE KEYS */;
INSERT INTO `inserimentovariazioneanagrafica` VALUES ('TRENTO',1,'Celibe o nubile',100,'ITALIA','BEDOLLO','M','Del Redebus 24','38043',100,'ITALIA',342,'Verdi','Bianca',1,'\0');
/*!40000 ALTER TABLE `inserimentovariazioneanagrafica` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-03-05 18:13:19
