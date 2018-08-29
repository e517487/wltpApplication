package com.inetpsa.pct00.application.service;

import Config.wsdl.*;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import javax.xml.datatype.XMLGregorianCalendar;


@Service
public class WLTPInfoClient extends WebServiceGatewaySupport  {

    private final Logger LOGGER = LoggerFactory.getLogger(WLTPInfoClient.class);

    private ObjectFactory objectFactory;


    @Autowired
    HttpComponentsMessageSender httpComponentsMessageSender;

    public WLTPInfoClient() {

        objectFactory = new ObjectFactory();
    }


    /**
     * Do a REST API call to get information for  WLTP Info's.
     * <p>
     * url
     */
    public ConfigV2Response getWltpConfigV2() {

        XMLGregorianCalendar date = new XMLGregorianCalendarImpl();
        date.setYear(2018);
        date.setMonth(8);
        date.setDay(8);

        //Request
        ConfigV2 configV2 = objectFactory.createConfigV2();
        ConfigType configType = objectFactory.createConfigType();
        configV2.setConfig(configType);

        ConfigCriteria configCriteria = objectFactory.createConfigCriteria();
        WLTP wltp = objectFactory.createWLTP();
        wltp.setFlagWLTP(true);
        wltp.setPhaseWLTP("FULL");
        wltp.setDateWLTP(date);
        configCriteria.setWLTP(wltp);

        Feature feature1 = objectFactory.createFeature();
        feature1.setId("0P8D0RFJ");
        configCriteria.getFeature().add(feature1);
        Feature feature2 = objectFactory.createFeature();
        feature2.setId("0MM60NN9");
        configCriteria.getFeature().add(feature2);
//            configCriteria.setVersion("1PT9C5PMA1B0BUD0");
        configCriteria.setVersion("1PT9A5TLHKB0A0D0");

        configType.setConfigCriteria(configCriteria);


        ContextRequest contextRequest = objectFactory.createContextRequest();
        contextRequest.setClient("TestJan");
        contextRequest.setBrand("P");
        contextRequest.setCountry("NL");

        contextRequest.setDate(date);
        contextRequest.setLanguageID("NL");
        contextRequest.setTaxIncluded(true);
        contextRequest.setLocalCurrency(false);

        configType.setContextRequest(contextRequest);

        //nu kijken of er iets te halen valt
        WebServiceTemplate webServiceTemplate = getWebServiceTemplate();

        ConfigV2Response configV2Response;
        Object response = null;
        try {

// set a HttpComponentsMessageSender which provides support for basic authentication
            webServiceTemplate.setMessageSender(httpComponentsMessageSender);


            response = webServiceTemplate
//                    .marshalSendAndReceive("https://api.inetpsa.com/applications/moteur-de-configuration-vn/config/v1?client_id=748c557e-eb73-4434-b7a8-6e1e704abd14"
//                .marshalSendAndReceive("https://api-basic.groupe-psa.com/applications/moteur-de-configuration-vn/config/v1?client_id=ffd16c30-c9e9-4a35-8ff0-0a527cdfdf1f"
//                .marshalSendAndReceive("https://api-basic.groupe-psa.com/applications/moteur-de-configuration-vn/config/v1?client_id=ffd16c30-c9e9-4a35-8ff0-0a527cdfdf1f"
//                    , configV2 );
                            .marshalSendAndReceive(configV2, new SoapActionCallback("http://xml.inetpsa.com/Services/Cfg/Config#ConfigV2"));
//                            .marshalSendAndReceive(configV2, new SoapActionCallback("http://xml.inetpsa.com/Services/Cfg/Config#ConfigV2Response"));
//        System.out.println("Version: " + configResponseTypeV2.getVersion());
/*        ConfigResponseTypeV2 configResponseTypeV2 = (ConfigResponseTypeV2) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));
        ;*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        configV2Response = (ConfigV2Response) response;
        return configV2Response;
    }
}


