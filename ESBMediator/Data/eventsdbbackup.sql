CREATE DATABASE  IF NOT EXISTS `dwh` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dwh`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: dwh
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-03-08  7:55:26
CREATE DATABASE  IF NOT EXISTS `eventsdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `eventsdb`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: eventsdb
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
-- Table structure for table `presaincarico`
--

DROP TABLE IF EXISTS `presaincarico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `presaincarico` (
  `PresaInCaricoNum` int(11) NOT NULL,
  `PresaInCaricoData` datetime NOT NULL,
  `ChiusuraData` datetime NOT NULL,
  PRIMARY KEY (`PresaInCaricoNum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presaincarico`
--

LOCK TABLES `presaincarico` WRITE;
/*!40000 ALTER TABLE `presaincarico` DISABLE KEYS */;
/*!40000 ALTER TABLE `presaincarico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nucleofamiliare`
--

DROP TABLE IF EXISTS `nucleofamiliare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nucleofamiliare` (
  `CodiceNucleo` int(11) NOT NULL,
  `IdPatient` int(11) NOT NULL,
  `GradoParentelaCod` int(11) NOT NULL,
  `GradoParentelaDescr` varchar(50) NOT NULL,
  KEY `FK_Patient` (`IdPatient`),
  CONSTRAINT `FK_Patient` FOREIGN KEY (`IdPatient`) REFERENCES `patient` (`IdAnagrafeLocale`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nucleofamiliare`
--

