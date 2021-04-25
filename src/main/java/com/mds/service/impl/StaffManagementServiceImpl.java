package com.mds.service.impl;

import com.mds.database.DBProperties;
import com.mds.database.model.Dept;
import com.mds.database.model.Emp;
import com.mds.service.StaffManagementService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class StaffManagementServiceImpl implements StaffManagementService {
    public Dept selectList(Integer deptNo) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
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
        conn.close();
        preparedStatement.close();
        return dept;
    }


    public Emp signIn(String accountNo, String passWord) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "select * from EMP where ACCOUNT_NO = '"+accountNo+"' and PASSWORD ='"+ passWord+"'";
        PreparedStatement preparedStatement;
        Connection conn = DBProperties.getSQLServerConnection();
        preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        Emp emp = new Emp();

        while (resultSet.next()) {
            int eno=resultSet.getInt("EMP_NO");
            String ename =resultSet.getString("EMP_NAME");
            String idno=resultSet.getString("ID_NUMBER");
            String gender=resultSet.getString("GENDER");
            String phone=resultSet.getString("PHONE");
            String job=resultSet.getString("JOB");
            String birthdate=resultSet.getString("BIRTH_DATE");
            String entrydate=resultSet.getString("ENTRY_DATE");
            String accountno=resultSet.getString("ACCOUNT_NO");
            String password=resultSet.getString("PASSWORD");
            int authority=resultSet.getInt("AUTHORITY");

            emp.setEMP_NO(eno);
            emp.setEMP_NAME(ename);
            emp.setID_NUMBER(idno);
            emp.setGENDER(gender);
            emp.setPHONE(phone);
            emp.setJOB(job);
            emp.setBIRTH_DATE(birthdate);
            emp.setENTRY_DATE(entrydate);
            emp.setACCOUNT_NO(accountno);
            emp.setPASSWORD(password);
            emp.setAUTHORITY(authority);
            System.out.println("empname："+emp.getEMP_NAME());
        }
        conn.close();
        preparedStatement.close();
        return emp;
    }
}
