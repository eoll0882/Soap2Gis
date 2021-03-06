
package ru.gosuslugi.dom.schema.integration.organizations_registry_common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.BaseType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType">
 *       &lt;sequence>
 *         &lt;element name="SearchCriteria" maxOccurs="100">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice>
 *                     &lt;choice>
 *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRNIP"/>
 *                       &lt;sequence>
 *                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRN"/>
 *                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}KPP" minOccurs="0"/>
 *                       &lt;/sequence>
 *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}NZA"/>
 *                     &lt;/choice>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}orgVersionGUID"/>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}orgRootEntityGUID"/>
 *                     &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;/choice>
 *                   &lt;element name="isRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="lastEditingDateFrom" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="10.0.2.1""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "searchCriteria",
    "lastEditingDateFrom"
})
@XmlRootElement(name = "exportOrgRegistryRequest")
public class ExportOrgRegistryRequest
    extends BaseType
{

    @XmlElement(name = "SearchCriteria", required = true)
    protected List<ExportOrgRegistryRequest.SearchCriteria> searchCriteria;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar lastEditingDateFrom;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the searchCriteria property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchCriteria property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchCriteria().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportOrgRegistryRequest.SearchCriteria }
     * 
     * 
     */
    public List<ExportOrgRegistryRequest.SearchCriteria> getSearchCriteria() {
        if (searchCriteria == null) {
            searchCriteria = new ArrayList<ExportOrgRegistryRequest.SearchCriteria>();
        }
        return this.searchCriteria;
    }

    /**
     * Gets the value of the lastEditingDateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastEditingDateFrom() {
        return lastEditingDateFrom;
    }

    /**
     * Sets the value of the lastEditingDateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastEditingDateFrom(XMLGregorianCalendar value) {
        this.lastEditingDateFrom = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "10.0.2.1";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;choice>
     *           &lt;choice>
     *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRNIP"/>
     *             &lt;sequence>
     *               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRN"/>
     *               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}KPP" minOccurs="0"/>
     *             &lt;/sequence>
     *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}NZA"/>
     *           &lt;/choice>
     *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}orgVersionGUID"/>
     *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}orgRootEntityGUID"/>
     *           &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;/choice>
     *         &lt;element name="isRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ogrnip",
        "ogrn",
        "kpp",
        "nza",
        "orgVersionGUID",
        "orgRootEntityGUID",
        "orgPPAGUID",
        "isRegistered"
    })
    public static class SearchCriteria {

        @XmlElement(name = "OGRNIP", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/")
        protected String ogrnip;
        @XmlElement(name = "OGRN", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/")
        protected String ogrn;
        @XmlElement(name = "KPP", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/")
        protected String kpp;
        @XmlElement(name = "NZA", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/")
        protected String nza;
        @XmlElement(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/")
        protected String orgVersionGUID;
        @XmlElement(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/")
        protected String orgRootEntityGUID;
        protected String orgPPAGUID;
        protected Boolean isRegistered;

        /**
         * Gets the value of the ogrnip property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOGRNIP() {
            return ogrnip;
        }

        /**
         * Sets the value of the ogrnip property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOGRNIP(String value) {
            this.ogrnip = value;
        }

        /**
         * Gets the value of the ogrn property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOGRN() {
            return ogrn;
        }

        /**
         * Sets the value of the ogrn property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOGRN(String value) {
            this.ogrn = value;
        }

        /**
         * Gets the value of the kpp property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKPP() {
            return kpp;
        }

        /**
         * Sets the value of the kpp property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKPP(String value) {
            this.kpp = value;
        }

        /**
         * Gets the value of the nza property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNZA() {
            return nza;
        }

        /**
         * Sets the value of the nza property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNZA(String value) {
            this.nza = value;
        }

        /**
         * Gets the value of the orgVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrgVersionGUID() {
            return orgVersionGUID;
        }

        /**
         * Sets the value of the orgVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrgVersionGUID(String value) {
            this.orgVersionGUID = value;
        }

        /**
         * Gets the value of the orgRootEntityGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrgRootEntityGUID() {
            return orgRootEntityGUID;
        }

        /**
         * Sets the value of the orgRootEntityGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrgRootEntityGUID(String value) {
            this.orgRootEntityGUID = value;
        }

        /**
         * Gets the value of the orgPPAGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrgPPAGUID() {
            return orgPPAGUID;
        }

        /**
         * Sets the value of the orgPPAGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrgPPAGUID(String value) {
            this.orgPPAGUID = value;
        }

        /**
         * Gets the value of the isRegistered property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isIsRegistered() {
            return isRegistered;
        }

        /**
         * Sets the value of the isRegistered property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsRegistered(Boolean value) {
            this.isRegistered = value;
        }

    }

}
