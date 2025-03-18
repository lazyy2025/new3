package ru.x.core.jdbc.connection.sql.queries;

import lombok.extern.slf4j.Slf4j;
import ru.x.core.exception.SqlCoreException;
import ru.x.core.jdbc.connection.sql.SqlQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class GetRowSqlQuery extends SqlQuery<String> {
    static final String GET_ROW_SQL_QUERY_PATTERN = "SELECT * FROM %s";

    static final String SET_OPTIMIZER_OFF_SQL_STMT = "set optimizer = off";

    private GetRowSqlQuery(final String query) {
        super(query);
    }

    @Override
    protected void preprocessStmt(final Statement stmt) {
        try {
            stmt.execute(SET_OPTIMIZER_OFF_SQL_STMT);
        } catch (SQLException e) {
            throw new SqlCoreException(e);
        }
    }

    @Override
    protected String handleResult(ResultSet resultSet) throws SQLException {
        if (!resultSet.next()) {
            throw new SQLException("Error sql table");
        }
        resultSet.first();
        return resultSet.getString("column1");
    }

    public static GetRowSqlQuery from(final String tableName) {
        final String query = String.format(GET_ROW_SQL_QUERY_PATTERN, tableName);
        return new GetRowSqlQuery(query);
    }
}
