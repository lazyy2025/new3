package ru.x.core.options.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PgOption implements Option {
    AUTHORITY("authority"),
    JAAS_APPLICATION_NAME("jaasapplicationname"),
    KERBEROS_SERVER_NAME("kerberosservername"),
    DB_NAME("dbname"),
    DB_SCHEMA("dbschema"),
    DB_TABLE("dbtable"),
    USER("user");

    private final String name;

    @Override
    public String getName() {
        return String.format("%s.%s", Option.super.getName(), name);
    }

    @Override
    public String toString() {
        return getName();
    }

}
