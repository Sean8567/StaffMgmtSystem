package com.mds.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBProperties {
    public static final String SQL_SERVER_DB_CONNECTION = "jdbc:sqlserver://localhost:1433;DatabaseName=Sean";
    public static final String SQL_SERVER_USER = "sa";
    public static final String SQL_SERVER_PASSWORD = "1234";

    public static Connection getSQLServerConnection() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(SQL_SERVER_DB_CONNECTION, SQL_SERVER_USER, SQL_SERVER_PASSWORD);
            if (conn != null) {
                System.out.println("有連上資料庫");
            } else {
                System.out.println("沒有連上資料庫");
            }
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB Connection Error!!!");
            throw e;
        }
    }
}
