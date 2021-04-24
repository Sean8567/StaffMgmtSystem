package com.mds.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    public static void main(String[] args) {
        try(Connection conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Sean","sa","1234")) {
            if(conn!=null){
                System.out.println("有連上資料庫");
            }else{
                System.out.println("沒有連上資料庫");
            }
        }catch (SQLException e){
            System.err.format("SQL State: %s\n%s",e.getSQLState(),e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