LOCK TABLES `nucleofamiliare` WRITE;
/*!40000 ALTER TABLE `nucleofamiliare` DISABLE KEYS */;
/*!40000 ALTER TABLE `nucleofamiliare` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `eventdescription` VALUES (1,'2012-03-05 12:34:54','2012-03-05 16:00:00',1,'Inserimento Variazione Anagrafica','0001',900006099,'RSA',14,142,'COMPRENSORIO C4 - ALTA VALSUGANA','COMPRENSORIO C4 - ALTA VALSUGANA'),(2,'2012-03-07 12:00:54','2012-03-07 12:15:54',1,'Inserimento Variazione Anagrafica','0002',900001005,'Telesoccorso e telecontrollo (teleassistenza)',102,52,'AREA CENTRI DIURNI','Distretto di Trento e Valle dei Laghi'),(3,'2012-03-08 14:54:54','2012-03-09 16:00:00',1,'Inserimento Variazione Anagrafic','0003',900006099,'RSA',14,142,'COMPRENSORIO C4 - ALTA VALSUGANA','COMPRENSORIO C4 - ALTA VALSUGANA'),(4,'2012-03-08 06:06:00','2012-03-09 00:00:00',1,'Inserimento Variazione Anagrafic','0004',900006099,'RSA',101,51,'AREA ADOZIONE','APSS'),(5,'2012-03-04 08:06:00','2012-03-05 05:06:00',1,'Inserimento Variazione Anagrafica','0005',103001000,'Aiuto per l\'accesso ai servizi – Assistenza domiciliare',111,142,'Area adulti/anziani','Distretto Alta Valsugana');
/*!40000 ALTER TABLE `eventdescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assegnazionedatautenza`
--

DROP TABLE IF EXISTS `assegnazionedatautenza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assegnazionedatautenza` (
  `DataInizioValidita` datetime NOT NULL,
  `PresaInCaricoNum` int(11) NOT NULL,
  `AreaUtenzaCod` varchar(3) NOT NULL,
  `AreaUtenzaString` varchar(255) NOT NULL,
  `DataFineValidita` datetime NOT NULL,
  KEY `PresaInCaricoNum` (`PresaInCaricoNum`),
  CONSTRAINT `PresaInCaricoNum` FOREIGN KEY (`PresaInCaricoNum`) REFERENCES `presaincarico` (`PresaInCaricoNum`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assegnazionedatautenza`
--

LOCK TABLES `assegnazionedatautenza` WRITE;
/*!40000 ALTER TABLE `assegnazionedatautenza` DISABLE KEYS */;
/*!40000 ALTER TABLE `assegnazionedatautenza` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `inserimentovariazioneanagrafica` VALUES ('TRENTO',1,'Celibe o nubile',100,'ITALIA','BEDOLLO','M','Del Redebus 24','38043',100,'ITALIA',342,'Verdi','Bianca',1,'\0'),('TRENTO',1,'Celibe o nubile',100,'ITALIA','PERGINE VALSUGANA','M','Lagorai 81','38057',100,'ITALIA',554,'Elena','Verdi',2,'\0'),('BEDOLLO',2,'Coniugato/a (coabitante con il coniuge)',100,'ITALIA','BEDOLLO','M','Del Redebus 24','38043',100,'ITALIA',500,'Bianchi','Marisa',3,'\0'),('BASELGA DI PINE',2,'Coniugato/a (coabitante con il coniuge)',100,'ITALIA','BEDOLLO','F','Del Redebus 24','38043',100,'ITALIA',500,'Bianchi','Marisa',4,'\0'),('TRENTO',1,'Celibe o nubile',100,'ITALIA','PERGINE VALSUGANA','F','Lagorai 81','38043',100,'ITALIA',234,'Abele','DalPin',5,'\0');
/*!40000 ALTER TABLE `inserimentovariazioneanagrafica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `header`
--

DROP TABLE IF EXISTS `header`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `header` (
  `IdHeader` int(11) NOT NULL,
  `NomeEnte` varchar(45) NOT NULL,
  `UrlEnteMittente` varchar(45) NOT NULL,
  `UrlEnteAnagrafe` varchar(45) NOT NULL,
  `IdAnagrafe` varchar(45) NOT NULL,
  PRIMARY KEY (`IdHeader`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `header`
--

LOCK TABLES `header` WRITE;
/*!40000 ALTER TABLE `header` DISABLE KEYS */;
INSERT INTO `header` VALUES (1,'COMPRENSORIO C4 - ALTA VALSUGANA','COMPRENSORIO C4 - ALTA VALSUGANA','COMPRENSORIO C4 - ALTA VALSUGANA','COMPRENSORIO C4 - ALTA VALSUGANA'),(2,'Distretto di Trento e Valle dei Laghi','Distretto di Trento e Valle dei Laghi','Distretto di Trento e Valle dei Laghi','Distretto di Trento e Valle dei Laghi'),(3,'RSA Istituto Arcivescovale Sordomuti ','RSA Istituto Arcivescovale Sordomuti','COMPRENSORIO C4 - ALTA VALSUGANo','COMPRENSORIO C4 - ALTA VALSUGAN');
/*!40000 ALTER TABLE `header` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedaaccesso`
--

DROP TABLE IF EXISTS `schedaaccesso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedaaccesso` (
  `DataAccesso` datetime NOT NULL,
  `NumeroScheda` varchar(38) NOT NULL,
  `TipoServizioRichiestoCod` varchar(9) DEFAULT NULL,
  `TipoServizioRichiestoDescr` varchar(255) DEFAULT NULL,
  `TipoRichiedenteCod` varchar(9) NOT NULL,
  `TipoRichiedenteDescr` varchar(255) NOT NULL,
  `TipoTerziCod` int(11) DEFAULT NULL,
  `TipoTerziDescr` varchar(120) DEFAULT NULL,
  `NomeTerzi` varchar(60) DEFAULT NULL,
  `TipoSegnalanteCod` int(11) DEFAULT NULL,
  `TipoSetgnalanteDescr` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedaaccesso`
--

LOCK TABLES `schedaaccesso` WRITE;
/*!40000 ALTER TABLE `schedaaccesso` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedaaccesso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ricezionedomandaamministrativa`
--

DROP TABLE IF EXISTS `ricezionedomandaamministrativa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ricezionedomandaamministrativa` (
  `DataDomanda` datetime NOT NULL,
  `GiornateSettimanali` int(11) NOT NULL,
  `NumeroPastiSettimanali` int(11) NOT NULL,
  `NumeroTrasportiSettimanali` int(11) NOT NULL,
  `OreSettimanali` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ricezionedomandaamministrativa`
--

LOCK TABLES `ricezionedomandaamministrativa` WRITE;
/*!40000 ALTER TABLE `ricezionedomandaamministrativa` DISABLE KEYS */;
/*!40000 ALTER TABLE `ricezionedomandaamministrativa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fatturazioneperiodica`
--

DROP TABLE IF EXISTS `fatturazioneperiodica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fatturazioneperiodica` (
  `DataFattura` datetime NOT NULL,
  `CodiceCentro` int(11) NOT NULL,
  `DenominazioneCentro` varchar(255) NOT NULL,
  `DataInizio` date NOT NULL,
  `DataFine` date NOT NULL,
  `ImportoFattura` int(11) NOT NULL,
  `Giornate` int(11) NOT NULL,
  `AccessiServizio` int(11) DEFAULT NULL,
  `NumeroPasti` int(11) DEFAULT NULL,
  `NumeroTrasporti` int(11) DEFAULT NULL,
  `GiorniAssenzaGiustificati` int(11) DEFAULT NULL,
  `GiorniAssenzaNonGiustificati` int(11) DEFAULT NULL,
  `OreErogate` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fatturazioneperiodica`
--

LOCK TABLES `fatturazioneperiodica` WRITE;
/*!40000 ALTER TABLE `fatturazioneperiodica` DISABLE KEYS */;
/*!40000 ALTER TABLE `fatturazioneperiodica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events` (
  `idEvent` int(11) NOT NULL,
  `IdPatient` int(11) NOT NULL,
  `IdHeader` int(11) NOT NULL,
  `IdEventDescr` int(11) NOT NULL,
  PRIMARY KEY (`idEvent`),
  KEY `IdPatient` (`IdPatient`),
  KEY `IdHeader` (`IdHeader`),
  KEY `IdEventDescr` (`IdEventDescr`),
  CONSTRAINT `IdEventDescr` FOREIGN KEY (`IdEventDescr`) REFERENCES `eventdescription` (`IdEvent`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `IdHeader` FOREIGN KEY (`IdHeader`) REFERENCES `header` (`IdHeader`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `IdPatient` FOREIGN KEY (`IdPatient`) REFERENCES `patient` (`IdAnagrafeLocale`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1,1022,1,1),(2,5672,2,2),(3,701,1,3),(4,4509,3,4),(5,6022,2,5);
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-03-08  7:55:26
