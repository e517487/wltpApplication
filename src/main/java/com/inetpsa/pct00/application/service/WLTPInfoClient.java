package com.inetpsa.pct00.application.service;

import Config.wsdl.*;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.datatype.XMLGregorianCalendar;


@Service
public class WLTPInfoClient extends WebServiceGatewaySupport {

    private final Logger log = LoggerFactory.getLogger(WLTPInfoClient.class);

    private ObjectFactory objectFactory;


    public WLTPInfoClient() {

        objectFactory = new ObjectFactory();
    }


    /**
     * Do a REST API call to get information for  WLTP Info's.
     * <p>
     * url
     */
    public ConfigResponseTypeV2 getWltpConfigV2() {

        XMLGregorianCalendar date = new XMLGregorianCalendarImpl();
        date.setYear(2018);
        date.setMonth(8);
        date.setDay(8);

        //Request
        ConfigV2 configV2 = new ConfigV2();
        ConfigType configType = new ConfigType();
        configV2.setConfig(configType);

        ConfigCriteria configCriteria = new ConfigCriteria();
        WLTP wltp = new WLTP();
        wltp.setFlagWLTP(true);
        wltp.setPhaseWLTP("FULL");
        wltp.setDateWLTP(date);
        configCriteria.setWLTP(wltp);

        Feature feature1 = new Feature();
        feature1.setId("0P8D0RFJ");
        configCriteria.getFeature().add(feature1);
        Feature feature2 = new Feature();
        feature2.setId("0MM60NN9");
        configCriteria.getFeature().add(feature2);
//            configCriteria.setVersion("1PT9C5PMA1B0BUD0");
        configCriteria.setVersion("1PT9A5TLHKB0A0D0");

        configType.setConfigCriteria(configCriteria);


        ContextRequest contextRequest = new ContextRequest();
        contextRequest.setClient("B2B Actor Name");//"JATO");
        contextRequest.setBrand("P");
        contextRequest.setCountry("NL");

        contextRequest.setDate(date);
        contextRequest.setLanguageID("NL");
        contextRequest.setTaxIncluded(true);
        contextRequest.setLocalCurrency(false);

        configType.setContextRequest(contextRequest);

        //nu kijken of er iets te halen valt:
        ConfigResponseTypeV2 configResponseTypeV2;
//        configResponseTypeV2 = (ConfigResponseTypeV2) getWebServiceTemplate()
//                .marshalSendAndReceive("https://api.inetpsa.com/applications/moteur-de-configuration-vn/config/v1?client_id=748c557e-eb73-4434-b7a8-6e1e704abd14"
//                        , configV2
//                        , new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

        configResponseTypeV2 = (ConfigResponseTypeV2) getWebServiceTemplate()
                .marshalSendAndReceive("https://api.inetpsa.com/applications/moteur-de-configuration-vn/config/v1?client_id=748c557e-eb73-4434-b7a8-6e1e704abd14"
                        , configV2
                ,new SoapActionCallback(""));
        System.out.println("Version: " + configResponseTypeV2.getVersion());
/*        ConfigResponseTypeV2 configResponseTypeV2 = (ConfigResponseTypeV2) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));
        ;*/

/*


        Config config = objectFactory.createConfig( );
        config.setConfig(objectFactory.createConfigType());
        try {

            configResponseTypeV2 = configHttpPort.config(config.getConfig());

        } catch (ServiceException_Exception e) {
            e.printStackTrace();
        }
*/


        return configResponseTypeV2;
    }


}


