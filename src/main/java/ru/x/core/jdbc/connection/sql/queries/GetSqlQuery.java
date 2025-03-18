package ru.x.core.jdbc.connection.sql.queries;

import ru.x.core.jdbc.connection.sql.SqlQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetSqlQuery extends SqlQuery<String> {

    private GetSqlQuery(final String query) {
        super(query);
    }

    @Override
    protected String handleResult(ResultSet resultSet) throws SQLException {
        if (!resultSet.next()) {
            throw new SQLException("Error sql table");
        }
        resultSet.first();
        return resultSet.toString();
    }

    public static GetSqlQuery from(final String sqlQuerry) {
        return new GetSqlQuery(sqlQuerry);
    }
}
