
package it.unitn.laboratory.events;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BodyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BodyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InserimentoVariazioneAnagrafica" type="{http://events.laboratory.unitn.it/}InserimentoVariazioneAnagraficaType" minOccurs="0"/>
 *         &lt;element name="InserimentoVariazioneNucleoFatto" type="{http://events.laboratory.unitn.it/}InserimentoVariazioneNucleoFattoType" minOccurs="0"/>
 *         &lt;element name="SchedaAccesso" type="{http://events.laboratory.unitn.it/}SchedaAccessoType" minOccurs="0"/>
 *         &lt;element name="PresaInCarico" type="{http://events.laboratory.unitn.it/}PresaInCaricoType" minOccurs="0"/>
 *         &lt;element name="ChiusuraPresaInCarico" type="{http://events.laboratory.unitn.it/}ChiusuraPresaInCaricoType" minOccurs="0"/>
 *         &lt;element name="AssegnazioneAreaUtenza" type="{http://events.laboratory.unitn.it/}AssegnazioneAreaUtenzaType" minOccurs="0"/>
 *         &lt;element name="RevocaAreaUtenza" type="{http://events.laboratory.unitn.it/}RevocaAreaUtenzaType" minOccurs="0"/>
 *         &lt;element name="RicezioneDomandaAmministrativa" type="{http://events.laboratory.unitn.it/}RicezioneDomandaAmministrativaType" minOccurs="0"/>
 *         &lt;element name="FatturazionePeriodica" type="{http://events.laboratory.unitn.it/}FatturazionePeriodicaType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BodyType", propOrder = {
    "inserimentoVariazioneAnagrafica",
    "inserimentoVariazioneNucleoFatto",
    "schedaAccesso",
    "presaInCarico",
    "chiusuraPresaInCarico",
    "assegnazioneAreaUtenza",
    "revocaAreaUtenza",
    "ricezioneDomandaAmministrativa",
    "fatturazionePeriodica"
})
public class BodyType {

    @XmlElement(name = "InserimentoVariazioneAnagrafica")
    protected InserimentoVariazioneAnagraficaType inserimentoVariazioneAnagrafica;
    @XmlElement(name = "InserimentoVariazioneNucleoFatto")
    protected InserimentoVariazioneNucleoFattoType inserimentoVariazioneNucleoFatto;
    @XmlElement(name = "SchedaAccesso")
    protected SchedaAccessoType schedaAccesso;
    @XmlElement(name = "PresaInCarico")
    protected PresaInCaricoType presaInCarico;
    @XmlElement(name = "ChiusuraPresaInCarico")
    protected ChiusuraPresaInCaricoType chiusuraPresaInCarico;
    @XmlElement(name = "AssegnazioneAreaUtenza")
    protected AssegnazioneAreaUtenzaType assegnazioneAreaUtenza;
    @XmlElement(name = "RevocaAreaUtenza")
    protected RevocaAreaUtenzaType revocaAreaUtenza;
    @XmlElement(name = "RicezioneDomandaAmministrativa")
    protected RicezioneDomandaAmministrativaType ricezioneDomandaAmministrativa;
    @XmlElement(name = "FatturazionePeriodica")
    protected FatturazionePeriodicaType fatturazionePeriodica;

    /**
     * Gets the value of the inserimentoVariazioneAnagrafica property.
     * 
     * @return
     *     possible object is
     *     {@link InserimentoVariazioneAnagraficaType }
     *     
     */
    public InserimentoVariazioneAnagraficaType getInserimentoVariazioneAnagrafica() {
        return inserimentoVariazioneAnagrafica;
    }

    /**
     * Sets the value of the inserimentoVariazioneAnagrafica property.
     * 
     * @param value
     *     allowed object is
     *     {@link InserimentoVariazioneAnagraficaType }
     *     
     */
    public void setInserimentoVariazioneAnagrafica(InserimentoVariazioneAnagraficaType value) {
        this.inserimentoVariazioneAnagrafica = value;
    }

    /**
     * Gets the value of the inserimentoVariazioneNucleoFatto property.
     * 
     * @return
     *     possible object is
     *     {@link InserimentoVariazioneNucleoFattoType }
     *     
     */
    public InserimentoVariazioneNucleoFattoType getInserimentoVariazioneNucleoFatto() {
        return inserimentoVariazioneNucleoFatto;
    }

