package com.inetpsa.pct00.application.service;

import com.inetpsa.pct00.application.service.wltp.Config;
import com.inetpsa.pct00.application.service.wltp.ConfigResponse;
import com.inetpsa.pct00.application.service.wltp.ConfigType;
import com.inetpsa.pct00.application.service.wltp.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


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


