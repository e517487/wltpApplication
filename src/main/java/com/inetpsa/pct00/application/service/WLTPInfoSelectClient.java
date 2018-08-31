package com.inetpsa.pct00.application.service;

import Select.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;


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

        SelectTypeV2 selectTypeV2 = objectFactory.createSelectTypeV2();

        ContextRequest contextRequest = objectFactory.createContextRequest();
        //
        selectTypeV2.setContextRequest(contextRequest);

        SelectCriteriaV2 selectCriteriaV2 = objectFactory.createSelectCriteriaV2();
        //
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


