package com.inetpsa.pct00.application.service;

import com.inetpsa.pct00.application.service.wltp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


@Service
public class WLTPInfoClient extends WebServiceGatewaySupport{

    private final Logger log = LoggerFactory.getLogger(WLTPInfoClient.class);

    private ObjectFactory objectFactory;


    public WLTPInfoClient( ) {

        objectFactory = new ObjectFactory();
    }


    /**
     * Do a REST API call to get information for  WLTP Info's.
     *
     * url
     *
     */
    public ConfigResponseType getWltpConfig(ConfigPortType configHttpPort ) {
//        ConfigResponse configResponse= new ConfigResponse();
        ConfigResponseType configResponseType = new ConfigResponseType();



        Config config = objectFactory.createConfig( );
        config.setConfig(objectFactory.createConfigType());
        try {

            configResponseType = configHttpPort.config(config.getConfig());

        } catch (ServiceException_Exception e) {
            e.printStackTrace();
        }


        return configResponseType;
    }

    public void getWltpConfigFeature() {
        objectFactory.createConfigFeature();

    }

    public void getWltpConfigV2() {

    }


}


