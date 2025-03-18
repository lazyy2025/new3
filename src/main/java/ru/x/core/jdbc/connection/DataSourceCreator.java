package ru.x.core.jdbc.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import ru.x.core.options.PgOptions;

import javax.sql.DataSource;

@Slf4j
public class DataSourceCreator {

    //    public static final HikariConfigCreator hikariConfigCreator;
    public static final String JAAS_APPLICATION_NAME_PROPERTY = "jaasApplicationName";
    public static final String KERBEROS_SERVER_NAME_PROPERTY = "kerberosServerName";

    private DataSourceCreator() {
        // use static factory method getInstance
    }

    public static DataSourceCreator getInstance() {
        return DataSourceCreatorHolder.INSTANCE;
    }

    private static class DataSourceCreatorHolder {
        private static final DataSourceCreator INSTANCE = new DataSourceCreator();
    }

    public DataSource createDataSource(final PgOptions pgOptions) {
        HikariConfigCreator hikariConfigCreator = new HikariConfigCreator();
        final HikariConfig hikariConfig = hikariConfigCreator.createHikariConfig(pgOptions);
        return createDataSource(hikariConfig);
    }

    public DataSource createDataSource(final HikariConfig hikariConfig) {
        return new HikariDataSource(hikariConfig);
    }


}
