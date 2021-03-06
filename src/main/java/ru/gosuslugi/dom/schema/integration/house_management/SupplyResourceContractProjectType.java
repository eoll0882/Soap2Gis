
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Договор ресурсоснабжения (проект)
 * 
 * <p>Java class for SupplyResourceContractProjectType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SupplyResourceContractProjectType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="IsContract">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="ContractNumber">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;minLength value="1"/>
 *                           &lt;maxLength value="100"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                     &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                     &lt;element name="ContractAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="IsNotContract">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="ContractNumber" minOccurs="0">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;minLength value="1"/>
 *                           &lt;maxLength value="100"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                     &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                     &lt;element name="ContractAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element name="IndefiniteTerm" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *           &lt;sequence>
 *             &lt;element name="AutomaticRollOverOneYear" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *             &lt;element name="ComptetionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element name="Period" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Start">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="StartDate">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                                   &lt;maxInclusive value="30"/>
 *                                   &lt;minInclusive value="1"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="NextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="End">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="EndDate">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                                   &lt;maxInclusive value="30"/>
 *                                   &lt;minInclusive value="-1"/>
 *                                   &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="NextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ContractBase" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="Offer" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;element name="ApartmentBuildingOwner">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;choice>
 *                     &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/>
 *                     &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/>
 *                     &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;/choice>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="LivingHouseOwner">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;choice>
 *                     &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/>
 *                     &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/>
 *                     &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;/choice>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="Organization">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType">
 *                 &lt;/extension>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="ApartmentBuildingSoleOwner">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;choice>
 *                     &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/>
 *                     &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/>
 *                   &lt;/choice>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="ApartmentBuildingRepresentativeOwner">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;choice>
 *                     &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/>
 *                     &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/>
 *                   &lt;/choice>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *         &lt;element name="IsPlannedVolume" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ContractSubject" maxOccurs="100">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractSubjectType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CountingResource" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="R"/>
 *               &lt;enumeration value="P"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SpecifyingQualityIndicators">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="D"/>
 *               &lt;enumeration value="O"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Quality" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element name="QualityIndicator" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                   &lt;element name="IndicatorValue">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType">
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OtherQualityIndicator" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element name="IndicatorName" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OtherQualityIndicatorNameType"/>
 *                   &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TemperatureChart" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="OutsideTemperature" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="FlowLineTemperature">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                         &lt;minExclusive value="0"/>
 *                         &lt;fractionDigits value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="OppositeLineTemperature">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                         &lt;minExclusive value="0"/>
 *                         &lt;fractionDigits value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;sequence>
 *           &lt;element name="BillingDate" minOccurs="0">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="Date">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                           &lt;minInclusive value="-1"/>
 *                           &lt;maxInclusive value="30"/>
 *                           &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="DateType">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;enumeration value="C"/>
 *                           &lt;enumeration value="N"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="PaymentDate" minOccurs="0">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="Date">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                           &lt;minInclusive value="-1"/>
 *                           &lt;maxInclusive value="30"/>
 *                           &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="DateType">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;enumeration value="C"/>
 *                           &lt;enumeration value="N"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="ProvidingInformationDate" minOccurs="0">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="Date">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                           &lt;minInclusive value="-1"/>
 *                           &lt;maxInclusive value="30"/>
 *                           &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="DateType">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;enumeration value="C"/>
 *                           &lt;enumeration value="N"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/sequence>
 *         &lt;element name="MeteringDeviceInformation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="VolumeDepends" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OneTimePayment" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyResourceContractProjectType", propOrder = {
    "isContract",
    "isNotContract",
    "indefiniteTerm",
    "automaticRollOverOneYear",
    "comptetionDate",
    "period",
    "contractBase",
    "offer",
    "apartmentBuildingOwner",
    "livingHouseOwner",
    "organization",
    "apartmentBuildingSoleOwner",
    "apartmentBuildingRepresentativeOwner",
    "isPlannedVolume",
    "contractSubject",
    "countingResource",
    "specifyingQualityIndicators",
    "quality",
    "otherQualityIndicator",
    "temperatureChart",
    "billingDate",
    "paymentDate",
    "providingInformationDate",
    "meteringDeviceInformation",
    "volumeDepends",
    "oneTimePayment"
})
public class SupplyResourceContractProjectType {

