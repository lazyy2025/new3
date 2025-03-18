package ru.x.core.jdbc.connection.sql.queries;

import ru.x.core.jdbc.connection.sql.SqlQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetTableSchemaSqlQuery extends SqlQuery<String>
{

    static final String GET_TABLE_SCHEMA_SQL_QUERY_PATTERN = "SELECT * FROM %s WHERE 1=0";

    private GetTableSchemaSqlQuery(final String query) {
        super(query);
    }

    @Override
    protected String handleResult(ResultSet resultSet) throws SQLException {
        if (!resultSet.next()) {
            throw new SQLException("Error sql table");
        }
        return resultSet.toString();
    }

    public static GetTableSchemaSqlQuery from(final String tableName) {
        final String query = String.format(GET_TABLE_SCHEMA_SQL_QUERY_PATTERN, tableName);
        return new GetTableSchemaSqlQuery(query);
    }


}
