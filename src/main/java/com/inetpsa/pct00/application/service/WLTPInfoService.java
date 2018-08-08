package com.inetpsa.pct00.application.service;

import Config.wsdl.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class WLTPInfoService {

    private final Logger log = LoggerFactory.getLogger(WLTPInfoService.class);

    private ObjectFactory objectFactory;

/*    @Value("${wltp-info.api.url}")
    private String rootUri;
    @Value("${wltp-info.api.key}")
    private String key;*/

    public WLTPInfoService( ) {

        objectFactory = new ObjectFactory();
    }


    /**
     * Do a REST API call to get information for  WLTP Info's.
     *
     * url
     *
     */



}