    @XmlElement(name = "IsContract")
    protected SupplyResourceContractProjectType.IsContract isContract;
    @XmlElement(name = "IsNotContract")
    protected SupplyResourceContractProjectType.IsNotContract isNotContract;
    @XmlElement(name = "IndefiniteTerm")
    protected Boolean indefiniteTerm;
    @XmlElement(name = "AutomaticRollOverOneYear")
    protected Boolean automaticRollOverOneYear;
    @XmlElement(name = "ComptetionDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar comptetionDate;
    @XmlElement(name = "Period")
    protected SupplyResourceContractProjectType.Period period;
    @XmlElement(name = "ContractBase")
    protected NsiRef contractBase;
    @XmlElement(name = "Offer")
    protected Boolean offer;
    @XmlElement(name = "ApartmentBuildingOwner")
    protected SupplyResourceContractProjectType.ApartmentBuildingOwner apartmentBuildingOwner;
    @XmlElement(name = "LivingHouseOwner")
    protected SupplyResourceContractProjectType.LivingHouseOwner livingHouseOwner;
    @XmlElement(name = "Organization")
    protected SupplyResourceContractProjectType.Organization organization;
    @XmlElement(name = "ApartmentBuildingSoleOwner")
    protected SupplyResourceContractProjectType.ApartmentBuildingSoleOwner apartmentBuildingSoleOwner;
    @XmlElement(name = "ApartmentBuildingRepresentativeOwner")
    protected SupplyResourceContractProjectType.ApartmentBuildingRepresentativeOwner apartmentBuildingRepresentativeOwner;
    @XmlElement(name = "IsPlannedVolume")
    protected boolean isPlannedVolume;
    @XmlElement(name = "ContractSubject", required = true)
    protected List<SupplyResourceContractProjectType.ContractSubject> contractSubject;
    @XmlElement(name = "CountingResource")
    protected String countingResource;
    @XmlElement(name = "SpecifyingQualityIndicators", required = true)
    protected String specifyingQualityIndicators;
    @XmlElement(name = "Quality")
    protected List<SupplyResourceContractProjectType.Quality> quality;
    @XmlElement(name = "OtherQualityIndicator")
    protected List<SupplyResourceContractProjectType.OtherQualityIndicator> otherQualityIndicator;
    @XmlElement(name = "TemperatureChart")
    protected List<SupplyResourceContractProjectType.TemperatureChart> temperatureChart;
    @XmlElement(name = "BillingDate")
    protected SupplyResourceContractProjectType.BillingDate billingDate;
    @XmlElement(name = "PaymentDate")
    protected SupplyResourceContractProjectType.PaymentDate paymentDate;
    @XmlElement(name = "ProvidingInformationDate")
    protected SupplyResourceContractProjectType.ProvidingInformationDate providingInformationDate;
    @XmlElement(name = "MeteringDeviceInformation")
    protected Boolean meteringDeviceInformation;
    @XmlElement(name = "VolumeDepends")
    protected Boolean volumeDepends;
    @XmlElement(name = "OneTimePayment")
    protected Boolean oneTimePayment;

    /**
     * Gets the value of the isContract property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractProjectType.IsContract }
     *     
     */
    public SupplyResourceContractProjectType.IsContract getIsContract() {
        return isContract;
    }

    /**
     * Sets the value of the isContract property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractProjectType.IsContract }
     *     
     */
    public void setIsContract(SupplyResourceContractProjectType.IsContract value) {
        this.isContract = value;
    }

    /**
     * Gets the value of the isNotContract property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractProjectType.IsNotContract }
     *     
     */
    public SupplyResourceContractProjectType.IsNotContract getIsNotContract() {
        return isNotContract;
    }

    /**
     * Sets the value of the isNotContract property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractProjectType.IsNotContract }
     *     
     */
    public void setIsNotContract(SupplyResourceContractProjectType.IsNotContract value) {
        this.isNotContract = value;
    }

    /**
     * Gets the value of the indefiniteTerm property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIndefiniteTerm() {
        return indefiniteTerm;
    }

    /**
     * Sets the value of the indefiniteTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIndefiniteTerm(Boolean value) {
        this.indefiniteTerm = value;
    }

    /**
     * Gets the value of the automaticRollOverOneYear property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutomaticRollOverOneYear() {
        return automaticRollOverOneYear;
    }

    /**
     * Sets the value of the automaticRollOverOneYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutomaticRollOverOneYear(Boolean value) {
        this.automaticRollOverOneYear = value;
    }

    /**
     * Gets the value of the comptetionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getComptetionDate() {
        return comptetionDate;
    }

    /**
     * Sets the value of the comptetionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setComptetionDate(XMLGregorianCalendar value) {
        this.comptetionDate = value;
    }

    /**
     * Gets the value of the period property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractProjectType.Period }
     *     
     */
    public SupplyResourceContractProjectType.Period getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractProjectType.Period }
     *     
     */
    public void setPeriod(SupplyResourceContractProjectType.Period value) {
        this.period = value;
    }