    /**
     * Sets the value of the inserimentoVariazioneNucleoFatto property.
     * 
     * @param value
     *     allowed object is
     *     {@link InserimentoVariazioneNucleoFattoType }
     *     
     */
    public void setInserimentoVariazioneNucleoFatto(InserimentoVariazioneNucleoFattoType value) {
        this.inserimentoVariazioneNucleoFatto = value;
    }

    /**
     * Gets the value of the schedaAccesso property.
     * 
     * @return
     *     possible object is
     *     {@link SchedaAccessoType }
     *     
     */
    public SchedaAccessoType getSchedaAccesso() {
        return schedaAccesso;
    }

    /**
     * Sets the value of the schedaAccesso property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchedaAccessoType }
     *     
     */
    public void setSchedaAccesso(SchedaAccessoType value) {
        this.schedaAccesso = value;
    }

    /**
     * Gets the value of the presaInCarico property.
     * 
     * @return
     *     possible object is
     *     {@link PresaInCaricoType }
     *     
     */
    public PresaInCaricoType getPresaInCarico() {
        return presaInCarico;
    }

    /**
     * Sets the value of the presaInCarico property.
     * 
     * @param value
     *     allowed object is
     *     {@link PresaInCaricoType }
     *     
     */
    public void setPresaInCarico(PresaInCaricoType value) {
        this.presaInCarico = value;
    }

    /**
     * Gets the value of the chiusuraPresaInCarico property.
     * 
     * @return
     *     possible object is
     *     {@link ChiusuraPresaInCaricoType }
     *     
     */
    public ChiusuraPresaInCaricoType getChiusuraPresaInCarico() {
        return chiusuraPresaInCarico;
    }

    /**
     * Sets the value of the chiusuraPresaInCarico property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChiusuraPresaInCaricoType }
     *     
     */
    public void setChiusuraPresaInCarico(ChiusuraPresaInCaricoType value) {
        this.chiusuraPresaInCarico = value;
    }

    /**
     * Gets the value of the assegnazioneAreaUtenza property.
     * 
     * @return
     *     possible object is
     *     {@link AssegnazioneAreaUtenzaType }
     *     
     */
    public AssegnazioneAreaUtenzaType getAssegnazioneAreaUtenza() {
        return assegnazioneAreaUtenza;
    }

    /**
     * Sets the value of the assegnazioneAreaUtenza property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssegnazioneAreaUtenzaType }
     *     
     */
    public void setAssegnazioneAreaUtenza(AssegnazioneAreaUtenzaType value) {
        this.assegnazioneAreaUtenza = value;
    }

    /**
     * Gets the value of the revocaAreaUtenza property.
     * 
     * @return
     *     possible object is
     *     {@link RevocaAreaUtenzaType }
     *     
     */
    public RevocaAreaUtenzaType getRevocaAreaUtenza() {
        return revocaAreaUtenza;
    }

    /**
     * Sets the value of the revocaAreaUtenza property.
     * 
     * @param value
     *     allowed object is
     *     {@link RevocaAreaUtenzaType }
     *     
     */
    public void setRevocaAreaUtenza(RevocaAreaUtenzaType value) {
        this.revocaAreaUtenza = value;
    }

    /**
     * Gets the value of the ricezioneDomandaAmministrativa property.
     * 
     * @return
     *     possible object is
     *     {@link RicezioneDomandaAmministrativaType }
     *     
     */
    public RicezioneDomandaAmministrativaType getRicezioneDomandaAmministrativa() {
        return ricezioneDomandaAmministrativa;
    }

    /**
     * Sets the value of the ricezioneDomandaAmministrativa property.
     * 
     * @param value
     *     allowed object is
     *     {@link RicezioneDomandaAmministrativaType }
     *     
     */
    public void setRicezioneDomandaAmministrativa(RicezioneDomandaAmministrativaType value) {
        this.ricezioneDomandaAmministrativa = value;
    }

    /**
     * Gets the value of the fatturazionePeriodica property.
     * 
     * @return
     *     possible object is
     *     {@link FatturazionePeriodicaType }
     *     
     */
    public FatturazionePeriodicaType getFatturazionePeriodica() {
        return fatturazionePeriodica;
    }

    /**
     * Sets the value of the fatturazionePeriodica property.
     * 
     * @param value
     *     allowed object is
     *     {@link FatturazionePeriodicaType }
     *     
     */
    public void setFatturazionePeriodica(FatturazionePeriodicaType value) {
        this.fatturazionePeriodica = value;
    }

}
