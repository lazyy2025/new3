package ru.x.core.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
//import ru.x.core.jdbc.datasource.sql.SqlQueryExecutor;
//import ru.x.core.jdbc.datasource.sql.SqlQueryExecutor;
import ru.x.core.jdbc.connection.ConnectionKey;
import ru.x.core.jdbc.connection.ConnectionManager;
import ru.x.core.jdbc.connection.sql.SqlQueryExecutor;
import ru.x.core.jdbc.connection.sql.queries.GetRowSqlQuery;
import ru.x.core.models.Dancer;
import ru.x.core.options.PgOptions;
//import ru.x.generated.jooq.tables.Testtable;
import ru.x.generated.swagger.model.v1.ResponseUser;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;



@Service
@RequiredArgsConstructor
@Slf4j
public class WhoamiService {

//    @Value("${pg.user}")
//    private String pguser;
    private static Map<String,String> newOptions;

    public final DancerService dancerService;

    public ResponseUser whoamI(String login){

        Dancer dance = dancerService.dancer();
        System.out.println(dance.name);


        ResponseUser responseUser = new ResponseUser();
        responseUser.setDisplayName("Me");
        responseUser.setLogin((login));
        log.info("Login with: " + login);

        newOptions = new HashMap<>();
        newOptions.put(".authority", "192.168.1.77:5432");
        newOptions.put(".dbname", "postgres");
        newOptions.put(".user", "postgres");

        PgOptions pgOptions = new PgOptions(newOptions);
        String user = pgOptions.getUser();
        String url = pgOptions.getUrl();
        log.info(user);
        log.info(url);
        try {
            RequestByConection(pgOptions);

            RequestByDslContext(pgOptions);

    

//            String sql1 ="SELECT * FROM testdb.testtable";
//            String sql2 = "SELECT * FROM testdb.testtable WHERE 1=0";




//            resultSet.first();
//            log.info(resultSet.getString("column1"));


//            GetTableSchemaSqlQuery.from("testdb.testtable");


//                log.info(format("11 %s",pgOptions.getUrl()));

//            sqlQueryExecutor.executeSqlQuery(pgOptions, GetTableSchemaSqlQuery.from("tableName"));


//                //------------old version
//                HikariConfig config = new HikariConfig();
//            //    String url = "jdbc:postgresql://localhost:5432/postgres";
//                log.info("Creating database connection for url: " + url);
//                config.setJdbcUrl(url);
//                config.setUsername(user);
//                config.setPassword("mysecretpassword");
//                config.addDataSourceProperty("cachePrepStmts" , "true");
//                config.addDataSourceProperty("prepStmtCacheSize" , "250");
//                config.addDataSourceProperty("prepStmtCacheSqlLimit" , "2048");
//                log.info("Connected to PG");
//
//
//                DSLContext dslContext = DSL.using(new HikariDataSource(config), SQLDialect.POSTGRES);


                //------------

            //    return new HikariDataSource(config);

//
//                conn.commit();
        } catch (Exception e) {
           log.info("error: "+e);
        }

        String newparmadd = "222222";

        responseUser.setDisplayName(format("menew %s", newparmadd));

        return responseUser;

    }

    private void RequestByDslContext(PgOptions pgOptions) throws SQLException {
        /**
         * DSLContext
         */
            DSLContext dslContext = null;
            dslContext = ConnectionManager
                    .getInstance()
                    .getDslContext(pgOptions);

//            String res2 = dslContext.select(Testtable.TESTTABLE.COLUMN1)
//                    .from(Testtable.TESTTABLE)
//                    .where(Testtable.TESTTABLE.ID.eq(2))
//                    .fetchOneInto(String.class);

//            log.info(res2);

    }

    private void RequestByConection(PgOptions pgOptions) throws SQLException {
        /**
         * Connection by sql query
         */
        Connection conn = null;
        conn = ConnectionManager
                .getInstance()
                .getConnection(pgOptions);
        SqlQueryExecutor sqlQueryExecutor = SqlQueryExecutor.getInstance();
        String res = sqlQueryExecutor.executeSqlQuery(conn, GetRowSqlQuery.from("schemax.testtable"));
        log.info(res);

    }

}
