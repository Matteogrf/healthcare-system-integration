CREATE DATABASE  IF NOT EXISTS `dwh` /*!40100 DEFAULT CHARACTER SET latin2 */;
USE `dwh`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: dwh
-- ------------------------------------------------------
-- Server version	5.5.20

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
-- Table structure for table `d_date`
--

DROP TABLE IF EXISTS `d_date`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `d_date` (
  `DATA` date NOT NULL,
  `DAY_OF_WEEK` varchar(10) DEFAULT NULL,
  `MONTH` varchar(50) DEFAULT NULL,
  `YEAR` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`DATA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin2;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `d_date`
--

LOCK TABLES `d_date` WRITE;
/*!40000 ALTER TABLE `d_date` DISABLE KEYS */;
/*!40000 ALTER TABLE `d_date` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `d_tipo_terzi`
--

DROP TABLE IF EXISTS `d_tipo_terzi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `d_tipo_terzi` (
  `ID_TIPO_TERZI` int(11) NOT NULL AUTO_INCREMENT,
  `TIPO_TERZI_COD` int(11) DEFAULT NULL,
  `TIPO_TERZI_DESCR` varchar(120) DEFAULT NULL,
  `NOME_TERZI` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`ID_TIPO_TERZI`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin2;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `d_tipo_terzi`
--

LOCK TABLES `d_tipo_terzi` WRITE;
/*!40000 ALTER TABLE `d_tipo_terzi` DISABLE KEYS */;
INSERT INTO `d_tipo_terzi` VALUES (1,3,'Magistrato','Gianmarco AlParco'),(2,5,'Richieste istituzionali','Pin Dalpom'),(3,970,'non codificato','Topo Gigio');
/*!40000 ALTER TABLE `d_tipo_terzi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `f_fatturazione`
--

DROP TABLE IF EXISTS `f_fatturazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `f_fatturazione` (
  `ID_FATTURAZIONE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_ASSISTITO` int(11) DEFAULT NULL,
  `ID_ENTE_EROGATORE` int(11) DEFAULT NULL,
  `DATA_INIZIO` date DEFAULT NULL,
  `DATA_FINE` date DEFAULT NULL,
  `IMPORTO_FATTURA` decimal(10,2) DEFAULT NULL,
  `GIORNATE` decimal(10,2) DEFAULT NULL,
  `ACCESSI_SERVIZIO` decimal(10,2) DEFAULT NULL,
  `NUMERO_PASTI` decimal(10,2) DEFAULT NULL,
  `NUMERO_TRASPORTI` decimal(10,2) DEFAULT NULL,
  `GIORNI_ASSENZA_GIUSTIFICATI` decimal(10,2) DEFAULT NULL,
  `GIORNI_ASSENZA_NON_GIUSTIFICATI` decimal(10,2) DEFAULT NULL,
  `ORE_EROGATE` decimal(10,2) DEFAULT NULL,
  `DATA_FATTURA` date DEFAULT NULL,
  PRIMARY KEY (`ID_FATTURAZIONE`),
  KEY `fk_F_FATTURAZIONE_D_ENTE_EROGATORE` (`ID_ENTE_EROGATORE`),
  KEY `fk_F_FATTURAZIONE_D_ASSISTITO` (`ID_ASSISTITO`),
  CONSTRAINT `fk_F_FATTURAZIONE_D_ASSISTITO` FOREIGN KEY (`ID_ASSISTITO`) REFERENCES `d_assistito` (`ID_ASSISTITO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_F_FATTURAZIONE_D_ENTE_EROGATORE` FOREIGN KEY (`ID_ENTE_EROGATORE`) REFERENCES `d_ente_erogatore` (`ID_ENTE_EROGATORE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin2;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `f_fatturazione`
--

LOCK TABLES `f_fatturazione` WRITE;
/*!40000 ALTER TABLE `f_fatturazione` DISABLE KEYS */;
/*!40000 ALTER TABLE `f_fatturazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_type`
--

DROP TABLE IF EXISTS `event_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_type` (
  `ID_EVENT_TYPE` int(11) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `EVENT_TYPE_CODE` int(11) DEFAULT NULL,
  `DESCRIZIONE` varchar(45) DEFAULT NULL,
  `VERSION` int(11) DEFAULT NULL,
  `ENTE_EROGATORE_COD` varchar(255) DEFAULT NULL,
  `ENTE_EROGATORE_DESCR` varchar(255) DEFAULT NULL,
  `POLO_COD` int(11) DEFAULT NULL,
  `POLO_DESCR` varchar(250) DEFAULT NULL,
  `ENTE_GESTORE_COD` int(11) DEFAULT NULL,
  `ENTE_GESTORE_DESCR` varchar(100) DEFAULT NULL,
  `VERSION_EXPIRATION_DATE` datetime DEFAULT NULL,
  `IS_VALID` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID_EVENT_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin2;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_type`
--

LOCK TABLES `event_type` WRITE;
/*!40000 ALTER TABLE `event_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `d_richiedente`
--

DROP TABLE IF EXISTS `d_richiedente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `d_richiedente` (
  `ID_RICHIEDENTE` int(11) NOT NULL AUTO_INCREMENT,
  `RICHIEDENTE_COD` int(11) DEFAULT NULL,
  `RICHIEDENTE_DESCR` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_RICHIEDENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin2;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `d_richiedente`
--

LOCK TABLES `d_richiedente` WRITE;
/*!40000 ALTER TABLE `d_richiedente` DISABLE KEYS */;
INSERT INTO `d_richiedente` VALUES (1,0,''),(2,2,'Terzi'),(3,1,'Interessato');
/*!40000 ALTER TABLE `d_richiedente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `f_cartella`
--

DROP TABLE IF EXISTS `f_cartella`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `f_cartella` (
  `ID_CARTELLA` int(11) NOT NULL AUTO_INCREMENT,
  `NUMERO_SCHEDA` varchar(38) DEFAULT NULL,
  `PRESA_CARICO_NUM` int(11) DEFAULT NULL,
  `DATA_ACCESSO` date DEFAULT NULL,
  `ID_ASSISTITO` int(11) NOT NULL,
  `ID_SEGNALANTE` int(11) NOT NULL,
  `ID_TIPO_TERZI` int(11) DEFAULT NULL,
  `ID_RICHIEDENTE` int(11) NOT NULL,
  `ID_OPERATORE` int(11) DEFAULT NULL,
  `FINE_PRESA_CARICO` date DEFAULT NULL,
  `GIORNATE_SETTIMANALI` decimal(7,2) DEFAULT NULL,
  `NUMERO_PASTI_SETTIMANALI` decimal(7,2) DEFAULT NULL,
  `NUMERO_TRASPORTI_SETTIMANALI` decimal(7,2) DEFAULT NULL,
  `ORE_SETTIMANALI` decimal(7,2) DEFAULT NULL,
  `INIZIO_PRESA_CARICO` date DEFAULT NULL,
  `DATA_DOMANDA` date DEFAULT NULL,
  PRIMARY KEY (`ID_CARTELLA`),
  KEY `fk_F_CARTELLA_D_ASSISTITO` (`ID_ASSISTITO`),
  KEY `fk_F_CARTELLA_D_SEGNALANTE` (`ID_SEGNALANTE`),
  KEY `fk_F_CARTELLA_D_TIPO_TERZI` (`ID_TIPO_TERZI`),
  KEY `fk_F_CARTELLA_D_RICHIEDENTE` (`ID_RICHIEDENTE`),
  KEY `fk_F_CARTELLA_D_OPERATORE` (`ID_OPERATORE`),
  CONSTRAINT `fk_F_CARTELLA_D_ASSISTITO` FOREIGN KEY (`ID_ASSISTITO`) REFERENCES `d_assistito` (`ID_ASSISTITO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_F_CARTELLA_D_RICHIEDENTE` FOREIGN KEY (`ID_RICHIEDENTE`) REFERENCES `d_richiedente` (`ID_RICHIEDENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_F_CARTELLA_D_SEGNALANTE` FOREIGN KEY (`ID_SEGNALANTE`) REFERENCES `d_segnalante` (`ID_SEGNALANTE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin2;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `f_cartella`
--

LOCK TABLES `f_cartella` WRITE;
/*!40000 ALTER TABLE `f_cartella` DISABLE KEYS */;
INSERT INTO `f_cartella` VALUES (53,'27',1,'2012-03-16',59,4,2,2,0,NULL,4.00,5.00,23.00,90.00,'2012-03-08','2012-03-05'),(54,'29',5,'2012-03-14',66,3,0,3,0,NULL,6.00,6.00,34.00,90.00,'2012-03-14','2012-03-05'),(55,'28',4,'2012-03-15',62,5,3,2,0,NULL,5.00,4.00,34.00,70.00,'2012-03-15','2012-03-05');
/*!40000 ALTER TABLE `f_cartella` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `d_ente_erogatore`
--

DROP TABLE IF EXISTS `d_ente_erogatore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `d_ente_erogatore` (
  `ID_ENTE_EROGATORE` int(11) NOT NULL AUTO_INCREMENT,
  `ENTE_EROGATORE_COD` varchar(255) DEFAULT NULL,
  `ENTE_EROGATORE_DESCR` varchar(255) DEFAULT NULL,
  `POLO_COD` int(11) DEFAULT NULL,
  `POLO_DESCR` varchar(250) DEFAULT NULL,
  `ENTE_GESTORE_COD` int(11) DEFAULT NULL,
  `ENTE_GESTORE_DESCR` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_ENTE_EROGATORE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin2;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `d_ente_erogatore`
--

LOCK TABLES `d_ente_erogatore` WRITE;
/*!40000 ALTER TABLE `d_ente_erogatore` DISABLE KEYS */;
/*!40000 ALTER TABLE `d_ente_erogatore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `field_type`
--

DROP TABLE IF EXISTS `field_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `field_type` (
  `ID_FIELD_TYPE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_EVENT_TYPE` int(11) DEFAULT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `TYPE` varchar(45) DEFAULT NULL,
  `IS_TESTATA` tinyint(1) DEFAULT NULL COMMENT 'Indica se il campo fa parte della testata oppure no',
  `POSIZIONE` int(11) DEFAULT NULL COMMENT 'Indica la posizione del campo nel tracciato',
  PRIMARY KEY (`ID_FIELD_TYPE`),
  KEY `fk_FIELD_TYPE_EVENT_TYPE` (`ID_EVENT_TYPE`),
  CONSTRAINT `fk_FIELD_TYPE_EVENT_TYPE` FOREIGN KEY (`ID_EVENT_TYPE`) REFERENCES `event_type` (`ID_EVENT_TYPE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin2;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `field_type`
--

LOCK TABLES `field_type` WRITE;
/*!40000 ALTER TABLE `field_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `field_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `errors`
--

DROP TABLE IF EXISTS `errors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `errors` (
  `ID_ERRORS` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(45) DEFAULT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ID_ERRORS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin2;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `errors`
--

LOCK TABLES `errors` WRITE;
/*!40000 ALTER TABLE `errors` DISABLE KEYS */;
/*!40000 ALTER TABLE `errors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `d_segnalante`
--

DROP TABLE IF EXISTS `d_segnalante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `d_segnalante` (
  `ID_SEGNALANTE` int(11) NOT NULL AUTO_INCREMENT,
  `SEGNALANTE_COD` int(11) DEFAULT NULL,
  `SEGNALANTE_DESCR` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_SEGNALANTE`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin2;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `d_segnalante`
--

LOCK TABLES `d_segnalante` WRITE;
/*!40000 ALTER TABLE `d_segnalante` DISABLE KEYS */;
INSERT INTO `d_segnalante` VALUES (1,0,''),(2,19,'Consultorio'),(3,17,'Forze dell\'ordine'),(4,1,'Parente'),(5,14,'Servizio alcologia');
/*!40000 ALTER TABLE `d_segnalante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `d_operatore`
--

DROP TABLE IF EXISTS `d_operatore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `d_operatore` (
  `ID_OPERATORE` int(11) NOT NULL AUTO_INCREMENT,
  `OPERATORE_COD` int(11) DEFAULT NULL,
  `NOME` varchar(100) DEFAULT NULL,
  `COGNOME` varchar(100) DEFAULT NULL,
  `POLO_COD` int(11) DEFAULT NULL,
  `POLO_DESCR` varchar(250) DEFAULT NULL,
  `ENTE_GESTORE_COD` int(11) DEFAULT NULL,
  `ENTE_GESTORE_DESCR` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_OPERATORE`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=latin2;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `d_operatore`
--

LOCK TABLES `d_operatore` WRITE;
/*!40000 ALTER TABLE `d_operatore` DISABLE KEYS */;
INSERT INTO `d_operatore` VALUES (91,342,'Bianca','Verdi',142,'COMPRENSORIO C4 - ALTA VALSUGANA',14,'COMPRENSORIO C4 - ALTA VALSUGANA'),(92,500,'Marisa','Bianchi',142,'COMPRENSORIO C4 - ALTA VALSUGANA',14,'COMPRENSORIO C4 - ALTA VALSUGANA'),(93,343,'Tefo','Roberto',717,'Val di Sole',111,'Distretto Alta Valsugana'),(94,554,'Verdi','Elena',52,'AREA CENTRI DIURNI',102,'Distretto di Trento e Valle dei Laghi'),(95,234,'DalPin','Abele',142,'Area adulti/anziani',111,'Distretto Alta Valsugana'),(96,500,'Marisa','Bianchi',51,'AREA ADOZIONE',101,'APSS'),(97,332,'Lorenzo','Jorge',3,'POLO S.GIUSEPPE, S.CHIARA, RAVINA ROMAGNANO',1,'COMUNE DI TRENTO'),(98,343,'Tefo','Roberto',142,'COMPRENSORIO C4 - ALTA VALSUGANA',14,'COMPRENSORIO C1 - VALLE DI FIEMME'),(99,332,'Maery','Niger',717,'Val di Sole',14,'COMPRENSORIO C4 - ALTA VALSUGANA');
/*!40000 ALTER TABLE `d_operatore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `d_assistito`
--

DROP TABLE IF EXISTS `d_assistito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `d_assistito` (
  `ID_ASSISTITO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_ANAGRAFE_LOCALE` int(11) DEFAULT NULL,
  `MITTENTE_NOME_ENTE` varchar(255) DEFAULT NULL,
  `MITTENTE_URL_ENTE` varchar(255) DEFAULT NULL,
  `ANAG_URL_ENTE` varchar(255) DEFAULT NULL,
  `ANAG_ID_ANAGRAFE` varchar(50) DEFAULT NULL,
  `ID_ASS_SOC` int(11) DEFAULT NULL,
  `HASH_COD` varchar(255) DEFAULT NULL,
  `DATA_NASCITA` date DEFAULT NULL,
  `COMUNE_NASCITA_COD` int(11) DEFAULT NULL,
  `COMUNE_NASCITA_DESCR` varchar(255) DEFAULT NULL,
  `COMUNE_RESIDENZA_COD` int(11) DEFAULT NULL,
  `COMUNE_RESIDENZA_DESCR` varchar(255) DEFAULT NULL,
  `SESSO` char(1) DEFAULT NULL,
  `CAP` varchar(5) DEFAULT NULL,
  `STATO_CIVILE_COD` int(11) DEFAULT NULL,
  `STATO_CIVILE_DESCR` varchar(255) DEFAULT NULL,
  `NAZIONALITA_COD` int(11) DEFAULT NULL,
  `NAZIONALITA_DESCR` varchar(255) DEFAULT NULL,
  `CITTADINANZA_COD` int(11) DEFAULT NULL,
  `CITTADINANZA_DESCR` varchar(25) DEFAULT NULL,
  `POLO_COD` int(11) DEFAULT NULL,
  `POLO_DESCR` varchar(250) DEFAULT NULL,
  `ENTE_GESTORE_COD` int(11) DEFAULT NULL,
  `ENTE_GESTORE_DESCR` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_ASSISTITO`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=latin2;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `d_assistito`
--

LOCK TABLES `d_assistito` WRITE;
/*!40000 ALTER TABLE `d_assistito` DISABLE KEYS */;
INSERT INTO `d_assistito` VALUES (59,1022,'COMPRENSORIO C4 - ALTA VALSUGANA','COMPRENSORIO C4 - ALTA VALSUGANA','COMPRENSORIO C4 - ALTA VALSUGANA','COMPRENSORIO C4 - ALTA VALSUGANA',342,'73ef3de14c9a6186f806c03f3b6f3e5d','1988-02-19',22005,'TRENTO',22011,'BEDOLLO','M','38043',1,'Celibe o nubile',100,'ITALIA',100,'ITALIA',142,'COMPRENSORIO C4 - ALTA VALSUGANA',14,'COMPRENSORIO C4 - ALTA VALSUGANA'),(60,701,'COMPRENSORIO C4 - ALTA VALSUGANA','COMPRENSORIO C4 - ALTA VALSUGANA','COMPRENSORIO C4 - ALTA VALSUGANA','COMPRENSORIO C4 - ALTA VALSUGANA',500,'27635e6c74dd51d073882bd7f6ecfe7d','1960-05-19',22011,'BEDOLLO',22011,'BEDOLLO','M','38043',2,'Coniugato/a (coabitante con il coniuge)',100,'ITALIA',100,'ITALIA',142,'COMPRENSORIO C4 - ALTA VALSUGANA',14,'COMPRENSORIO C4 - ALTA VALSUGANA'),(61,2005,'COMPRENSORIO C4 - ALTA VALSUGANA','COMPRENSORIO C4 - ALTA VALSUGANA','COMPRENSORIO C4 - ALTA VALSUGANA','COMPRENSORIO C4 - ALTA VALSUGANA',343,'b3d78471bbdc69f25499d350a306663a','1956-01-25',22139,'PERGINE VALSUGANA',22139,'PERGINE VALSUGANA','M','38043',1,'Celibe o nubile',100,'ITALIA',100,'ITALIA',717,'Val di Sole',111,'Distretto Alta Valsugana'),(62,5672,'Distretto di Trento e Valle dei Laghi','Distretto di Trento e Valle dei Laghi','Distretto di Trento e Valle dei Laghi','Distretto di Trento e Valle dei Laghi',554,'f8eb6d5e2d3e2b0bea2837ff3f0e46aa','1988-12-05',22005,'TRENTO',22139,'PERGINE VALSUGANA','M','38057',1,'Celibe o nubile',100,'ITALIA',100,'ITALIA',52,'AREA CENTRI DIURNI',102,'Distretto di Trento e Valle dei Laghi'),(63,6022,'Distretto di Trento e Valle dei Laghi','Distretto di Trento e Valle dei Laghi','Distretto di Trento e Valle dei Laghi','Distretto di Trento e Valle dei Laghi',234,'c3ff6e4c415a3e2948f63c666ee7e015','1993-07-03',22005,'TRENTO',22139,'PERGINE VALSUGANA','F','38043',1,'Celibe o nubile',100,'ITALIA',100,'ITALIA',142,'Area adulti/anziani',111,'Distretto Alta Valsugana'),(64,4509,'RSA Istituto Arcivescovale Sordomuti ','RSA Istituto Arcivescovale Sordomuti','COMPRENSORIO C4 - ALTA VALSUGANo','COMPRENSORIO C4 - ALTA VALSUGAN',500,'eeb01fe9f0574aef7c065b0055073d5b','1960-03-28',22009,'BASELGA DI PINE',22011,'BEDOLLO','F','38043',2,'Coniugato/a (coabitante con il coniuge)',100,'ITALIA',100,'ITALIA',51,'AREA ADOZIONE',101,'APSS'),(65,7080,'RSA Istituto Arcivescovale Sordomuti ','RSA Istituto Arcivescovale Sordomuti','COMPRENSORIO C4 - ALTA VALSUGANo','COMPRENSORIO C4 - ALTA VALSUGAN',234,'86fa82bdcc7dd9dcc018460499213c2d','1963-06-18',22006,'ARCO',22139,'PERGINE VALSUGANA','F','38043',2,'Coniugato/a (coabitante con il coniuge)',100,'ITALIA',100,'ITALY',142,'COMPRENSORIO C4 - ALTA VALSUGANA',111,'Distretto Alta Valsugana'),(66,6666,'RSA Istituto Arcivescovale Sordomuti ','RSA Istituto Arcivescovale Sordomuti','COMPRENSORIO C4 - ALTA VALSUGANo','COMPRENSORIO C4 - ALTA VALSUGAN',332,'8f2e4e440eb1c0044eee4b869c8b5294','1986-08-12',440000,'MOZAMBICO',22011,'BEDOLLO','M','38043',1,'Celibe o Nubile',440,'MOZAMBICO',440,'MOZAMBICO',3,'POLO S.GIUSEPPE, S.CHIARA, RAVINA ROMAGNANO',1,'COMUNE DI TRENTO'),(67,4578,'COMPRENSORIO C10 - VALLAGARINA','COMPRENSORIO C10 - VALLAGARINA','COMPRENSORIO C10 - VALLAGARINA','COMPRENSORIO C10 - VALLAGARINA',343,'098b72a5f95bbdf6e60f2ac9d96619ac','1945-11-30',52015,'MONTEPULCIANO',58091,'ROMA','M','38012',1,'Celibe o nubile',100,'ITALIA',100,'ITALIA',142,'COMPRENSORIO C4 - ALTA VALSUGANA',14,'COMPRENSORIO C1 - VALLE DI FIEMME'),(68,15600,'RSA Sacra Famiglia di Arco','RSA Sacra Famiglia di Arco','RSA Sacra Famiglia di Arco','RSA Sacra Famiglia di Arco',332,'7f9e6bf0eeb98a36085d9469e94f6916','1930-05-12',15146,'MILANO',15008,'ARCORE','M','38129',5,'Divorziato/a o gia coniugato',100,'ITALIA',100,'ITALY',717,'Val di Sole',14,'COMPRENSORIO C4 - ALTA VALSUGANA');
/*!40000 ALTER TABLE `d_assistito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `d_nucleo_familiare`
--

DROP TABLE IF EXISTS `d_nucleo_familiare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `d_nucleo_familiare` (
  `ID_NUCLEO` int(11) NOT NULL AUTO_INCREMENT,
  `CODICE_NUCLEO` int(11) DEFAULT NULL,
  `HASH_COD` varchar(255) DEFAULT NULL,
  `GRADO_PARENTELA_COD` int(11) DEFAULT NULL,
  `GRADO_PARENTELA_DESCR` varchar(50) DEFAULT NULL,
  `DATA_NASCITA` date DEFAULT NULL,
  `ID_ASSISTITO` int(11) NOT NULL,
  PRIMARY KEY (`ID_NUCLEO`),
  KEY `fk_D_NUCLEO_FAMILIARE_D_ASSISTITO` (`ID_ASSISTITO`),
  CONSTRAINT `fk_D_NUCLEO_FAMILIARE_D_ASSISTITO` FOREIGN KEY (`ID_ASSISTITO`) REFERENCES `d_assistito` (`ID_ASSISTITO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin2;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `d_nucleo_familiare`
--

LOCK TABLES `d_nucleo_familiare` WRITE;
/*!40000 ALTER TABLE `d_nucleo_familiare` DISABLE KEYS */;
INSERT INTO `d_nucleo_familiare` VALUES (31,1,'27635e6c74dd51d073882bd7f6ecfe7d',1,'CAPO FAMIGLIA','1960-05-19',60),(32,1,'73ef3de14c9a6186f806c03f3b6f3e5d',4,'Figlio/a','1988-02-19',59),(33,1,'eeb01fe9f0574aef7c065b0055073d5b',3,'Moglie','1960-03-28',64),(34,2,'b3d78471bbdc69f25499d350a306663a',1,'CAPO FAMIGLIA','1956-01-25',61),(35,2,'f8eb6d5e2d3e2b0bea2837ff3f0e46aa',4,'Figlio/a','1988-12-05',62),(36,2,'c3ff6e4c415a3e2948f63c666ee7e015',4,'Figlio/a','1993-07-03',63),(37,2,'86fa82bdcc7dd9dcc018460499213c2d',3,'Moglie','1963-06-18',65),(38,4,'8f2e4e440eb1c0044eee4b869c8b5294',58,'Vicino/a','1986-08-12',66),(39,5,'098b72a5f95bbdf6e60f2ac9d96619ac',55,'Rappresentante legale','1945-11-30',67),(40,3,'7f9e6bf0eeb98a36085d9469e94f6916',1,'CAPO FAMIGLIA','1930-05-12',68);
/*!40000 ALTER TABLE `d_nucleo_familiare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_load`
--

DROP TABLE IF EXISTS `event_load`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_load` (
  `ID_EVENT_LOAD` int(11) NOT NULL AUTO_INCREMENT,
  `ID_EVENT_TYPE` int(11) DEFAULT NULL,
  `RECEIVE_TIME` datetime DEFAULT NULL COMMENT 'Indicates when the event has been received by the DWS wrapper',
  `LOAD_TIME` datetime DEFAULT NULL COMMENT 'Indicates when the event has been loaded in the DWS',
  `IS_LOADED` tinyint(1) DEFAULT NULL,
  `ID_ERRORS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_EVENT_LOAD`),
  KEY `fk_EVENT_LOAD_EVENT_TYPE` (`ID_EVENT_TYPE`),
  KEY `fk_EVENT_LOAD_ERRORS` (`ID_ERRORS`),
  CONSTRAINT `fk_EVENT_LOAD_ERRORS` FOREIGN KEY (`ID_ERRORS`) REFERENCES `errors` (`ID_ERRORS`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_EVENT_LOAD_EVENT_TYPE` FOREIGN KEY (`ID_EVENT_TYPE`) REFERENCES `event_type` (`ID_EVENT_TYPE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin2;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_load`
--

LOCK TABLES `event_load` WRITE;
/*!40000 ALTER TABLE `event_load` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_load` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `d_area_utenza`
--

DROP TABLE IF EXISTS `d_area_utenza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `d_area_utenza` (
  `ID_AREA_UTENZA` int(11) NOT NULL AUTO_INCREMENT,
  `AREA_UTENZA_COD` int(11) DEFAULT NULL,
  `AREA_UTENZA_DESCR` varchar(255) DEFAULT NULL,
  `DATA_INIZIO_VAL` date DEFAULT NULL,
  `DATA_FINE_VAL` date DEFAULT NULL,
  `ID_ASSISTITO` int(11) NOT NULL,
  PRIMARY KEY (`ID_AREA_UTENZA`),
  KEY `fk_D_AREA_UTENZA_D_ASSISTITO` (`ID_ASSISTITO`),
  CONSTRAINT `fk_D_AREA_UTENZA_D_ASSISTITO` FOREIGN KEY (`ID_ASSISTITO`) REFERENCES `d_assistito` (`ID_ASSISTITO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=latin2;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `d_area_utenza`
--

LOCK TABLES `d_area_utenza` WRITE;
/*!40000 ALTER TABLE `d_area_utenza` DISABLE KEYS */;
INSERT INTO `d_area_utenza` VALUES (98,109,'Alcolisti','2012-03-05','2012-03-05',62),(99,110,'Senza dimora','2012-03-05','2012-03-05',60),(100,107,'Utenti con problemi di salute mentale','2012-03-05','2012-03-05',59),(101,111,'Detenuti ed ex detenuti','2012-03-05','2012-03-05',65),(102,108,'Tossicodipendenti','2012-03-05','2012-03-05',66);
/*!40000 ALTER TABLE `d_area_utenza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_data`
--

DROP TABLE IF EXISTS `event_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_data` (
  `ID_EVENT_DATA` int(11) NOT NULL AUTO_INCREMENT,
  `ID_FIELD_TYPE` int(11) DEFAULT NULL,
  `VALUE` varchar(255) DEFAULT NULL,
  `ID_EVENT_LOAD` int(11) DEFAULT NULL,
  `IS_LOADED` tinyint(1) DEFAULT NULL,
  `ID_ERRORS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_EVENT_DATA`),
  KEY `fk_EVENT_DATA_FIELD_TYPE` (`ID_FIELD_TYPE`),
  KEY `fk_EVENT_DATA_EVENT_LOAD` (`ID_EVENT_LOAD`),
  KEY `fk_EVENT_DATA_ERRORS` (`ID_ERRORS`),
  CONSTRAINT `fk_EVENT_DATA_ERRORS` FOREIGN KEY (`ID_ERRORS`) REFERENCES `errors` (`ID_ERRORS`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_EVENT_DATA_EVENT_LOAD` FOREIGN KEY (`ID_EVENT_LOAD`) REFERENCES `event_load` (`ID_EVENT_LOAD`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_EVENT_DATA_FIELD_TYPE` FOREIGN KEY (`ID_FIELD_TYPE`) REFERENCES `field_type` (`ID_FIELD_TYPE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin2;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_data`
--

LOCK TABLES `event_data` WRITE;
/*!40000 ALTER TABLE `event_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-03-15 15:39:49
