package com.inetpsa.pct00.application.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


@Configuration
public class WLTPInfoConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(WLTPInfoConfiguration.class);
//    @Value("${uefa.ws.key-store}")
    private Resource keyStore;

//    @Value("${uefa.ws.key-store-password}")
    private String keyStorePassword;


    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

//        marshaller.

        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("Config.wsdl");
        return marshaller;
    }

    @Bean
    public WLTPInfoClient wltpInfoClient( Jaxb2Marshaller marshaller) throws Exception {
        WLTPInfoClient wltpInfoClient = new WLTPInfoClient();
//        wltpInfoClient.setDefaultUri("http://localhost:8080/");
//        wltpInfoClient.setDefaultUri("http://localhost:8080/");
        wltpInfoClient.setDefaultUri("https://api.inetpsa.com/applications/moteur-de-configuration-vn/config/v1?client_id=748c557e-eb73-4434-b7a8-6e1e704abd14");
//        wltpInfoClient.setDefaultUri("https://api-basic.groupe-psa.com/applications/moteur-de-configuration-vn/config/v1?client_id=ffd16c30-c9e9-4a35-8ff0-0a527cdfdf1f");
        wltpInfoClient.setMarshaller( marshaller);
        wltpInfoClient.setUnmarshaller( marshaller);

        wltpInfoClient.afterPropertiesSet();

        return wltpInfoClient;
    }
}
