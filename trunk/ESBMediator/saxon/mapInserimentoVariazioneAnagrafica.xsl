<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:ns2="http://events.laboratory.unitn.it/">

<xsl:template match="/ns2:EventNotificationRequest">
<tns:DWH_SCHEMA xmlns:tns="http://events.laboratory.unitn.it/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://events.laboratory.unitn.it/MappedEvents.xsd ">
  <tns:D_ASSISTITO>
    <tns:ID_ANAGRAFE_LOCALE><xsl:value-of select="Assistito/IdAnagrafeLocale"/></tns:ID_ANAGRAFE_LOCALE>
    <tns:MITTENTE_NOME_ENTE><xsl:value-of select="Intestazione/Mittente/NomeEnte"/></tns:MITTENTE_NOME_ENTE>
    <tns:MITTENTE_URL_ENTE><xsl:value-of select="Intestazione/Mittente/UrlEnte"/></tns:MITTENTE_URL_ENTE>
    <tns:ANAG_URL_ENTE><xsl:value-of select="Intestazione/SorgenteAnagrafe/UrlEnte"/></tns:ANAG_URL_ENTE>
    <tns:ANAG_ID_ANAGRAFE><xsl:value-of select="Intestazione/SorgenteAnagrafe/IdAnagrafe"/></tns:ANAG_ID_ANAGRAFE>
    <tns:HASH_COD> <xsl:value-of select="Assistito/Nome"/>,<xsl:value-of select="Assistito/Cognome"/>,<xsl:value-of select="Assistito/CodiceFiscale"/></tns:HASH_COD>
    <tns:DATA_NASCITA><xsl:value-of select="Assistito/DataNascita"/></tns:DATA_NASCITA>
    <tns:COMUNE_NASCITA_COD><xsl:value-of select="Assistito/ComuneNascitaCod"/></tns:COMUNE_NASCITA_COD>
    <tns:COMUNE_RESIDENZA_COD><xsl:value-of select="Assistito/ComuneResidenzaCod"/></tns:COMUNE_RESIDENZA_COD>
    <tns:SESSO><xsl:value-of select="Evento/InserimentoVariazioneAnagrafica/Sesso"/></tns:SESSO>
    <tns:CAP><xsl:value-of select="Evento/InserimentoVariazioneAnagrafica/CAP"/></tns:CAP>
    <tns:STATO_CIVILE_COD><xsl:value-of select="Evento/InserimentoVariazioneAnagrafica/StatoCivileCod"/></tns:STATO_CIVILE_COD>
    <tns:STATO_CIVILE_DESCR><xsl:value-of select="Evento/InserimentoVariazioneAnagrafica/StatoCivileDescr"/></tns:STATO_CIVILE_DESCR>
    <tns:NAZIONALITA_COD><xsl:value-of select="Evento/InserimentoVariazioneAnagrafica/NazionalitaCod"/></tns:NAZIONALITA_COD>
    <tns:NAZIONALITA_DESCR><xsl:value-of select="Evento/InserimentoVariazioneAnagrafica/NazionalitaDescr"/></tns:NAZIONALITA_DESCR>
    <tns:CITTADINANZA_COD><xsl:value-of select="Evento/InserimentoVariazioneAnagrafica/CittadinanzaCod"/></tns:CITTADINANZA_COD>
    <tns:CITTADINANZA_DESCR><xsl:value-of select="Evento/InserimentoVariazioneAnagrafica/CittadinanzaDescr"/></tns:CITTADINANZA_DESCR>
    <tns:POLO_COD><xsl:value-of select="Descrizione/UnitaOrganizzativaCod"/></tns:POLO_COD>
    <tns:POLO_DESCR><xsl:value-of select="Descrizione/UnitaOrganizzativaDescr"/></tns:POLO_DESCR>
    <tns:GESTORE_COD><xsl:value-of select="Descrizione/ProduttoreCod"/></tns:GESTORE_COD>
    <tns:GESTORE_DESCR><xsl:value-of select="Descrizione/ProduttoreDescr"/></tns:GESTORE_DESCR>
  </tns:D_ASSISTITO>
  <tns:D_OPERATORE>
    <tns:POLO_COD><xsl:value-of select="Descrizione/UnitaOrganizzativaCod"/></tns:POLO_COD>
    <tns:POLO_DESCR><xsl:value-of select="Descrizione/UnitaOrganizzativaDescr"/></tns:POLO_DESCR>
    <tns:ENTE_GESTORE_COD><xsl:value-of select="Descrizione/ProduttoreCod"/></tns:ENTE_GESTORE_COD>
    <tns:ENTE_GESTORE_DESCR><xsl:value-of select="Descrizione/ProduttoreDescr"/></tns:ENTE_GESTORE_DESCR>
  </tns:D_OPERATORE>
</tns:DWH_SCHEMA>
</xsl:template>
</xsl:stylesheet>