    /**
     * Gets the value of the contractBase property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getContractBase() {
        return contractBase;
    }

    /**
     * Sets the value of the contractBase property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setContractBase(NsiRef value) {
        this.contractBase = value;
    }

    /**
     * Gets the value of the offer property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOffer() {
        return offer;
    }

    /**
     * Sets the value of the offer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOffer(Boolean value) {
        this.offer = value;
    }

    /**
     * Gets the value of the apartmentBuildingOwner property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractProjectType.ApartmentBuildingOwner }
     *     
     */
    public SupplyResourceContractProjectType.ApartmentBuildingOwner getApartmentBuildingOwner() {
        return apartmentBuildingOwner;
    }

    /**
     * Sets the value of the apartmentBuildingOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractProjectType.ApartmentBuildingOwner }
     *     
     */
    public void setApartmentBuildingOwner(SupplyResourceContractProjectType.ApartmentBuildingOwner value) {
        this.apartmentBuildingOwner = value;
    }

    /**
     * Gets the value of the livingHouseOwner property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractProjectType.LivingHouseOwner }
     *     
     */
    public SupplyResourceContractProjectType.LivingHouseOwner getLivingHouseOwner() {
        return livingHouseOwner;
    }

    /**
     * Sets the value of the livingHouseOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractProjectType.LivingHouseOwner }
     *     
     */
    public void setLivingHouseOwner(SupplyResourceContractProjectType.LivingHouseOwner value) {
        this.livingHouseOwner = value;
    }

