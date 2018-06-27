
package ru.gosuslugi.dom.schema.integration.capital_repair_service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import ru.gosuslugi.dom.schema.integration.capital_repair.CapRemImportResultType;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportAccountRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportAccountResult;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportContractsRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportContractsResult;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportCreditContractRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportCreditContractResult;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportDecisionsFormingFundRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportDecisionsFormingFundResult;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportDecisionsOrderOfProvidingPDRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportDecisionsOrderOfProvidingPDResult;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportFundSizeInfoRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportFundSizeInfoResult;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportPlanRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportPlanResult;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportPlanWorkRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportPlanWorkResult;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportRegionalProgramRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportRegionalProgramResult;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportRegionalProgramWorkRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ExportRegionalProgramWorkResult;
import ru.gosuslugi.dom.schema.integration.capital_repair.ImportAccountRegionalOperatorRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ImportAccountSpecialRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ImportCertificatesRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ImportContractsRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ImportDecisionsFormingFundRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ImportDecisionsOrderOfProvidingPDRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ImportFundSizeInfoRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ImportOperationAndBalanceRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ImportPaymentsInfoRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ImportPlanRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ImportPlanWorkRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ImportRegionalProgramRequest;
import ru.gosuslugi.dom.schema.integration.capital_repair.ImportRegionalProgramWorkRequest;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CapitalRepairPort", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair-service/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.capital_repair.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_registry_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.nsi_base.ObjectFactory.class,
    org.w3._2000._09.xmldsig_.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.account_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.bills_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_base.ObjectFactory.class
})
public interface CapitalRepairPort {


    /**
     * Импорт договоров на выполнение работ (оказание услуг) по капитальному ремонту
     * 
     * @param importContractsRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.CapRemImportResultType
     * @throws Fault
     */
    @WebMethod(action = "urn:importContracts")
    @WebResult(name = "CapRemImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importContractsResult")
    public CapRemImportResultType importContracts(
        @WebParam(name = "importContractsRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importContractsRequest")
        ImportContractsRequest importContractsRequest)
        throws Fault
    ;

    /**
     * Экспорт договоров на выполнение работ (оказание услуг) по капитальному ремонту
     * 
     * @param exportContractsRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.ExportContractsResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportContracts")
    @WebResult(name = "exportContractsResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportContractsResult")
    public ExportContractsResult exportContracts(
        @WebParam(name = "exportContractsRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportContractsRequest")
        ExportContractsRequest exportContractsRequest)
        throws Fault
    ;

    /**
     * Импорт общих сведений о региональной программе капитального ремонта
     * 
     * @param importRegionalProgramRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.CapRemImportResultType
     * @throws Fault
     */
    @WebMethod(action = "urn:importRegionalProgram")
    @WebResult(name = "CapRemImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importRegionalProgramResult")
    public CapRemImportResultType importRegionalProgram(
        @WebParam(name = "importRegionalProgramRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importRegionalProgramRequest")
        ImportRegionalProgramRequest importRegionalProgramRequest)
        throws Fault
    ;

    /**
     * Импорт сведений о домах и работах региональной программы капитального ремонта
     * 
     * @param importRegionalProgramWorkRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.CapRemImportResultType
     * @throws Fault
     */
    @WebMethod(action = "urn:importRegionalProgramWork")
    @WebResult(name = "CapRemImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importRegionalProgramWorkResult")
    public CapRemImportResultType importRegionalProgramWork(
        @WebParam(name = "importRegionalProgramWorkRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importRegionalProgramWorkRequest")
        ImportRegionalProgramWorkRequest importRegionalProgramWorkRequest)
        throws Fault
    ;

    /**
     * Экспорт сведений о региональной программе капитального ремонта
     * 
     * @param exportRegionalProgramRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.ExportRegionalProgramResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportRegionalProgram")
    @WebResult(name = "exportRegionalProgramResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportRegionalProgramResult")
    public ExportRegionalProgramResult exportRegionalProgram(
        @WebParam(name = "exportRegionalProgramRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportRegionalProgramRequest")
        ExportRegionalProgramRequest exportRegionalProgramRequest)
        throws Fault
    ;

    /**
     * Экспорт сведений о домах и работах региональной программы капитального ремонта
     * 
     * @param exportRegionalProgramWorkRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.ExportRegionalProgramWorkResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportRegionalProgramWork")
    @WebResult(name = "exportRegionalProgramWorkResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportRegionalProgramWorkResult")
    public ExportRegionalProgramWorkResult exportRegionalProgramWork(
        @WebParam(name = "exportRegionalProgramWorkRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportRegionalProgramWorkRequest")
        ExportRegionalProgramWorkRequest exportRegionalProgramWorkRequest)
        throws Fault
    ;

    /**
     * Импорт общих сведений о КПР/РАПКР/МАПКР
     * 
     * @param importPlanRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.CapRemImportResultType
     * @throws Fault
     */
    @WebMethod(action = "urn:importPlan")
    @WebResult(name = "CapRemImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importPlanResult")
    public CapRemImportResultType importPlan(
        @WebParam(name = "importPlanRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importPlanRequest")
        ImportPlanRequest importPlanRequest)
        throws Fault
    ;

