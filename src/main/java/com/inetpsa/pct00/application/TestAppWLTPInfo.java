package com.inetpsa.pct00.application;

import com.inetpsa.pct00.application.service.WLTPInfoSelectClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestAppWLTPInfo {

    private static final Logger log = LoggerFactory.getLogger(TestAppWLTPInfo.class);


    public static void main(String args[]) {

        SpringApplication.run(TestAppWLTPInfo.class, args);

    }

    // Toggle between the 2 lookup methods to test ConfigV2 request or SelectV2 Request.
/*
    @Bean
    CommandLineRunner lookup(WLTPInfoConfigClient wltpInfoConfigClient) {

        return args -> {
            wltpInfoConfigClient.getWltpConfigV2(  );
        };
    }
*/


    @Bean
    CommandLineRunner lookup(WLTPInfoSelectClient wltpInfoSelectClient) {

        return args -> {
            wltpInfoSelectClient.getWltpSelectV2();
        };
    }
}