    /**
     * Gets the value of the organization property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractProjectType.Organization }
     *     
     */
    public SupplyResourceContractProjectType.Organization getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractProjectType.Organization }
     *     
     */
    public void setOrganization(SupplyResourceContractProjectType.Organization value) {
        this.organization = value;
    }

    /**
     * Gets the value of the apartmentBuildingSoleOwner property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractProjectType.ApartmentBuildingSoleOwner }
     *     
     */
    public SupplyResourceContractProjectType.ApartmentBuildingSoleOwner getApartmentBuildingSoleOwner() {
        return apartmentBuildingSoleOwner;
    }

    /**
     * Sets the value of the apartmentBuildingSoleOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractProjectType.ApartmentBuildingSoleOwner }
     *     
     */
    public void setApartmentBuildingSoleOwner(SupplyResourceContractProjectType.ApartmentBuildingSoleOwner value) {
        this.apartmentBuildingSoleOwner = value;
    }

    /**
     * Gets the value of the apartmentBuildingRepresentativeOwner property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractProjectType.ApartmentBuildingRepresentativeOwner }
     *     
     */
    public SupplyResourceContractProjectType.ApartmentBuildingRepresentativeOwner getApartmentBuildingRepresentativeOwner() {
        return apartmentBuildingRepresentativeOwner;
    }

    /**
     * Sets the value of the apartmentBuildingRepresentativeOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractProjectType.ApartmentBuildingRepresentativeOwner }
     *     
     */
    public void setApartmentBuildingRepresentativeOwner(SupplyResourceContractProjectType.ApartmentBuildingRepresentativeOwner value) {
        this.apartmentBuildingRepresentativeOwner = value;
    }

    /**
     * Gets the value of the isPlannedVolume property.
     * 
     */
    public boolean isIsPlannedVolume() {
        return isPlannedVolume;
    }

    /**
     * Sets the value of the isPlannedVolume property.
     * 
     */
    public void setIsPlannedVolume(boolean value) {
        this.isPlannedVolume = value;
    }

    /**
     * Gets the value of the contractSubject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contractSubject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContractSubject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplyResourceContractProjectType.ContractSubject }
     * 
     * 
     */
    public List<SupplyResourceContractProjectType.ContractSubject> getContractSubject() {
        if (contractSubject == null) {
            contractSubject = new ArrayList<SupplyResourceContractProjectType.ContractSubject>();
        }
        return this.contractSubject;
    }

    /**
     * Gets the value of the countingResource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountingResource() {
        return countingResource;
    }

    /**
     * Sets the value of the countingResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountingResource(String value) {
        this.countingResource = value;
    }

    /**
     * Gets the value of the specifyingQualityIndicators property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecifyingQualityIndicators() {
        return specifyingQualityIndicators;
    }

    /**
     * Sets the value of the specifyingQualityIndicators property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecifyingQualityIndicators(String value) {
        this.specifyingQualityIndicators = value;
    }

    /**
     * Gets the value of the quality property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the quality property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuality().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplyResourceContractProjectType.Quality }
     * 
     * 
     */
    public List<SupplyResourceContractProjectType.Quality> getQuality() {
        if (quality == null) {
            quality = new ArrayList<SupplyResourceContractProjectType.Quality>();
        }
        return this.quality;
    }

    /**
     * Gets the value of the otherQualityIndicator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherQualityIndicator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherQualityIndicator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplyResourceContractProjectType.OtherQualityIndicator }
     * 
     * 
     */
    public List<SupplyResourceContractProjectType.OtherQualityIndicator> getOtherQualityIndicator() {
        if (otherQualityIndicator == null) {
            otherQualityIndicator = new ArrayList<SupplyResourceContractProjectType.OtherQualityIndicator>();
        }
        return this.otherQualityIndicator;
    }

    /**
     * Gets the value of the temperatureChart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the temperatureChart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemperatureChart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplyResourceContractProjectType.TemperatureChart }
     * 
     * 
     */
    public List<SupplyResourceContractProjectType.TemperatureChart> getTemperatureChart() {
        if (temperatureChart == null) {
            temperatureChart = new ArrayList<SupplyResourceContractProjectType.TemperatureChart>();
        }
        return this.temperatureChart;
    }

    /**
     * Gets the value of the billingDate property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractProjectType.BillingDate }
     *     
     */
    public SupplyResourceContractProjectType.BillingDate getBillingDate() {
        return billingDate;
    }

    /**
     * Sets the value of the billingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractProjectType.BillingDate }
     *     
     */
    public void setBillingDate(SupplyResourceContractProjectType.BillingDate value) {
        this.billingDate = value;
    }

    /**
     * Gets the value of the paymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractProjectType.PaymentDate }
     *     
     */
    public SupplyResourceContractProjectType.PaymentDate getPaymentDate() {
        return paymentDate;
    }

    /**
     * Sets the value of the paymentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractProjectType.PaymentDate }
     *     
     */
    public void setPaymentDate(SupplyResourceContractProjectType.PaymentDate value) {
        this.paymentDate = value;
    }

    /**
     * Gets the value of the providingInformationDate property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractProjectType.ProvidingInformationDate }
     *     
     */
    public SupplyResourceContractProjectType.ProvidingInformationDate getProvidingInformationDate() {
        return providingInformationDate;
    }

    /**
     * Sets the value of the providingInformationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractProjectType.ProvidingInformationDate }
     *     
     */
    public void setProvidingInformationDate(SupplyResourceContractProjectType.ProvidingInformationDate value) {
        this.providingInformationDate = value;
    }

    /**
     * Gets the value of the meteringDeviceInformation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMeteringDeviceInformation() {
        return meteringDeviceInformation;
    }

    /**
     * Sets the value of the meteringDeviceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMeteringDeviceInformation(Boolean value) {
        this.meteringDeviceInformation = value;
    }

    /**
     * Gets the value of the volumeDepends property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVolumeDepends() {
        return volumeDepends;
    }

    /**
     * Sets the value of the volumeDepends property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVolumeDepends(Boolean value) {
        this.volumeDepends = value;
    }

    /**
     * Gets the value of the oneTimePayment property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOneTimePayment() {
        return oneTimePayment;
    }

    /**
     * Sets the value of the oneTimePayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOneTimePayment(Boolean value) {
        this.oneTimePayment = value;
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
     *       &lt;choice>
     *         &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/>
     *         &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/>
     *         &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "regOrg",
        "ind",
        "noData"
    })
    public static class ApartmentBuildingOwner {

        @XmlElement(name = "RegOrg")
        protected DRSORegOrgType regOrg;
        @XmlElement(name = "Ind")
        protected DRSOIndType ind;
        @XmlElement(name = "NoData")
        protected Boolean noData;

        /**
         * Gets the value of the regOrg property.
         * 
         * @return
         *     possible object is
         *     {@link DRSORegOrgType }
         *     
         */
        public DRSORegOrgType getRegOrg() {
            return regOrg;
        }

        /**
         * Sets the value of the regOrg property.
         * 
         * @param value
         *     allowed object is
         *     {@link DRSORegOrgType }
         *     
         */
        public void setRegOrg(DRSORegOrgType value) {
            this.regOrg = value;
        }

        /**
         * Gets the value of the ind property.
         * 
         * @return
         *     possible object is
         *     {@link DRSOIndType }
         *     
         */
        public DRSOIndType getInd() {
            return ind;
        }

        /**
         * Sets the value of the ind property.
         * 
         * @param value
         *     allowed object is
         *     {@link DRSOIndType }
         *     
         */
        public void setInd(DRSOIndType value) {
            this.ind = value;
        }

        /**
         * Gets the value of the noData property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNoData() {
            return noData;
        }

        /**
         * Sets the value of the noData property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNoData(Boolean value) {
            this.noData = value;
        }

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
     *       &lt;choice>
     *         &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/>
     *         &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "noData",
        "regOrg",
        "ind"
    })
    public static class ApartmentBuildingRepresentativeOwner {

        @XmlElement(name = "NoData")
        protected Boolean noData;
        @XmlElement(name = "RegOrg")
        protected DRSORegOrgType regOrg;
        @XmlElement(name = "Ind")
        protected DRSOIndType ind;

        /**
         * Gets the value of the noData property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNoData() {
            return noData;
        }

        /**
         * Sets the value of the noData property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNoData(Boolean value) {
            this.noData = value;
        }

        /**
         * Gets the value of the regOrg property.
         * 
         * @return
         *     possible object is
         *     {@link DRSORegOrgType }
         *     
         */
        public DRSORegOrgType getRegOrg() {
            return regOrg;
        }

        /**
         * Sets the value of the regOrg property.
         * 
         * @param value
         *     allowed object is
         *     {@link DRSORegOrgType }
         *     
         */
        public void setRegOrg(DRSORegOrgType value) {
            this.regOrg = value;
        }

        /**
         * Gets the value of the ind property.
         * 
         * @return
         *     possible object is
         *     {@link DRSOIndType }
         *     
         */
        public DRSOIndType getInd() {
            return ind;
        }

        /**
         * Sets the value of the ind property.
         * 
         * @param value
         *     allowed object is
         *     {@link DRSOIndType }
         *     
         */
        public void setInd(DRSOIndType value) {
            this.ind = value;
        }

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
     *       &lt;choice>
     *         &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/>
     *         &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "noData",
        "regOrg",
        "ind"
    })
    public static class ApartmentBuildingSoleOwner {

        @XmlElement(name = "NoData")
        protected Boolean noData;
        @XmlElement(name = "RegOrg")
        protected DRSORegOrgType regOrg;
        @XmlElement(name = "Ind")
        protected DRSOIndType ind;

        /**
         * Gets the value of the noData property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNoData() {
            return noData;
        }

        /**
         * Sets the value of the noData property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNoData(Boolean value) {
            this.noData = value;
        }

        /**
         * Gets the value of the regOrg property.
         * 
         * @return
         *     possible object is
         *     {@link DRSORegOrgType }
         *     
         */
        public DRSORegOrgType getRegOrg() {
            return regOrg;
        }

        /**
         * Sets the value of the regOrg property.
         * 
         * @param value
         *     allowed object is
         *     {@link DRSORegOrgType }
         *     
         */
        public void setRegOrg(DRSORegOrgType value) {
            this.regOrg = value;
        }

        /**
         * Gets the value of the ind property.
         * 
         * @return
         *     possible object is
         *     {@link DRSOIndType }
         *     
         */
        public DRSOIndType getInd() {
            return ind;
        }

        /**
         * Sets the value of the ind property.
         * 
         * @param value
         *     allowed object is
         *     {@link DRSOIndType }
         *     
         */
        public void setInd(DRSOIndType value) {
            this.ind = value;
        }

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
     *         &lt;element name="Date">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
     *               &lt;minInclusive value="-1"/>
     *               &lt;maxInclusive value="30"/>
     *               &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DateType">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="C"/>
     *               &lt;enumeration value="N"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
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
        "date",
        "dateType"
    })
    public static class BillingDate {

        @XmlElement(name = "Date")
        protected byte date;
        @XmlElement(name = "DateType", required = true)
        protected String dateType;

        /**
         * Gets the value of the date property.
         * 
         */
        public byte getDate() {
            return date;
        }

        /**
         * Sets the value of the date property.
         * 
         */
        public void setDate(byte value) {
            this.date = value;
        }

        /**
         * Gets the value of the dateType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDateType() {
            return dateType;
        }

        /**
         * Sets the value of the dateType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDateType(String value) {
            this.dateType = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractSubjectType">
     *       &lt;sequence>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "transportGUID"
    })
    public static class ContractSubject
        extends ContractSubjectType
    {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;

        /**
         * Gets the value of the transportGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransportGUID() {
            return transportGUID;
        }

        /**
         * Sets the value of the transportGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransportGUID(String value) {
            this.transportGUID = value;
        }

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
     *         &lt;element name="ContractNumber">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="ContractAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100"/>
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
        "contractNumber",
        "signingDate",
        "effectiveDate",
        "contractAttachment"
    })
    public static class IsContract {

        @XmlElement(name = "ContractNumber", required = true)
        protected String contractNumber;
        @XmlElement(name = "SigningDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar signingDate;
        @XmlElement(name = "EffectiveDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar effectiveDate;
        @XmlElement(name = "ContractAttachment", required = true)
        protected List<AttachmentType> contractAttachment;

        /**
         * Gets the value of the contractNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContractNumber() {
            return contractNumber;
        }

        /**
         * Sets the value of the contractNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContractNumber(String value) {
            this.contractNumber = value;
        }

        /**
         * Gets the value of the signingDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getSigningDate() {
            return signingDate;
        }

        /**
         * Sets the value of the signingDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setSigningDate(XMLGregorianCalendar value) {
            this.signingDate = value;
        }

        /**
         * Gets the value of the effectiveDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEffectiveDate() {
            return effectiveDate;
        }

        /**
         * Sets the value of the effectiveDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEffectiveDate(XMLGregorianCalendar value) {
            this.effectiveDate = value;
        }

        /**
         * Gets the value of the contractAttachment property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contractAttachment property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContractAttachment().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AttachmentType }
         * 
         * 
         */
        public List<AttachmentType> getContractAttachment() {
            if (contractAttachment == null) {
                contractAttachment = new ArrayList<AttachmentType>();
            }
            return this.contractAttachment;
        }

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
     *         &lt;element name="ContractNumber" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="ContractAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/>
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
        "contractNumber",
        "signingDate",
        "effectiveDate",
        "contractAttachment"
    })
    public static class IsNotContract {

        @XmlElement(name = "ContractNumber")
        protected String contractNumber;
        @XmlElement(name = "SigningDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar signingDate;
        @XmlElement(name = "EffectiveDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar effectiveDate;
        @XmlElement(name = "ContractAttachment")
        protected List<AttachmentType> contractAttachment;

        /**
         * Gets the value of the contractNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContractNumber() {
            return contractNumber;
        }

        /**
         * Sets the value of the contractNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContractNumber(String value) {
            this.contractNumber = value;
        }

        /**
         * Gets the value of the signingDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getSigningDate() {
            return signingDate;
        }

        /**
         * Sets the value of the signingDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setSigningDate(XMLGregorianCalendar value) {
            this.signingDate = value;
        }

        /**
         * Gets the value of the effectiveDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEffectiveDate() {
            return effectiveDate;
        }

        /**
         * Sets the value of the effectiveDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEffectiveDate(XMLGregorianCalendar value) {
            this.effectiveDate = value;
        }

        /**
         * Gets the value of the contractAttachment property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contractAttachment property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContractAttachment().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AttachmentType }
         * 
         * 
         */
        public List<AttachmentType> getContractAttachment() {
            if (contractAttachment == null) {
                contractAttachment = new ArrayList<AttachmentType>();
            }
            return this.contractAttachment;
        }

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
     *       &lt;choice>
     *         &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/>
     *         &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/>
     *         &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "regOrg",
        "ind",
        "noData"
    })
    public static class LivingHouseOwner {

        @XmlElement(name = "RegOrg")
        protected DRSORegOrgType regOrg;
        @XmlElement(name = "Ind")
        protected DRSOIndType ind;
        @XmlElement(name = "NoData")
        protected Boolean noData;

        /**
         * Gets the value of the regOrg property.
         * 
         * @return
         *     possible object is
         *     {@link DRSORegOrgType }
         *     
         */
        public DRSORegOrgType getRegOrg() {
            return regOrg;
        }

        /**
         * Sets the value of the regOrg property.
         * 
         * @param value
         *     allowed object is
         *     {@link DRSORegOrgType }
         *     
         */
        public void setRegOrg(DRSORegOrgType value) {
            this.regOrg = value;
        }

        /**
         * Gets the value of the ind property.
         * 
         * @return
         *     possible object is
         *     {@link DRSOIndType }
         *     
         */
        public DRSOIndType getInd() {
            return ind;
        }

        /**
         * Sets the value of the ind property.
         * 
         * @param value
         *     allowed object is
         *     {@link DRSOIndType }
         *     
         */
        public void setInd(DRSOIndType value) {
            this.ind = value;
        }

        /**
         * Gets the value of the noData property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNoData() {
            return noData;
        }

        /**
         * Sets the value of the noData property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNoData(Boolean value) {
            this.noData = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Organization
        extends RegOrgType
    {


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
     *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element name="IndicatorName" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OtherQualityIndicatorNameType"/>
     *         &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI"/>
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
        "pairKey",
        "indicatorName",
        "number",
        "okei"
    })
    public static class OtherQualityIndicator {

        @XmlElement(name = "PairKey", required = true)
        protected String pairKey;
        @XmlElement(name = "IndicatorName", required = true)
        protected String indicatorName;
        @XmlElement(name = "Number", required = true)
        protected BigDecimal number;
        @XmlElement(name = "OKEI", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String okei;

        /**
         * Gets the value of the pairKey property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPairKey() {
            return pairKey;
        }

        /**
         * Sets the value of the pairKey property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPairKey(String value) {
            this.pairKey = value;
        }

        /**
         * Gets the value of the indicatorName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIndicatorName() {
            return indicatorName;
        }

        /**
         * Sets the value of the indicatorName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIndicatorName(String value) {
            this.indicatorName = value;
        }

        /**
         * Gets the value of the number property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getNumber() {
            return number;
        }

        /**
         * Sets the value of the number property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setNumber(BigDecimal value) {
            this.number = value;
        }

        /**
         * Gets the value of the okei property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOKEI() {
            return okei;
        }

        /**
         * Sets the value of the okei property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOKEI(String value) {
            this.okei = value;
        }

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
     *         &lt;element name="Date">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
     *               &lt;minInclusive value="-1"/>
     *               &lt;maxInclusive value="30"/>
     *               &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DateType">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="C"/>
     *               &lt;enumeration value="N"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
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
        "date",
        "dateType"
    })
    public static class PaymentDate {

        @XmlElement(name = "Date")
        protected byte date;
        @XmlElement(name = "DateType", required = true)
        protected String dateType;

        /**
         * Gets the value of the date property.
         * 
         */
        public byte getDate() {
            return date;
        }

        /**
         * Sets the value of the date property.
         * 
         */
        public void setDate(byte value) {
            this.date = value;
        }

        /**
         * Gets the value of the dateType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDateType() {
            return dateType;
        }

        /**
         * Sets the value of the dateType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDateType(String value) {
            this.dateType = value;
        }

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
     *         &lt;element name="Start">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="StartDate">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
     *                         &lt;maxInclusive value="30"/>
     *                         &lt;minInclusive value="1"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="NextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="End">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="EndDate">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
     *                         &lt;maxInclusive value="30"/>
     *                         &lt;minInclusive value="-1"/>
     *                         &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="NextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "start",
        "end"
    })
    public static class Period {

        @XmlElement(name = "Start", required = true)
        protected SupplyResourceContractProjectType.Period.Start start;
        @XmlElement(name = "End", required = true)
        protected SupplyResourceContractProjectType.Period.End end;

        /**
         * Gets the value of the start property.
         * 
         * @return
         *     possible object is
         *     {@link SupplyResourceContractProjectType.Period.Start }
         *     
         */
        public SupplyResourceContractProjectType.Period.Start getStart() {
            return start;
        }

        /**
         * Sets the value of the start property.
         * 
         * @param value
         *     allowed object is
         *     {@link SupplyResourceContractProjectType.Period.Start }
         *     
         */
        public void setStart(SupplyResourceContractProjectType.Period.Start value) {
            this.start = value;
        }

        /**
         * Gets the value of the end property.
         * 
         * @return
         *     possible object is
         *     {@link SupplyResourceContractProjectType.Period.End }
         *     
         */
        public SupplyResourceContractProjectType.Period.End getEnd() {
            return end;
        }

        /**
         * Sets the value of the end property.
         * 
         * @param value
         *     allowed object is
         *     {@link SupplyResourceContractProjectType.Period.End }
         *     
         */
        public void setEnd(SupplyResourceContractProjectType.Period.End value) {
            this.end = value;
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
         *         &lt;element name="EndDate">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
         *               &lt;maxInclusive value="30"/>
         *               &lt;minInclusive value="-1"/>
         *               &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="NextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
            "endDate",
            "nextMonth"
        })
        public static class End {

            @XmlElement(name = "EndDate")
            protected byte endDate;
            @XmlElement(name = "NextMonth")
            protected Boolean nextMonth;

            /**
             * Gets the value of the endDate property.
             * 
             */
            public byte getEndDate() {
                return endDate;
            }

            /**
             * Sets the value of the endDate property.
             * 
             */
            public void setEndDate(byte value) {
                this.endDate = value;
            }

            /**
             * Gets the value of the nextMonth property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isNextMonth() {
                return nextMonth;
            }

            /**
             * Sets the value of the nextMonth property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setNextMonth(Boolean value) {
                this.nextMonth = value;
            }

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
         *         &lt;element name="StartDate">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
         *               &lt;maxInclusive value="30"/>
         *               &lt;minInclusive value="1"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="NextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
            "startDate",
            "nextMonth"
        })
        public static class Start {

            @XmlElement(name = "StartDate")
            protected byte startDate;
            @XmlElement(name = "NextMonth")
            protected Boolean nextMonth;

            /**
             * Gets the value of the startDate property.
             * 
             */
            public byte getStartDate() {
                return startDate;
            }

            /**
             * Sets the value of the startDate property.
             * 
             */
            public void setStartDate(byte value) {
                this.startDate = value;
            }

            /**
             * Gets the value of the nextMonth property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isNextMonth() {
                return nextMonth;
            }

            /**
             * Sets the value of the nextMonth property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setNextMonth(Boolean value) {
                this.nextMonth = value;
            }

        }

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
     *         &lt;element name="Date">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
     *               &lt;minInclusive value="-1"/>
     *               &lt;maxInclusive value="30"/>
     *               &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DateType">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="C"/>
     *               &lt;enumeration value="N"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
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
        "date",
        "dateType"
    })
    public static class ProvidingInformationDate {

        @XmlElement(name = "Date")
        protected byte date;
        @XmlElement(name = "DateType", required = true)
        protected String dateType;

        /**
         * Gets the value of the date property.
         * 
         */
        public byte getDate() {
            return date;
        }

        /**
         * Sets the value of the date property.
         * 
         */
        public void setDate(byte value) {
            this.date = value;
        }

        /**
         * Gets the value of the dateType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDateType() {
            return dateType;
        }

        /**
         * Sets the value of the dateType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDateType(String value) {
            this.dateType = value;
        }

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
     *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element name="QualityIndicator" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *         &lt;element name="IndicatorValue">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType">
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "pairKey",
        "qualityIndicator",
        "indicatorValue"
    })
    public static class Quality {

        @XmlElement(name = "PairKey", required = true)
        protected String pairKey;
        @XmlElement(name = "QualityIndicator", required = true)
        protected NsiRef qualityIndicator;
        @XmlElement(name = "IndicatorValue", required = true)
        protected SupplyResourceContractProjectType.Quality.IndicatorValue indicatorValue;

        /**
         * Gets the value of the pairKey property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPairKey() {
            return pairKey;
        }

        /**
         * Sets the value of the pairKey property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPairKey(String value) {
            this.pairKey = value;
        }

        /**
         * Gets the value of the qualityIndicator property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getQualityIndicator() {
            return qualityIndicator;
        }

        /**
         * Sets the value of the qualityIndicator property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setQualityIndicator(NsiRef value) {
            this.qualityIndicator = value;
        }

        /**
         * Gets the value of the indicatorValue property.
         * 
         * @return
         *     possible object is
         *     {@link SupplyResourceContractProjectType.Quality.IndicatorValue }
         *     
         */
        public SupplyResourceContractProjectType.Quality.IndicatorValue getIndicatorValue() {
            return indicatorValue;
        }

        /**
         * Sets the value of the indicatorValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link SupplyResourceContractProjectType.Quality.IndicatorValue }
         *     
         */
        public void setIndicatorValue(SupplyResourceContractProjectType.Quality.IndicatorValue value) {
            this.indicatorValue = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType">
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class IndicatorValue
            extends IndicatorValueType
        {


        }

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
     *         &lt;element name="OutsideTemperature" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="FlowLineTemperature">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;minExclusive value="0"/>
     *               &lt;fractionDigits value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="OppositeLineTemperature">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;minExclusive value="0"/>
     *               &lt;fractionDigits value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
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
        "outsideTemperature",
        "flowLineTemperature",
        "oppositeLineTemperature"
    })
    public static class TemperatureChart {

        @XmlElement(name = "OutsideTemperature")
        protected int outsideTemperature;
        @XmlElement(name = "FlowLineTemperature", required = true)
        protected BigDecimal flowLineTemperature;
        @XmlElement(name = "OppositeLineTemperature", required = true)
        protected BigDecimal oppositeLineTemperature;

        /**
         * Gets the value of the outsideTemperature property.
         * 
         */
        public int getOutsideTemperature() {
            return outsideTemperature;
        }

        /**
         * Sets the value of the outsideTemperature property.
         * 
         */
        public void setOutsideTemperature(int value) {
            this.outsideTemperature = value;
        }

        /**
         * Gets the value of the flowLineTemperature property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFlowLineTemperature() {
            return flowLineTemperature;
        }

        /**
         * Sets the value of the flowLineTemperature property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFlowLineTemperature(BigDecimal value) {
            this.flowLineTemperature = value;
        }

        /**
         * Gets the value of the oppositeLineTemperature property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getOppositeLineTemperature() {
            return oppositeLineTemperature;
        }

        /**
         * Sets the value of the oppositeLineTemperature property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setOppositeLineTemperature(BigDecimal value) {
            this.oppositeLineTemperature = value;
        }

    }

}
