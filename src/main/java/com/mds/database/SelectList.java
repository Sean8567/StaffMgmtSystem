package com.mds.database;

import com.mds.database.model.Dept;
import java.sql.*;


public class SelectList {
    public static void main(String[] args) {
        String sql = "SELECT * FROM DEPT";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Sean", "sa", "1234");
             Statement statement = conn.createStatement()) {
            if(conn!=null){
                System.out.println("有連上資料庫");
            }else{
                System.out.println("沒有連上資料庫");
            }
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int deptNo = resultSet.getInt("DEPT_NO");
                String deptName = resultSet.getString("DEPT_NAME");
                String job = resultSet.getString("JOB");
                String deptPhone = resultSet.getString("DEPT_PHONE");

                //System.out.println("deptno"+deptNo+resultSet.getInt("DEPT_NO")+"deptname"+deptName+job+deptPhone);
                Dept obj = new Dept();
                obj.setDEPT_NO(deptNo);
                obj.setDEPT_NAME(deptName);
                obj.setJOB(job);
                obj.setDEPT_PHONE(deptPhone);
                System.out.println(obj.getList());
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
