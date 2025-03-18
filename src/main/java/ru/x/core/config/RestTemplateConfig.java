package ru.x.core.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ssl.SslStoreBundle;
import org.springframework.boot.ssl.jks.JksSslStoreBundle;
import org.springframework.boot.ssl.jks.JksSslStoreDetails;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Value("${client.keystore.path}")
    private String keystoreClientPath;

    @Value("${client.keystore.password}")
    private String keystorePassword;

    @Value("${server.ssl.trust-store}")
    private String truststorePath;

    @Value("${server.ssl.trust-store-password}")
    private String truststorePassword;

    @Bean
    public RestTemplate restTemplate(){

        JksSslStoreDetails keySslStoreDetails = new JksSslStoreDetails("JKS", null, keystoreClientPath, keystorePassword);
        JksSslStoreDetails trustSslStoreDetails = new JksSslStoreDetails("JKS", null, truststorePath, truststorePassword);
        SslStoreBundle sslStoreBundle = new JksSslStoreBundle(keySslStoreDetails, trustSslStoreDetails);

        return new RestTemplateBuilder()
                .build();
        
    }

}
