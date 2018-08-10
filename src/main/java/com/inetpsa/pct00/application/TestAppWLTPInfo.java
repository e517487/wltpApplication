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
/*        String tmp = System.getProperty("http.proxyUser", System.getProperty("https.proxyUser"));
        if (tmp == null) {
            System.out.println("Proxy username: ");
            tmp = new Scanner(System.in).nextLine();
        }
        final String userName = tmp;

        tmp = System.getProperty("http.proxyPassword", System.getProperty("https.proxyPassword"));
        if (tmp == null) {
            System.out.println("Proxy password: ");
            tmp = new Scanner(System.in).nextLine();
        }
        final char[] password = tmp.toCharArray();

        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                System.out.println("\n--------------\nProxy auth: " + userName);
                return new PasswordAuthentication (userName, password);
            }

        });*/
        SpringApplication.run(TestAppWLTPInfo.class, args);

    }

    @Bean
    CommandLineRunner lookup(WLTPInfoClient wltpInfoClient) {

        return args -> {

            wltpInfoClient.getWltpConfigV2(  );
        };
    }
}




