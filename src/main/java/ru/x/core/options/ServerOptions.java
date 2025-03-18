package ru.x.core.options;

import lombok.Getter;
import ru.x.core.options.enums.ServerOption;

import java.util.Map;

@Getter
public class ServerOptions extends Options{

    private static final long serialVersionUID = 0L;

    static final Boolean DEFAULT_USE_HOSTNAME = true;
    static final String DEFAULT_KEY_STORE_PATH = "keystore.jks";
    static final String DEFAULT_TRUST_STORE_PATH = "truststore.jks";


    private final String keyStorePath;
    private final String trustStorePath;
    private final char[] trustStorePassword;
    private final char[] keyStorePassword;
    private final Boolean useHostname;

    private ServerOptions(final Map<String, String> options) {
        super(options);
        this.useHostname = getOptional(ServerOption.USE_HOSTNAME, Boolean.class, DEFAULT_USE_HOSTNAME);
        this.keyStorePath = getOptional(ServerOption.KEY_STORE_PATH, String.class, DEFAULT_KEY_STORE_PATH).trim();
        this.keyStorePassword = getRequired(ServerOption.KEY_STORE_PASSWORD, String.class).toCharArray();
        this.trustStorePath = getOptional(ServerOption.TRUST_STORE_PATH, String.class, DEFAULT_TRUST_STORE_PATH).trim();
        this.trustStorePassword = getRequired(ServerOption.TRUST_STORE_PASSWORD, String.class).toCharArray();
    }

    public boolean isKeyStoreConfigured() {
        return keyStorePath != null && !keyStorePath.isEmpty() && keyStorePassword != null;
    }

    public boolean isTrustStoreConfigured() {
        return trustStorePath != null && !trustStorePath.isEmpty() && trustStorePassword != null;
    }

    public boolean isServerSecured() {
        return isKeyStoreConfigured() && isTrustStoreConfigured();
    }
}
