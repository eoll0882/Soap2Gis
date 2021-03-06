
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Информация о согласовании проведения проверки с органами прокуратуры (экспорт)
 * 
 * <p>Java class for ExportProsecutorAgreementInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportProsecutorAgreementInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="NoAgreementInformation" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;sequence>
 *           &lt;choice>
 *             &lt;element name="Agreed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *             &lt;element name="Rejected" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;/choice>
 *           &lt;sequence>
 *             &lt;element name="OrderNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String64Type"/>
 *             &lt;element name="OrderDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *             &lt;element name="DecisionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *             &lt;element name="DecisionPlace" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String64Type" minOccurs="0"/>
 *             &lt;element name="SignerPosition" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String256Type" minOccurs="0"/>
 *             &lt;element name="SignerName" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String256Type" minOccurs="0"/>
 *           &lt;/sequence>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportProsecutorAgreementInformationType", propOrder = {
    "noAgreementInformation",
    "agreed",
    "rejected",
    "orderNumber",
    "orderDate",
    "decisionDate",
    "decisionPlace",
    "signerPosition",
    "signerName"
})
public class ExportProsecutorAgreementInformationType {

    @XmlElement(name = "NoAgreementInformation")
    protected Boolean noAgreementInformation;
    @XmlElement(name = "Agreed")
    protected Boolean agreed;
    @XmlElement(name = "Rejected")
    protected Boolean rejected;
    @XmlElement(name = "OrderNumber")
    protected String orderNumber;
    @XmlElement(name = "OrderDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar orderDate;
    @XmlElement(name = "DecisionDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar decisionDate;
    @XmlElement(name = "DecisionPlace")
    protected String decisionPlace;
    @XmlElement(name = "SignerPosition")
    protected String signerPosition;
    @XmlElement(name = "SignerName")
    protected String signerName;

    /**
     * Gets the value of the noAgreementInformation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNoAgreementInformation() {
        return noAgreementInformation;
    }

    /**
     * Sets the value of the noAgreementInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNoAgreementInformation(Boolean value) {
        this.noAgreementInformation = value;
    }

    /**
     * Gets the value of the agreed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAgreed() {
        return agreed;
    }

    /**
     * Sets the value of the agreed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAgreed(Boolean value) {
        this.agreed = value;
    }

    /**
     * Gets the value of the rejected property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRejected() {
        return rejected;
    }

    /**
     * Sets the value of the rejected property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRejected(Boolean value) {
        this.rejected = value;
    }

    /**
     * Gets the value of the orderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets the value of the orderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderNumber(String value) {
        this.orderNumber = value;
    }

    /**
     * Gets the value of the orderDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the value of the orderDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrderDate(XMLGregorianCalendar value) {
        this.orderDate = value;
    }

    /**
     * Gets the value of the decisionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDecisionDate() {
        return decisionDate;
    }

    /**
     * Sets the value of the decisionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDecisionDate(XMLGregorianCalendar value) {
        this.decisionDate = value;
    }

    /**
     * Gets the value of the decisionPlace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDecisionPlace() {
        return decisionPlace;
    }

    /**
     * Sets the value of the decisionPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDecisionPlace(String value) {
        this.decisionPlace = value;
    }

    /**
     * Gets the value of the signerPosition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignerPosition() {
        return signerPosition;
    }

    /**
     * Sets the value of the signerPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignerPosition(String value) {
        this.signerPosition = value;
    }

    /**
     * Gets the value of the signerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignerName() {
        return signerName;
    }

    /**
     * Sets the value of the signerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignerName(String value) {
        this.signerName = value;
    }

}
