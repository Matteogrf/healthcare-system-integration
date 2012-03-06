<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:ns2="http://events.laboratory.unitn.it/">


<xsl:template match="/ns2:EventNotificationRequest">
    <DWH_SCHEMA>
        <D_ASSISTITO>
            <ID_ASSISTITO></ID_ASSISTITO>
            <ID_ANAGRAFE_LOCALE>
                <xsl:value-of select="Assistito/IdAnagrafeLocale"/>
            </ID_ANAGRAFE_LOCALE>
            <MITTENTE_NOME_ENTE>
              <xsl:value-of select="Intestazione/Mittente/NomeEnte"/>
            </MITTENTE_NOME_ENTE>
            <MITTENTE_URL_ENTE>
              <xsl:value-of select="Intestazione/Mittente/UrlEnte"/>
            </MITTENTE_URL_ENTE>
            <ANAG_URL_ENTE>
              <xsl:value-of select="Intestazione/SorgenteAnagrafe/UrlEnte"/>
            </ANAG_URL_ENTE>
            <ANAG_ID_ANAGRAFE>
              <xsl:value-of select="Intestazione/SorgenteAnagrafe/IdAnagrafe"/>
            </ANAG_ID_ANAGRAFE>
            <ID_ASS_SOC></ID_ASS_SOC>
            <HASH_COD>
              <xsl:value-of select="Assistito/Nome"/>,
              <xsl:value-of select="Assistito/Cognome"/>,
              <xsl:value-of select="Assistito/CodiceFiscale"/>
            </HASH_COD>
            <DATA_NASCITA>
              <xsl:value-of select="Assistito/DataNascita"/>
            </DATA_NASCITA>
            <COMUNE_NASCITA_COD>
              <xsl:value-of select="Assistito/ComuneNascitaCod"/>
            </COMUNE_NASCITA_COD>
            <COMUNE_NASCITA_DESCR></COMUNE_NASCITA_DESCR>
            <COMUNE_RESIDENZA></COMUNE_RESIDENZA>
            <COMUNE_RESIDENZA_COD>
              <xsl:value-of select="Assistito/ComuneResidenzaCod"/>
            </COMUNE_RESIDENZA_COD>
            <COMUNE_RESIDENZA_DESCR></COMUNE_RESIDENZA_DESCR>
            <SESSO>
              <xsl:value-of select="Evento/InserimentoVariazioneAnagrafica/Sesso"/>
            </SESSO>
            <CAP>
              <xsl:value-of select="Evento/InserimentoVariazioneAnagrafica/CAP"/>
            </CAP>
            <STATO_CIVILE_COD>
              <xsl:value-of select="Evento/InserimentoVariazioneAnagrafica/StatoCivileCod"/>
            </STATO_CIVILE_COD>
            <STATO_CIVILE_DESCR>
              <xsl:value-of select="Evento/InserimentoVariazioneAnagrafica/StatoCivileDescr"/>
            </STATO_CIVILE_DESCR>
            <NAZIONALITA_COD>
              <xsl:value-of select="Evento/InserimentoVariazioneAnagrafica/NazionalitaCod"/>
            </NAZIONALITA_COD>
            <NAZIONALITA_DESCR>
              <xsl:value-of select="Evento/InserimentoVariazioneAnagrafica/NazionalitaDescr"/>
            </NAZIONALITA_DESCR>
            <CITTADINANZA_COD>
              <xsl:value-of select="Evento/InserimentoVariazioneAnagrafica/CittadinanzaCod"/>
            </CITTADINANZA_COD>
            <CITTADINANZA_DESCR>
              <xsl:value-of select="Evento/InserimentoVariazioneAnagrafica/CittadinanzaDescr"/>
            </CITTADINANZA_DESCR>
            <POLO_COD>
              <xsl:value-of select="Descrizione/UnitaOrganizzativaCod"/>
            </POLO_COD>
            <POLO_DESCR>
              <xsl:value-of select="Descrizione/UnitaOrganizzativaDescr"/>
            </POLO_DESCR>
            <ENTE_GESTORE_COD>
              <xsl:value-of select="Descrizione/ProduttoreCod"/>
            </ENTE_GESTORE_COD>
            <ENTE_GESTORE_DESCR>
              <xsl:value-of select="Descrizione/ProduttoreDescr"/>
            </ENTE_GESTORE_DESCR>
        </D_ASSISTITO>
        <D_OPERATORE>
            <OPERATORE_COD></OPERATORE_COD>
            <NOME></NOME>
            <COGNOME></COGNOME>
            <POLO_COD>
              <xsl:value-of select="Descrizione/UnitaOrganizzativaCod"/>
            </POLO_COD>
            <POLO_DESCR>
              <xsl:value-of select="Descrizione/UnitaOrganizzativaDescr"/>
            </POLO_DESCR>
            <ENTE_GESTORE_COD>
              <xsl:value-of select="Descrizione/ProduttoreCod"/>
            </ENTE_GESTORE_COD>
            <ENTE_GESTORE_DESCR>
              <xsl:value-of select="Descrizione/ProduttoreDescr"/>
            </ENTE_GESTORE_DESCR>
        </D_OPERATORE>
    </DWH_SCHEMA>
</xsl:template>
</xsl:stylesheet>