package com.vitaly.crudjdbcapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
17-Dec-23
gh /crazym8nd
*/ // TODO connection sdelat singleton
public class JDBCUtil {

    private JDBCUtil() {
        throw new IllegalStateException("Utility class");
    }

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/crudapp";
    static final String USER = "root";
    static final String PASSWORD = "6663";

    public static Connection getConnnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}