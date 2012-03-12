<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:ns2="http://events.laboratory.unitn.it/">

<xsl:template match="/ns2:EventNotificationRequest">
<tns:SendMappedChanges xmlns:tns="http://events.laboratory.unitn.it" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://events.laboratory.unitn.it/MappedEvents.xsd ">
<DWH_SCHEMA >
  <EVENT_TYPE>
    <EVENT_COD><xsl:value-of select="Descrizione/TipoEventoCod"/></EVENT_COD>
    <EVENT_DESCR><xsl:value-of select="Descrizione/TipoEventoDescr"/></EVENT_DESCR>
  </EVENT_TYPE>
  <D_NUCLEO_FAMILIARE>
    <CODICE_NUCLEO><xsl:value-of select="Evento/InserimentoVariazioneNucleoFatto/CodiceNucleo"/></CODICE_NUCLEO>
    <xsl:for-each select="Evento/InserimentoVariazioneNucleoFatto/Componente"> 
    <COMPONENTE>
    	<HASH_COD><xsl:value-of select="Nome"/>,<xsl:value-of select="Cognome"/>,<xsl:value-of select="CodiceFiscale"/></HASH_COD>
    	<GRADO_PARENTELA_COD><xsl:value-of select="GradoParentelaCod"/></GRADO_PARENTELA_COD>
    	<GRADO_PARENTELA_DESCR><xsl:value-of select="GradoParentelaDescr"/></GRADO_PARENTELA_DESCR>
    	<DATA_NASCITA><xsl:value-of select="DataNascita"/></DATA_NASCITA>    
    </COMPONENTE>
    </xsl:for-each>   
  </D_NUCLEO_FAMILIARE>
</DWH_SCHEMA>
</tns:SendMappedChanges>
</xsl:template>
</xsl:stylesheet>