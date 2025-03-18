package ru.x.core.jdbc.connection.sql;

import ru.x.core.exception.SqlCoreException;
import ru.x.core.jdbc.connection.ConnectionManager;
import ru.x.core.options.PgOptions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlQueryExecutor {

   private final ConnectionManager connectionManager;


    SqlQueryExecutor(final ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }


    public static SqlQueryExecutor getInstance() {
        return SqlQueryExecutorHolder.INSTANCE;
    }

    private static class SqlQueryExecutorHolder {
        private static final SqlQueryExecutor INSTANCE = new SqlQueryExecutor(ConnectionManager.getInstance());
    }

    public <T> T executeSqlQuery(final PgOptions pgOptions,
                                 final SqlQuery<T> sqlQuery) {
        try (final Connection conn = connectionManager.getConnection(pgOptions)) {
            return executeSqlQuery(conn, sqlQuery);
        } catch (SQLException e) {
            throw new SqlCoreException(e);
        }
    }
    public <T> T executeSqlQuery(final Connection conn,
                                 final SqlQuery<T> sqlQuery) {
       try (final Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
//      try (final Statement stmt = conn.createStatement()) {
           return sqlQuery.execute(stmt);
       } catch (SQLException e) {
           throw new SqlCoreException(e);
       }
}


}
