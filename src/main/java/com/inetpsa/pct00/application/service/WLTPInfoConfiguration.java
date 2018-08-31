package com.inetpsa.pct00.application.service;


import org.apache.http.auth.UsernamePasswordCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

/**
 *  for basic authentication i used the following tutorial:
 *      https://www.codenotfound.com/spring-ws-basic-authentication-example.html
 */

@Configuration
public class WLTPInfoConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(WLTPInfoConfiguration.class);


    private String userName = "e517487";
    private String userPassword = "Fdsa123a";


    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("Config.wsdl");
        return marshaller;
    }

    @Bean
    public WLTPInfoConfigClient wltpInfoConfigClient(Jaxb2Marshaller marshaller) throws Exception {
        WLTPInfoConfigClient wltpInfoConfigClient = new WLTPInfoConfigClient();
//        wltpInfoClient.setDefaultUri("http://localhost:8080/");
//        wltpInfoClient.setDefaultUri("http://localhost:8080/");
        wltpInfoConfigClient.setDefaultUri("https://api.inetpsa.com/applications/moteur-de-configuration-vn/config/v1?client_id=748c557e-eb73-4434-b7a8-6e1e704abd14");
//        wltpInfoClient.setDefaultUri("https://api-basic.groupe-psa.com/applications/moteur-de-configuration-vn/config/v1?client_id=ffd16c30-c9e9-4a35-8ff0-0a527cdfdf1f");
        wltpInfoConfigClient.setMarshaller(marshaller);
        wltpInfoConfigClient.setUnmarshaller(marshaller);

        wltpInfoConfigClient.afterPropertiesSet();

        return wltpInfoConfigClient;
    }

    @Bean
    public WLTPInfoSelectClient wltpInfoSelectClient(Jaxb2Marshaller marshaller) throws Exception {
        WLTPInfoSelectClient wltpInfoSelectClient = new WLTPInfoSelectClient();
        wltpInfoSelectClient.setDefaultUri("https://api.inetpsa.com/applications/moteur-de-configuration-vn/select/v1?client_id=748c557e-eb73-4434-b7a8-6e1e704abd14");
        wltpInfoSelectClient.setMarshaller(marshaller);
        wltpInfoSelectClient.setUnmarshaller(marshaller);

        wltpInfoSelectClient.afterPropertiesSet();

        return wltpInfoSelectClient;
    }

    @Bean
    public HttpComponentsMessageSender httpComponentsMessageSender() {
        HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
        // set the basic authorization credentials
        httpComponentsMessageSender.setCredentials(usernamePasswordCredentials());

        return httpComponentsMessageSender;
    }

    @Bean
    public UsernamePasswordCredentials usernamePasswordCredentials() {
        // pass the user name and password to be used
        return new UsernamePasswordCredentials(userName, userPassword);
    }
}
