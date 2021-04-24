package com.mds.service.impl;

import com.mds.database.DBProperties;
import com.mds.database.model.Dept;
import com.mds.service.StaffManagementService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffManagementServiceImpl implements StaffManagementService {
    public Dept selectList(Integer deptNo) throws SQLException {
        String sql = "SELECT * FROM DEPT WHERE DEPT_NO = ? ";
        PreparedStatement preparedStatement;
        Connection conn = DBProperties.getSQLServerConnection();
        preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setInt(1, deptNo);

        ResultSet resultSet = preparedStatement.executeQuery();

        Dept dept = new Dept();

        while (resultSet.next()) {
            int dno = resultSet.getInt("DEPT_NO");
            String deptName = resultSet.getString("DEPT_NAME");
            String job = resultSet.getString("JOB");
            String deptPhone = resultSet.getString("DEPT_PHONE");

            dept.setDEPT_NO(dno);
            dept.setDEPT_NAME(deptName);
            dept.setJOB(job);
            dept.setDEPT_PHONE(deptPhone);

        }

        return dept;
    }
}
