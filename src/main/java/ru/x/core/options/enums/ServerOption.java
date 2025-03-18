package ru.x.core.options.enums;

public enum ServerOption implements Option{
    USE_HOSTNAME("usehostname"),
    TIMEOUT("timeout"),
    KEY_STORE_PATH("keystorepath"),
    KEY_STORE_PASSWORD("keystorepassword"),
    TRUST_STORE_PATH("truststorepath"),
    TRUST_STORE_PASSWORD("truststorepassword");

    private final String name;

    ServerOption(final String name) {
        this.name = String.format("server.%s", name);
    }

    @Override
    public String getName() {
        return String.format("%s.%s", Option.super.getName(), name);
    }

    @Override
    public String toString() {
        return getName();
    }

}
