package com.inetpsa.pct00.application.service;

import Select.wsdl.*;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import javax.xml.datatype.XMLGregorianCalendar;


@Service
public class WLTPInfoSelectClient extends WebServiceGatewaySupport  {

    private final Logger LOGGER = LoggerFactory.getLogger(WLTPInfoSelectClient.class);

    private ObjectFactory objectFactory;


    @Autowired
    HttpComponentsMessageSender httpComponentsMessageSender;

    public WLTPInfoSelectClient() {

        objectFactory = new ObjectFactory();
    }

    /**
     * Do a REST API call to get information for  WLTP Info's.
     * <p>
     * url
     */
    public SelectV2Response getWltpSelectV2() {
        SelectV2 selectV2 = objectFactory.createSelectV2();

        XMLGregorianCalendar date = new XMLGregorianCalendarImpl();
        date.setYear(2018);
        date.setMonth(7);
        date.setDay(31);

        SelectTypeV2 selectTypeV2 = objectFactory.createSelectTypeV2();

        ContextRequest contextRequest = objectFactory.createContextRequest();
        contextRequest.setClient("TestJan");
        contextRequest.setBrand("P");
        contextRequest.setCountry("NL");
        contextRequest.setDate(date);
        contextRequest.setNetwork(false);
//        contextRequest.setLanguageID("NL");
        contextRequest.setTaxIncluded(true);
        contextRequest.setLocalCurrency(false);
        contextRequest.setShowAllVersions(false);
        selectTypeV2.setContextRequest(contextRequest);

        SelectCriteriaV2 selectCriteriaV2 = objectFactory.createSelectCriteriaV2();
        //TODO  fill in the selection criteria exaple
        selectCriteriaV2.setVehicleUse("");
        selectTypeV2.setSelectCriteria(selectCriteriaV2);

        selectV2.setSelectV2(selectTypeV2);
        return getWltpSelectV2(selectV2);
    }
    public SelectV2Response getWltpSelectV2(SelectV2 selectV2) {

        SelectV2Response selectV2Response;

        Object response = null;
        try {
            //Request object is filled, now do the web request:
            WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
            Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
            marshaller.setContextPath("Select.wsdl");
            webServiceTemplate.setMarshaller(marshaller);
            webServiceTemplate.setUnmarshaller(marshaller);

            webServiceTemplate.afterPropertiesSet();
// set a HttpComponentsMessageSender which provides support for basic authentication
            webServiceTemplate.setMessageSender(httpComponentsMessageSender);
            response = webServiceTemplate
                    .marshalSendAndReceive(selectV2, new SoapActionCallback("http://xml.inetpsa.com/Services/Cfg/Select#SelectV2"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        selectV2Response = (SelectV2Response) response;
        return selectV2Response;
    }
}


/* example request SelectV2 : this works with SoapUI.
*  <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sel="http://xml.inetpsa.com/Services/Cfg/Select" xmlns:cfg="http://inetpsa.com/cfg">
   <soapenv:Header/>
   <soapenv:Body>
      <sel:selectV2>
         <SelectV2 xmlns="http://inetpsa.com/cfg">
            <ContextRequest>
               <Client>Brandwidth</Client>
               <Brand>P</Brand>
               <Country>NL</Country>
               <Date>2018-07-31</Date>
               <Network>false</Network>
               <TaxIncluded>true</TaxIncluded>
               <LocalCurrency>true</LocalCurrency>
               <ShowAllVersions>false</ShowAllVersions>
            </ContextRequest>
            <SelectCriteria>
               <VehicleUse/>
            </SelectCriteria>
         </SelectV2>
      </sel:selectV2>
   </soapenv:Body>
</soapenv:Envelope>

* */