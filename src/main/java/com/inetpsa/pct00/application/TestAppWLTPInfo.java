package com.inetpsa.pct00.application;

import com.inetpsa.pct00.application.service.WLTPInfoClient;
import com.inetpsa.pct00.application.service.WLTPInfoService;
import com.inetpsa.pct00.application.service.wltp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executor;

@SpringBootApplication
public class TestAppWLTPInfo {

    private static final Logger log = LoggerFactory.getLogger(TestAppWLTPInfo.class);


    public static void main(String args[]) {
        SpringApplication.run(TestAppWLTPInfo.class, args);

//		WLTPInfoService wltpInfoService = new WLTPInfoService();
//
//		wltpInfoService.getWltpConfig("test");
    }

    @Bean
    CommandLineRunner lookup(WLTPInfoClient wltpInfoClient) {
        return args -> {
//            wltpInfoService = new WLTPInfoService();

            Config_Service configService = new Config_Service();

            ConfigType configType = new ConfigType();

            ConfigCriteria configCriteria = new ConfigCriteria();
            WLTP wltp = new WLTP();
            wltp.setFlagWLTP(true);
//            wltp. ;
            configCriteria.setWLTP( wltp);
            configCriteria.setVersion("1PT9C5PMA1B0BUD0");

            configType.setConfigCriteria(configCriteria);

            ContextRequest contextRequest = new ContextRequest();
            contextRequest.setClient("B2B Actor Name");//"JATO");
            contextRequest.setBrand("P");
            contextRequest.setCountry("FR");


            configType.setContextRequest(contextRequest);

            ConfigPortType configHttpPort = configService.getConfigHttpPort();
            Executor executor = configService.getExecutor();

            ConfigResponseTypeV2 configResponseTypeV2 = configHttpPort.configV2(configType);
            System.out.println( "Version: " + configResponseTypeV2.getVersion());
            System.out.println( "Version: " + configResponseTypeV2.getVersion());

//            wltpInfoClient.getWltpConfig( configHttpPort );
        };
    }

/*    @Bean
    CommandLineRunner lookup(Config_Service configService) {
        return args -> {
            ConfigPortType configHttpPort = configService.getConfigHttpPort();
        };
    }*/


}




