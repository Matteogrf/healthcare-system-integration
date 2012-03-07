SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';


-- -----------------------------------------------------
-- Table `eventsdb`.`presaincarico`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `eventsdb`.`presaincarico` (
  `PresaInCaricoNum` INT(11) NOT NULL ,
  `PresaInCaricoData` DATETIME NOT NULL ,
  `ChiusuraData` DATETIME NOT NULL ,
  PRIMARY KEY (`PresaInCaricoNum`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `eventsdb`.`assegnazionedatautenza`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `eventsdb`.`assegnazionedatautenza` (
  `DataInizioValidita` DATETIME NOT NULL ,
  `PresaInCaricoNum` INT(11) NOT NULL ,
  `AreaUtenzaCod` VARCHAR(3) NOT NULL ,
  `AreaUtenzaString` VARCHAR(255) NOT NULL ,
  `DataFineValidita` DATETIME NOT NULL ,
  INDEX `PresaInCaricoNum` (`PresaInCaricoNum` ASC) ,
  CONSTRAINT `PresaInCaricoNum`
    FOREIGN KEY (`PresaInCaricoNum` )
    REFERENCES `eventsdb`.`presaincarico` (`PresaInCaricoNum` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `eventsdb`.`eventdescription`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `eventsdb`.`eventdescription` (
  `IdEvent` INT(11) NOT NULL ,
  `DataOraEvento` DATETIME NOT NULL ,
  `DataOraRegEvento` DATETIME NOT NULL ,
  `TipoEventoCod` INT(11) NOT NULL ,
  `TipoEventoDescr` VARCHAR(250) NOT NULL ,
  `IdInterventoPratica` VARCHAR(7) NULL DEFAULT NULL ,
  `ServizioCod` INT(11) NOT NULL ,
  `ServizioDescr` VARCHAR(250) NOT NULL ,
  `ProduttoreCod` INT(11) NOT NULL ,
  `UnitàOrganizzativaCod` INT(11) NOT NULL ,
  `UnitàOrganizzativaDescr` VARCHAR(100) NOT NULL ,
  `ProduttoreDescr` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`IdEvent`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `eventsdb`.`patient`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `eventsdb`.`patient` (
  `IdAnagrafeLocale` INT(11) NOT NULL ,
  `Nome` VARCHAR(100) NOT NULL ,
  `Cognome` VARCHAR(100) NOT NULL ,
  `CodiceFiscale` VARCHAR(16) NULL DEFAULT NULL ,
  `ComuneNascitaCod` VARCHAR(7) NOT NULL ,
  `ComuneResidenzaCod` VARCHAR(7) NOT NULL ,
  `DataNascita` DATE NOT NULL ,
  PRIMARY KEY (`IdAnagrafeLocale`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `eventsdb`.`header`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `eventsdb`.`header` (
  `IdHeader` INT(11) NOT NULL ,
  `NomeEnte` VARCHAR(45) NOT NULL ,
  `UrlEnteMittente` VARCHAR(45) NOT NULL ,
  `UrlEnteAnagrafe` VARCHAR(45) NOT NULL ,
  `IdAnagrafe` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`IdHeader`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `eventsdb`.`events`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `eventsdb`.`events` (
  `idEvent` INT(11) NOT NULL ,
  `IdPatient` INT(11) NOT NULL ,
  `IdHeader` INT(11) NOT NULL ,
  `IdEventDescr` INT(11) NOT NULL ,
  PRIMARY KEY (`idEvent`) ,
  INDEX `IdPatient` (`IdPatient` ASC) ,
  INDEX `IdHeader` (`IdHeader` ASC) ,
  INDEX `IdEventDescr` (`IdEventDescr` ASC) ,
  CONSTRAINT `IdPatient`
    FOREIGN KEY (`IdPatient` )
    REFERENCES `eventsdb`.`patient` (`IdAnagrafeLocale` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `IdHeader`
    FOREIGN KEY (`IdHeader` )
    REFERENCES `eventsdb`.`header` (`IdHeader` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `IdEventDescr`
    FOREIGN KEY (`IdEventDescr` )
    REFERENCES `eventsdb`.`eventdescription` (`IdEvent` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `eventsdb`.`fatturazioneperiodica`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `eventsdb`.`fatturazioneperiodica` (
  `DataFattura` DATETIME NOT NULL ,
  `CodiceCentro` INT(11) NOT NULL ,
  `DenominazioneCentro` VARCHAR(255) NOT NULL ,
  `DataInizio` DATE NOT NULL ,
  `DataFine` DATE NOT NULL ,
  `ImportoFattura` INT(11) NOT NULL ,
  `Giornate` INT(11) NOT NULL ,
  `AccessiServizio` INT(11) NULL DEFAULT NULL ,
  `NumeroPasti` INT(11) NULL DEFAULT NULL ,
  `NumeroTrasporti` INT(11) NULL DEFAULT NULL ,
  `GiorniAssenzaGiustificati` INT(11) NULL DEFAULT NULL ,
  `GiorniAssenzaNonGiustificati` INT(11) NULL DEFAULT NULL ,
  `OreErogate` INT(11) NULL DEFAULT NULL )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `eventsdb`.`inserimentovariazioneanagrafica`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `eventsdb`.`inserimentovariazioneanagrafica` (
  `ComuneNascitaDescr` VARCHAR(255) NOT NULL ,
  `StatoCivileCod` INT(11) NOT NULL ,
  `StatoCivileDescr` VARCHAR(255) NOT NULL ,
  `NazionalitaCod` INT(11) NOT NULL ,
  `NazionalitaDescr` VARCHAR(255) NOT NULL ,
  `ComuneDiResidenzaDescr` VARCHAR(255) NOT NULL ,
  `Sesso` VARCHAR(1) NOT NULL ,
  `Via` VARCHAR(255) NOT NULL ,
  `CAP` VARCHAR(5) NOT NULL ,
  `CittadinanzaCod` INT(11) NOT NULL ,
  `CittadinanzaDescr` VARCHAR(255) NOT NULL ,
  `AssSocialeCod` INT(11) NOT NULL ,
  `AssSocialeCognome` VARCHAR(100) NOT NULL ,
  `AssSocialeNome` VARCHAR(100) NOT NULL ,
  `EventoAssociato` INT(11) NOT NULL ,
  `EventoInviato` BIT(1) NOT NULL DEFAULT b'0' ,
  PRIMARY KEY (`EventoAssociato`) ,
  UNIQUE INDEX `EventoAssociato_UNIQUE` (`EventoAssociato` ASC) ,
  INDEX `FK_Evento` (`EventoAssociato` ASC) ,
  CONSTRAINT `FK_Evento`
    FOREIGN KEY (`EventoAssociato` )
    REFERENCES `eventsdb`.`events` (`idEvent` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `eventsdb`.`nucleofamiliare`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `eventsdb`.`nucleofamiliare` (
  `CodiceNucleo` INT(11) NOT NULL ,
  `IdPatient` INT(11) NOT NULL ,
  `GradoParentelaCod` INT(11) NOT NULL ,
  `GradoParentelaDescr` VARCHAR(50) NOT NULL ,
  INDEX `FK_Patient` (`IdPatient` ASC) ,
  CONSTRAINT `FK_Patient`
    FOREIGN KEY (`IdPatient` )
    REFERENCES `eventsdb`.`patient` (`IdAnagrafeLocale` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `eventsdb`.`ricezionedomandaamministrativa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `eventsdb`.`ricezionedomandaamministrativa` (
  `DataDomanda` DATETIME NOT NULL ,
  `GiornateSettimanali` INT(11) NOT NULL ,
  `NumeroPastiSettimanali` INT(11) NOT NULL ,
  `NumeroTrasportiSettimanali` INT(11) NOT NULL ,
  `OreSettimanali` INT(11) NOT NULL )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `eventsdb`.`schedaaccesso`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `eventsdb`.`schedaaccesso` (
  `DataAccesso` DATETIME NOT NULL ,
  `NumeroScheda` VARCHAR(38) NOT NULL ,
  `TipoServizioRichiestoCod` VARCHAR(9) NULL DEFAULT NULL ,
  `TipoServizioRichiestoDescr` VARCHAR(255) NULL DEFAULT NULL ,
  `TipoRichiedenteCod` VARCHAR(9) NOT NULL ,
  `TipoRichiedenteDescr` VARCHAR(255) NOT NULL ,
  `TipoTerziCod` INT(11) NULL DEFAULT NULL ,
  `TipoTerziDescr` VARCHAR(120) NULL DEFAULT NULL ,
  `NomeTerzi` VARCHAR(60) NULL DEFAULT NULL ,
  `TipoSegnalanteCod` INT(11) NULL DEFAULT NULL ,
  `TipoSetgnalanteDescr` VARCHAR(255) NULL DEFAULT NULL )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
