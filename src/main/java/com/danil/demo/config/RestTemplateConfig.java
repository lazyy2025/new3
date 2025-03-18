package com.danil.demo.config;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactoryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

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

//    @Value("${client.connect-timeout}")
//    private int connectTimeout;
//
//    @Value("${client.read-timeout}")
//    private int readTimeout;


    private SSLContext getSSLContext() throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {

        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        FileInputStream keyStream = new FileInputStream(keystoreClientPath);
        keyStore.load(keyStream, keystorePassword.toCharArray());
        keyStream.close();


        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        FileInputStream trustStream = new FileInputStream(truststorePath);
        trustStore.load(trustStream, truststorePassword.toCharArray());
        trustStream.close();


        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());

        keyManagerFactory.init(keyStore, keystorePassword.toCharArray());
        trustManagerFactory.init(trustStore);

//        if(connectionSettings.isEnableRevocationChecker()){
//            PKIXRevocationChecker revocationChecker = (PKIXRevocationChecker) CertPathBuilder.getInstance("PKIX")
//                    .getRevocationChecker();
//            PKIXBuilderParameters pkixParams = new PKIXBuilderParameters(keyStore, new X509CertSelector());
//
//            pkixParams.addCertPathChecker(revocationChecker);
//            trustManagerFactory.init(new CertPathTrustManagerParameters(pkixParams));
//        }
//        else {
//        trustManagerFactory.init(trustStore);
//        }
        SSLContext sslContext = null;
        try {

            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
        } catch (Exception ex) {
//            throw new BatchException(ex, "Unable to create SSL context");
        }

//        SSLContext sslContext = null;
//        try {
//            sslContext = SSLContextBuilder.create()
//                    .loadKeyMaterial(ResourceUtils.getFile(keystoreClientPath), keystorePassword.toCharArray(), keystorePassword.toCharArray())
//                    .loadTrustMaterial(ResourceUtils.getFile(truststorePath), truststorePassword.toCharArray()).build();
//        } catch (Exception ex) {
////            throw new BatchException(ex, "Unable to create SSL context");
//        }

        return sslContext;
    }

    @Bean
    public RestTemplate restTemplate() throws UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        return new RestTemplate(getClientHttpRequestFactory());
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() throws UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {

        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(30000, TimeUnit.MILLISECONDS)
                .setResponseTimeout(30000,TimeUnit.MILLISECONDS)
                .setConnectionRequestTimeout(30000,TimeUnit.MILLISECONDS)
                .build();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(config)
                .setConnectionManager(PoolingHttpClientConnectionManagerBuilder.create()
                        .setSSLSocketFactory(SSLConnectionSocketFactoryBuilder.create()
                                .setSslContext(getSSLContext())
                                .setHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                                .build())
                        .build())
                .build();
        return new HttpComponentsClientHttpRequestFactory(httpClient);

    }

}
