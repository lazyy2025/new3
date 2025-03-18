package ru.x.core.jdbc.connection;

import lombok.Value;
import ru.x.core.options.PgOptions;

import javax.sql.DataSource;

/**
 * Unique key used by {@link ConnectionManager} to reuse {@link DataSource} of the equivalent jdbc connection.
 *
 * @see ConnectionManager
 * @see DataSource
 */

@Value
public class ConnectionKey {
    String url;
    String user;

    private ConnectionKey(final String url,
                          final String user) {
        this.url = url;
        this.user = user;
    }


    public static ConnectionKey from(final PgOptions pgOptions) {
        final String url = pgOptions.getUrl();
        final String user = pgOptions.getUser();
        return new ConnectionKey(url, user);
    }
}


