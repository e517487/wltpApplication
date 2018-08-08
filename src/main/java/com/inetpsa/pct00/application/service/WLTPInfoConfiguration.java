package com.inetpsa.pct00.application.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WLTPInfoConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("Config.wsdl");
        return marshaller;
    }

    @Bean
    public WLTPInfoClient wltpInfoClient( Jaxb2Marshaller marshaller) {
        WLTPInfoClient wltpInfoClient = new WLTPInfoClient();
        wltpInfoClient.setDefaultUri("https://api.inetpsa.com/applications/moteur-de-configuration-vn/");
//        wltpInfoClient.setDefaultUri("https://api.inetpsa.com/applications/moteur-de-configuration-vn/config/v1?client_id=748c557e-eb73-4434-b7a8-6e1e704abd14");
        wltpInfoClient.setMarshaller( marshaller);
        wltpInfoClient.setUnmarshaller( marshaller);

        return wltpInfoClient;
    }
}
