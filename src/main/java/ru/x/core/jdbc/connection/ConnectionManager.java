package ru.x.core.jdbc.connection;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import ru.x.core.options.PgOptions;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.String.format;

@Slf4j
public class ConnectionManager {

    private final Map<ConnectionKey, DataSource> connectionKeyToDataSource;

    private final DataSourceCreator dataSourceCreator;

    ConnectionManager(final DataSourceCreator dataSourceCreator) {
        this.connectionKeyToDataSource = new ConcurrentHashMap<>();
        this.dataSourceCreator = dataSourceCreator;
    }

    public static ConnectionManager getInstance() {
        return ConnectionManagerHolder.INSTANCE;
    }

    private static class ConnectionManagerHolder {
          private static final ConnectionManager INSTANCE = new ConnectionManager(DataSourceCreator.getInstance());
   }

    public Connection getConnection(final PgOptions pgOptions) throws SQLException {
        return getConnection(pgOptions, true);
    }

    public Connection getConnection(final PgOptions pgOptions,
                                    final boolean autoCommit) throws SQLException {
        final ConnectionKey connectionKey = ConnectionKey.from(pgOptions);

        if (!connectionKeyToDataSource.containsKey(connectionKey)) {
            log.info(format("!connectionkey for user: %s",connectionKey.getUser()));
            final DataSource dataSource = dataSourceCreator.createDataSource(pgOptions);
            connectionKeyToDataSource.put(connectionKey, dataSource);
        }
        final DataSource dataSource = connectionKeyToDataSource.get(connectionKey);
        final Connection connection = dataSource.getConnection();
        connection.setAutoCommit(autoCommit);
        log.info(format("connectionkey for user: %s",connectionKey.getUser()));
        return connection;

    }

    public DSLContext getDslContext(final PgOptions pgOptions) throws SQLException {
        final ConnectionKey connectionKey = ConnectionKey.from(pgOptions);

        if (!connectionKeyToDataSource.containsKey(connectionKey)) {
            log.info(format("!connectionkey for user: %s",connectionKey.getUser()));
            final DataSource dataSource = dataSourceCreator.createDataSource(pgOptions);
            connectionKeyToDataSource.put(connectionKey, dataSource);
        }
        final DataSource dataSource = connectionKeyToDataSource.get(connectionKey);
        final DSLContext dslContext = DSL.using(dataSource, SQLDialect.POSTGRES);

        log.info(format("connectionkey for user: %s",connectionKey.getUser()));
        return dslContext;

    }

}
