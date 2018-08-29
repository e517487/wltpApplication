package com.inetpsa.pct00.application;

import com.inetpsa.pct00.application.service.WLTPInfoClient;
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

    @Bean
    CommandLineRunner lookup(WLTPInfoClient wltpInfoClient) {

        return args -> {
            wltpInfoClient.getWltpConfigV2(  );
        };
    }
}