    /**
     * Импорт сведений о домах и работах КПР/РАПКР/МАПКР
     * 
     * @param importPlanWorkRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.CapRemImportResultType
     * @throws Fault
     */
    @WebMethod(action = "urn:importPlanWork")
    @WebResult(name = "CapRemImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importPlanWorkResult")
    public CapRemImportResultType importPlanWork(
        @WebParam(name = "importPlanWorkRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importPlanWorkRequest")
        ImportPlanWorkRequest importPlanWorkRequest)
        throws Fault
    ;

    /**
     * Экспорт КПР/РАПКР/МАПКР
     * 
     * @param exportPlanRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.ExportPlanResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportPlan")
    @WebResult(name = "exportPlanResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportPlanResult")
    public ExportPlanResult exportPlan(
        @WebParam(name = "exportPlanRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportPlanRequest")
        ExportPlanRequest exportPlanRequest)
        throws Fault
    ;

    /**
     * Экспорт сведений о домах и работах КПР/РАПКР/МАПКР
     * 
     * @param exportPlanWorkRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.ExportPlanWorkResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportPlanWork")
    @WebResult(name = "exportPlanWorkResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportPlanWorkResult")
    public ExportPlanWorkResult exportPlanWork(
        @WebParam(name = "exportPlanWorkRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportPlanWorkRequest")
        ExportPlanWorkRequest exportPlanWorkRequest)
        throws Fault
    ;

    /**
     * Импорт счетов регионального оператора
     * 
     * @param importAccountRegionalOperatorRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.CapRemImportResultType
     * @throws Fault
     */
    @WebMethod(action = "urn:importRegionalOperatorAccounts")
    @WebResult(name = "CapRemImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importAccountRegionalOperatorResult")
    public CapRemImportResultType importRegionalOperatorAccounts(
        @WebParam(name = "importAccountRegionalOperatorRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importAccountRegionalOperatorRequest")
        ImportAccountRegionalOperatorRequest importAccountRegionalOperatorRequest)
        throws Fault
    ;

    /**
     * Импорт специальных счетов
     * 
     * @param importAccountSpecialRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.CapRemImportResultType
     * @throws Fault
     */
    @WebMethod(action = "urn:importSpecialAccounts")
    @WebResult(name = "CapRemImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importAccountSpecialResult")
    public CapRemImportResultType importSpecialAccounts(
        @WebParam(name = "importAccountSpecialRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importAccountSpecialRequest")
        ImportAccountSpecialRequest importAccountSpecialRequest)
        throws Fault
    ;

    /**
     * Экспорт счетов регионального оператора и специальных счетов
     * 
     * @param exportAccountRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.ExportAccountResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportAccounts")
    @WebResult(name = "exportAccountResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportAccountResult")
    public ExportAccountResult exportAccounts(
        @WebParam(name = "exportAccountRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportAccountRequest")
        ExportAccountRequest exportAccountRequest)
        throws Fault
    ;

    /**
     * Импорт решений о выборе способа формирования фонда капитального ремонта
     * 
     * @param importDecisionsFormingFundRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.CapRemImportResultType
     * @throws Fault
     */
    @WebMethod(action = "urn:importDecisionsFormingFund")
    @WebResult(name = "CapRemImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importDecisionsFormingFundResult")
    public CapRemImportResultType importDecisionsFormingFund(
        @WebParam(name = "importDecisionsFormingFundRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importDecisionsFormingFundRequest")
        ImportDecisionsFormingFundRequest importDecisionsFormingFundRequest)
        throws Fault
    ;

    /**
     * Экспорт решений о выборе способа формирования фонда капитального ремонта
     * 
     * @param exportDecisionsFormingFundRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.ExportDecisionsFormingFundResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportDecisionsFormingFund")
    @WebResult(name = "exportDecisionsFormingFundResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportDecisionsFormingFundResult")
    public ExportDecisionsFormingFundResult exportDecisionsFormingFund(
        @WebParam(name = "exportDecisionsFormingFundRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportDecisionsFormingFundRequest")
        ExportDecisionsFormingFundRequest exportDecisionsFormingFundRequest)
        throws Fault
    ;

    /**
     * Импорт актов выполненных работ
     * 
     * @param importCertificatesRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.CapRemImportResultType
     * @throws Fault
     */
    @WebMethod(action = "urn:importCertificates")
    @WebResult(name = "CapRemImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importCertificatesResult")
    public CapRemImportResultType importCertificates(
        @WebParam(name = "importCertificatesRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importCertificatesRequest")
        ImportCertificatesRequest importCertificatesRequest)
        throws Fault
    ;

