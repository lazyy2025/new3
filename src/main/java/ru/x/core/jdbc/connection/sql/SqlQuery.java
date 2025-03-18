package ru.x.core.jdbc.connection.sql;

import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public abstract class SqlQuery<T> {
    private final String query;

    protected SqlQuery(final String query) {
        this.query = query;
    }

    public final T execute(final Statement stmt) throws SQLException {
        log.info("Executing SQL query: {}", query);
//          preprocessStmt(stmt);
        return execute(stmt, query);
    }

    protected T execute(final Statement stmt,
                        final String query) throws SQLException {
        final ResultSet resultSet = stmt.executeQuery(query);
       return handleResult(resultSet);
    }

    protected void preprocessStmt(final Statement stmt) {
        // do nothing
    }

    protected abstract T handleResult(ResultSet resultSet) throws SQLException;

}
