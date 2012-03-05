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
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `IdAnagrafeLocale` int(11) NOT NULL,
  `Nome` varchar(100) NOT NULL,
  `Cognome` varchar(100) NOT NULL,
  `CodiceFiscale` varchar(16) DEFAULT NULL,
  `ComuneNascitaCod` varchar(7) NOT NULL,
  `ComuneResidenzaCod` varchar(7) NOT NULL,
  `DataNascita` date NOT NULL,
  PRIMARY KEY (`IdAnagrafeLocale`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (701,'Claudio','Groff','GRFCLD60J19L3TBU','022011','022011','1960-05-19'),(1022,'Matteo','Groff','GRFMTT88B19L3T8B','022005','022011','1988-02-19'),(2005,'Claudio','Marchesoni','CLDMRH56H16B56DK','022139','022139','1956-01-25'),(4509,'Miriam','Folgheraiter','FLGMRM60K28L456K','022009','022011','1960-03-28'),(4578,'Mario','Monti','MNTMRI45K34ASDDS','052015','058091','1945-11-30'),(5672,'Michele','Marchesoni','MHCMRC88J05L378H','022005','022139','1988-12-05'),(6022,'Giulia','Marchesoni','GULMRC92G86L3T8K','022005','022139','1993-07-03'),(6666,'Abdul','Meque','MQUBDL86C12KELDF','440000','022011','1986-08-12'),(7080,'Mariateresa','Franzoso','FRNMRT62K18L378B','022006','022139','1963-06-18'),(15600,'Piersilvio','Berlusconi','BRLPRS30F12ASD7J','015146','015008','1930-05-12');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
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
