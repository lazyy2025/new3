package ru.x.core.jdbc.connection;

import com.zaxxer.hikari.HikariConfig;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import ru.x.core.options.PgOptions;

public class HikariConfigCreator {

    protected HikariConfig createHikariConfig(final PgOptions pgOptions)
    {
        final HikariConfig hikariConfig = new HikariConfig();
//        final ServerOptions serverOptions = pgOptions.getServerOptions();
//        String url = "jdbc:postgresql://" + host + ":" + port + "/portaldb?ssl=true&sslmode=require&sslrootcert=" +
//                sslRootCert + "&sslcert=" + sslCert + "&sslkey=" + sslKey;
        String url = "jdbc:postgresql://192.168.1.77:5432/postgres";
        //    String url = pgOptions.getUrl();
//        log.info("Creating database connection for url: " + url);
        hikariConfig.setJdbcUrl(url);
//        hikariConfig.setJdbcUrl(pgOptions.getUrl());

        hikariConfig.setUsername(pgOptions.getUser());
        hikariConfig.setDriverClassName(pgOptions.getDriver());
        hikariConfig.setPassword("mysecretpassword");
        hikariConfig.addDataSourceProperty("cachePrepStmts" , "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize" , "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit" , "2048");
//        hikariConfig.addDataSourceProperty(JAAS_APPLICATION_NAME_PROPERTY, pgOptions.getJaasApplicationName());
//        hikariConfig.addDataSourceProperty(KERBEROS_SERVER_NAME_PROPERTY, pgOptions.getKerberosServerName());
//        if (serverOptions.isServerSecured()) {
//            hikariConfig.addDataSourceProperty("ssl", "true");
//            hikariConfig.addDataSourceProperty("sslmode", "verify-full");
//            hikariConfig.addDataSourceProperty("sslfactory", SdpgpcSSLFactory.class.getCanonicalName());
//            hikariConfig.addDataSourceProperty(SdpgpcSSLFactory.SDPGPC_KEYSTORE_PATH_PROPERTY, serverOptions.getKeyStorePath());
//            hikariConfig.addDataSourceProperty(SdpgpcSSLFactory.SDPGPC_KEYSTORE_PASS_PROPERTY, new String(serverOptions.getKeyStorePassword()));
//            hikariConfig.addDataSourceProperty(SdpgpcSSLFactory.SDPGPC_TRUSTSTORE_PATH_PROPERTY, serverOptions.getTrustStorePath());
//            hikariConfig.addDataSourceProperty(SdpgpcSSLFactory.SDPGPC_TRUSTSTORE_PASS_PROPERTY, new String(serverOptions.getTrustStorePassword()));
//        }
//        log.info("Connected to PG");
        // return DSL.using(new HikariDataSource(config), SQLDialect.POSTGRES);
        return hikariConfig;
    }



}
