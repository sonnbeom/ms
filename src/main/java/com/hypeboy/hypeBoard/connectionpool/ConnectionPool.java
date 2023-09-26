package com.hypeboy.hypeBoard.connectionpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionPool {
    @Autowired
    private static ConnectionPool instance;
    @Autowired
    private final DataSource dataSource;

    public ConnectionPool(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool(DataSourceBuilder.create().build());
        }
        return instance;
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