    /**
     * Импорт информации об оплате работ по капитальному ремонту
     * 
     * @param importPaymentsInfoRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.CapRemImportResultType
     * @throws Fault
     */
    @WebMethod(action = "urn:importPaymentsInfo")
    @WebResult(name = "CapRemImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importPaymentsInfoResult")
    public CapRemImportResultType importPaymentsInfo(
        @WebParam(name = "importPaymentsInfoRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importPaymentsInfoRequest")
        ImportPaymentsInfoRequest importPaymentsInfoRequest)
        throws Fault
    ;

    /**
     * Импорт информации о совершенных операциях и остатках по счетам
     * 
     * @param importOperationAndBalanceRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.CapRemImportResultType
     * @throws Fault
     */
    @WebMethod(action = "urn:importOperationAndBalance")
    @WebResult(name = "CapRemImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importOperationAndBalanceResult")
    public CapRemImportResultType importOperationAndBalance(
        @WebParam(name = "importOperationAndBalanceRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importOperationAndBalanceRequest")
        ImportOperationAndBalanceRequest importOperationAndBalanceRequest)
        throws Fault
    ;

    /**
     * Экспорт кредитных договоров/договоров займа
     * 
     * @param exportCreditContractRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.ExportCreditContractResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportCreditContract")
    @WebResult(name = "exportCreditContractResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportCreditContractResult")
    public ExportCreditContractResult exportCreditContract(
        @WebParam(name = "exportCreditContractRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportCreditContractRequest")
        ExportCreditContractRequest exportCreditContractRequest)
        throws Fault
    ;

    /**
     * Импорт информации о размере фондов капитального ремонта
     * 
     * @param importFundSizeInfoRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.CapRemImportResultType
     * @throws Fault
     */
    @WebMethod(action = "urn:importFundSizeInfo")
    @WebResult(name = "CapRemImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importFundSizeInfoResult")
    public CapRemImportResultType importFundSizeInfo(
        @WebParam(name = "importFundSizeInfoRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importFundSizeInfoRequest")
        ImportFundSizeInfoRequest importFundSizeInfoRequest)
        throws Fault
    ;

    /**
     * Экспорт информации о размере фондов капитального ремонта
     * 
     * @param exportFundSizeInfoRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.ExportFundSizeInfoResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportFundSizeInfo")
    @WebResult(name = "exportFundSizeInfoResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportFundSizeInfoResult")
    public ExportFundSizeInfoResult exportFundSizeInfo(
        @WebParam(name = "exportFundSizeInfoRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportFundSizeInfoRequest")
        ExportFundSizeInfoRequest exportFundSizeInfoRequest)
        throws Fault
    ;

    /**
     * Импорт решений/информации о порядке представления платежных документов
     * 
     * @param importDecisionsOrderOfProvidingPDRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.CapRemImportResultType
     * @throws Fault
     */
    @WebMethod(action = "urn:importDecisionsOrderOfProvidingPD")
    @WebResult(name = "CapRemImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importDecisionsOrderOfProvidingPDResult")
    public CapRemImportResultType importDecisionsOrderOfProvidingPD(
        @WebParam(name = "importDecisionsOrderOfProvidingPDRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "importDecisionsOrderOfProvidingPDRequest")
        ImportDecisionsOrderOfProvidingPDRequest importDecisionsOrderOfProvidingPDRequest)
        throws Fault
    ;

    /**
     * Экспорт решений/информации о порядке представления платежных документов
     * 
     * @param exportDecisionsOrderOfProvidingPDRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.capital_repair.ExportDecisionsOrderOfProvidingPDResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportDecisionsOrderOfProvidingPD")
    @WebResult(name = "exportDecisionsOrderOfProvidingPDResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportDecisionsOrderOfProvidingPDResult")
    public ExportDecisionsOrderOfProvidingPDResult exportDecisionsOrderOfProvidingPD(
        @WebParam(name = "exportDecisionsOrderOfProvidingPDRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair/", partName = "exportDecisionsOrderOfProvidingPDRequest")
        ExportDecisionsOrderOfProvidingPDRequest exportDecisionsOrderOfProvidingPDRequest)
        throws Fault
    ;

}
