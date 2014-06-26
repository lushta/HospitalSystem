package model.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static logger.HospitalLogger.LOGGER;

/**
 * Created by lushta on 07.06.14.
 */
public class ConnectionPool {
    private static DataSource pool;

    public static synchronized Connection getConnection() {
        if (pool == null) {
            try {
                Context initContext = new InitialContext();
                Context envContext  = (Context)initContext.lookup("java:/comp/env");
                pool = (DataSource)envContext.lookup("jdbc/DB");
            } catch (NamingException e) {
                LOGGER.error(e.getMessage());
            }
        }

        try {
            return pool.getConnection();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }


}
