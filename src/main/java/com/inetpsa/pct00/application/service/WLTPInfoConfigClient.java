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
public class WLTPInfoConfigClient extends WebServiceGatewaySupport {

    private final Logger LOGGER = LoggerFactory.getLogger(WLTPInfoConfigClient.class);

    private ObjectFactory objectFactory;


    @Autowired
    HttpComponentsMessageSender httpComponentsMessageSender;

    public WLTPInfoConfigClient() {

        objectFactory = new ObjectFactory();
    }

    /**
     * Do a REST API call to get information for  WLTP Info's.
     * <p>
     * url
     */
    public ConfigV2Response getWltpConfigV2() {
        // Used this method to fill the request object for the actual webcall

        XMLGregorianCalendar date = new XMLGregorianCalendarImpl();
        date.setYear(2018);
        date.setMonth(8);
        date.setDay(8);

        //Lets fill the Request object.
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
        return getWltpConfigV2(configV2);
    }

    public ConfigV2Response getWltpConfigV2(ConfigV2 configV2) {
        //Request object is filled, now do the web request:
        WebServiceTemplate webServiceTemplate = getWebServiceTemplate();

        ConfigV2Response configV2Response;
        Object response = null;
        try {

// set a HttpComponentsMessageSender which provides support for basic authentication
            webServiceTemplate.setMessageSender(httpComponentsMessageSender);


            response = webServiceTemplate
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


