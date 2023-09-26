package com.hypeboy.hypeBoard.connectionpool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
