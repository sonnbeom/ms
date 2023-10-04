package com.hypeboy.hypeBoard.connectionpool;

import lombok.extern.log4j.Log4j2;

import javax.sql.DataSource;
import java.sql.*;

@Log4j2
public class ConnectionPool {

    private final DataSource dataSource;

    public ConnectionPool(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
    public void close(Connection conn, PreparedStatement pr){
        try {
            pr.close();
            conn.close();
        }catch (Exception e){
            e.getMessage();
        }
    }
    public void redaClose(Connection conn, PreparedStatement pr, ResultSet re){
        try {
            re.close();
            pr.close();
            conn.close();
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void safeClose(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.error("Error closing ResultSet: " + e.getMessage());
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                log.error("Error closing Statement: " + e.getMessage());
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                log.error("Error closing Connection: " + e.getMessage());

            }
        }
    }
}
