<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:ns2="http://events.laboratory.unitn.it/">

<xsl:template match="/ns2:EventNotificationRequest">
<tns:SendMappedChanges xmlns:tns="http://wrapper.laboratory.unitn.it" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://wrapper.laboratory.unitn.it/MappedEvents.xsd ">
<DWH_SCHEMA >
  <EVENT_TYPE>
    <EVENT_COD><xsl:value-of select="Descrizione/TipoEventoCod"/></EVENT_COD>
    <EVENT_DESCR><xsl:value-of select="Descrizione/TipoEventoDescr"/></EVENT_DESCR>
  </EVENT_TYPE>
  
  <D_ASSISTITO>
    <ID_ANAGRAFE_LOCALE><xsl:value-of select="Assistito/IdAnagrafeLocale"/></ID_ANAGRAFE_LOCALE>
    <MITTENTE_NOME_ENTE><xsl:value-of select="Intestazione/Mittente/NomeEnte"/></MITTENTE_NOME_ENTE>
    <MITTENTE_URL_ENTE><xsl:value-of select="Intestazione/Mittente/UrlEnte"/></MITTENTE_URL_ENTE>
    <ANAG_URL_ENTE><xsl:value-of select="Intestazione/SorgenteAnagrafe/UrlEnte"/></ANAG_URL_ENTE>
    <ANAG_ID_ANAGRAFE><xsl:value-of select="Intestazione/SorgenteAnagrafe/IdAnagrafe"/></ANAG_ID_ANAGRAFE>
    <HASH_COD> <xsl:value-of select="Assistito/Nome"/>,<xsl:value-of select="Assistito/Cognome"/>,<xsl:value-of select="Assistito/CodiceFiscale"/></HASH_COD>
    <DATA_NASCITA><xsl:value-of select="Assistito/DataNascita"/></DATA_NASCITA>
    <COMUNE_NASCITA_COD><xsl:value-of select="Assistito/ComuneNascitaCod"/></COMUNE_NASCITA_COD>
    <COMUNE_RESIDENZA_COD><xsl:value-of select="Assistito/ComuneResidenzaCod"/></COMUNE_RESIDENZA_COD>
    <POLO_COD><xsl:value-of select="Descrizione/UnitaOrganizzativaCod"/></POLO_COD>
    <POLO_DESCR><xsl:value-of select="Descrizione/UnitaOrganizzativaDescr"/></POLO_DESCR>
    <GESTORE_COD><xsl:value-of select="Descrizione/ProduttoreCod"/></GESTORE_COD>
    <GESTORE_DESCR><xsl:value-of select="Descrizione/ProduttoreDescr"/></GESTORE_DESCR>
  </D_ASSISTITO>
  <D_ENTE_EROGATORE>
	<ENTE_EROGATORE_COD><xsl:value-of select="Evento/FatturazionePeriodica/CodiceCentro"/></ENTE_EROGATORE_COD>
	<ENTE_EROGATORE_DESCR><xsl:value-of select="Evento/FatturazionePeriodica/DenominazioneCentro"/></ENTE_EROGATORE_DESCR>
	<POLO_COD><xsl:value-of select="Descrizione/UnitaOrganizzativaCod"/></POLO_COD>
	<POLO_DESCR><xsl:value-of select="Descrizione/UnitaOrganizzativaDescr"/></POLO_DESCR>
	<ENTE_GESTORE_COD><xsl:value-of select="Descrizione/ProduttoreCod"/></ENTE_GESTORE_COD>
	<ENTE_GESTORE_DESCR><xsl:value-of select="Descrizione/ProduttoreDescr"/></ENTE_GESTORE_DESCR>
  </D_ENTE_EROGATORE> 

  <F_FATTURAZIONE>
	<DATA_INIZIO><xsl:value-of select="Evento/FatturazionePeriodica/DataInizio"/></DATA_INIZIO>
	<DATA_FINE><xsl:value-of select="Evento/FatturazionePeriodica/DataFine"/></DATA_FINE>
	<IMPORTO_FATTURA><xsl:value-of select="Evento/FatturazionePeriodica/ImportoFattura"/></IMPORTO_FATTURA>
	<GIORNATE><xsl:value-of select="Evento/FatturazionePeriodica/Giornate"/></GIORNATE>
	<ACCESSO_SERVIZIO><xsl:value-of select="Evento/FatturazionePeriodica/AccessiServizio"/></ACCESSO_SERVIZIO>
	<NUMERO_PASTI><xsl:value-of select="Evento/FatturazionePeriodica/NumeroPasti"/></NUMERO_PASTI>
	<NUMERO_TRASPORTI><xsl:value-of select="Evento/FatturazionePeriodica/NumeroTrasporti"/></NUMERO_TRASPORTI>
	<GIORNI_ASSENZA_GIUSTIFICATI><xsl:value-of select="Evento/FatturazionePeriodica/GiorniAssenzaGiustificati"/></GIORNI_ASSENZA_GIUSTIFICATI>
	<GIORNI_ASSENZA_NON_GIUSTIFICATI><xsl:value-of select="Evento/FatturazionePeriodica/GiorniAssenzaNonGiustificati"/></GIORNI_ASSENZA_NON_GIUSTIFICATI>
	<ORE_EROGATE><xsl:value-of select="Evento/FatturazionePeriodica/OreErogate"/></ORE_EROGATE>
	<DATA_FATTURA><xsl:value-of select="Evento/FatturazionePeriodica/DataFattura"/></DATA_FATTURA>
  </F_FATTURAZIONE>
  
  <D_OPERATORE>
    <OPERATORE_COD></OPERATORE_COD>
    <POLO_COD><xsl:value-of select="Descrizione/UnitaOrganizzativaCod"/></POLO_COD>
    <POLO_DESCR><xsl:value-of select="Descrizione/UnitaOrganizzativaDescr"/></POLO_DESCR>
    <ENTE_GESTORE_COD><xsl:value-of select="Descrizione/ProduttoreCod"/></ENTE_GESTORE_COD>
    <ENTE_GESTORE_DESCR><xsl:value-of select="Descrizione/ProduttoreDescr"/></ENTE_GESTORE_DESCR>
  </D_OPERATORE>
</DWH_SCHEMA>
</tns:SendMappedChanges>
</xsl:template>
</xsl:stylesheet>