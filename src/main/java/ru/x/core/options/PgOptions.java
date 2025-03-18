package ru.x.core.options;

import lombok.Getter;
import ru.x.core.options.enums.PgOption;

import java.util.Map;

@Getter
public class PgOptions extends Options{

    private static final long serialVersionUID = 0L;

    public static final String DEFAULT_DRIVER_NAME = "org.postgresql.Driver";
    static final String DEFAULT_DB_SCHEMA_NAME = "public";
    static final String DEFAULT_JAAS_APPLICATION_NAME = "pgjdbc";
    static final String DEFAULT_KERBEROS_SERVER_NAME = "postgres";
    static final String JDBC_URL_PATTERN = "jdbc:postgresql://%s/%s";
    static final String TABLE_NAME_PATTERN = "%s.%s";



    /**
     * The JDBC connection string URL.
     */
    private final String url;

//    /**
//     * The name of the JAAS system or application login configuration.
//     */
//    private final String jaasApplicationName;
//
//    /**
//     * The Kerberos service name to use when authenticating with GSSAPI.
//     */
//    private final String kerberosServerName;
//
    /**
     * The Greenplum Database user/role name.
     */
    private final String user;

//    /**
//     * The name of the Greenplum Database table.
//     */
//    private final String dbTable;
//
//    /**
//     * The name of the Greenplum Database schema in which dbtable resides.
//     * Optional, the default schema is the schema named public.
//     */
//    private final String dbSchema;
//
    /**
     * The fully qualified class path of the custom JDBC driver.
     * The value is always {@code org.postgresql.Driver}
     */
    private final String driver;

//    /**
//     * Spark application id.
//     */
//    private final String applicationId;
//
//    /**
//     * Options for gpfdist server.
//     */
//    private final ServerOptions serverOptions;

    public PgOptions(final Map<String, String> options) {
        super(options);
        this.url = getUrlFromOptions();
//        this.jaasApplicationName = getOptional(PgOption.JAAS_APPLICATION_NAME, String.class, DEFAULT_JAAS_APPLICATION_NAME).trim();
//        this.kerberosServerName = getOptional(PgOption.KERBEROS_SERVER_NAME, String.class, DEFAULT_KERBEROS_SERVER_NAME).trim();
//        this.dbTable = getRequired(PgOption.DB_TABLE, String.class).trim();
        this.user = getRequired(PgOption.USER, String.class).trim();
//        this.dbSchema = getOptional(PgOption.DB_SCHEMA, String.class, DEFAULT_DB_SCHEMA_NAME).trim();
        this.driver = DEFAULT_DRIVER_NAME;
//        this.applicationId = applicationId;
//        this.serverOptions = serverOptions;
    }


    /**
     * Creates the postgresql JDBC connection string URL using
     * {@code authority} and {@code dbname} options.
     *
     * @return the postgresql JDBC connection string URL.
     */
    private String getUrlFromOptions() {
        final String authority = getRequired(PgOption.AUTHORITY, String.class).trim();
        final String dbName = getRequired(PgOption.DB_NAME, String.class).trim();
        return String.format(JDBC_URL_PATTERN, authority, dbName);
    }


    /**
     * Creates full name of the Greenplum Database table.
     *
     * @return full name of the Greenplum Database table.
     */
//    public String getFullTableName() {
//        return String.format(TABLE_NAME_PATTERN, dbSchema, dbTable);
//    }

}
