package com.inetpsa.pct00.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WLTPInfoConfigService {

    private final Logger log = LoggerFactory.getLogger(WLTPInfoConfigService.class);

    @Autowired
    WLTPInfoConfiguration wltpInfoConfiguration;

    @Autowired
    WLTPInfoConfigClient wltpInfoConfigClient;


    public WLTPInfoConfigService() {
    }


    /**
     * Do a REST API call to get information for  WLTP Info's.
     * <p>
     * url
     */
    public void doConfigV2Request() {

        wltpInfoConfigClient.getWltpConfigV2();
    }


}


