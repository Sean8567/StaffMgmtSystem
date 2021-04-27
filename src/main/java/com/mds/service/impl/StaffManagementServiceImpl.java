package com.mds.service.impl;

import com.mds.database.DBProperties;
import com.mds.database.model.Data;
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
        ResultSet resultSet = preparedStatement.executeQuery();
        Dept dept = new Dept();
        while (resultSet.next()) {
            int dno = resultSet.getInt("DEPT_NO");
            String dname = resultSet.getString("DEPT_NAME");
            String job = resultSet.getString("JOB");
            String dphone = resultSet.getString("DEPT_PHONE");

            dept.setDEPT_NO(dno);
            dept.setDEPT_NAME(dname);
            dept.setJOB(job);
            dept.setDEPT_PHONE(dphone);

        }
        conn.close();
        preparedStatement.close();
        return dept;
    }


    public Emp signIn(String accountNo, String passWord) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "select * from EMP where ACCOUNT_NO = '" + accountNo + "' and PASSWORD ='" + passWord + "'";
        PreparedStatement preparedStatement;
        Connection conn = DBProperties.getSQLServerConnection();
        preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        Emp emp = new Emp();

        while (resultSet.next()) {
            int eno = resultSet.getInt("EMP_NO");
            String ename = resultSet.getString("EMP_NAME");
            String idno = resultSet.getString("ID_NUMBER");
            String sex = resultSet.getString("SEX");
            String phone = resultSet.getString("PHONE");
            String job = resultSet.getString("JOB");
            String birthdate = resultSet.getString("BIRTH_DATE");
            String entrydate = resultSet.getString("ENTRY_DATE");
            String accountno = resultSet.getString("ACCOUNT_NO");
            String password = resultSet.getString("PASSWORD");
            int authority = resultSet.getInt("AUTHORITY");

            emp.setEMP_NO(eno);
            emp.setEMP_NAME(ename);
            emp.setID_NUMBER(idno);
            emp.setSEX(sex);
            emp.setPHONE(phone);
            emp.setJOB(job);
            emp.setBIRTH_DATE(birthdate);
            emp.setENTRY_DATE(entrydate);
            emp.setACCOUNT_NO(accountno);
            emp.setPASSWORD(password);
            emp.setAUTHORITY(authority);
            //System.out.println("empname："+emp.getEMP_NAME());
        }
        conn.close();
        preparedStatement.close();
        return emp;
    }


    public Data manageInquiry(String eNo, String eName, String Job, String Sex, String idNo, String Phone,
                              String birthDate, String entryDate, String dNo, String dName, String dPhone)
            throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "SELECT EMP_NO, EMP_NAME, ID_NUMBER, SEX, PHONE, E.JOB, BIRTH_DATE, ENTRY_DATE, " +
                "DEPT_NO,DEPT_NAME,DEPT_PHONE FROM EMP E,DEPT D WHERE E.JOB=D.JOB ";
        if (eNo.equals("") || eNo == null){ sql = sql + "AND EMP_NO LIKE \'%\' "; } else { sql = sql + "AND EMP_NO= \'" + eNo + "\' ";}
        if (dNo.equals("") || dNo == null){ sql = sql + "AND DEPT_NO LIKE \'%\' "; } else { sql = sql + "AND DEPT_NO= \'" + dNo + "\' ";}
        if (eName.equals("") || eName == null){ sql = sql + "AND EMP_NAME LIKE \'%\' "; }
            else { sql = sql + "AND EMP_NAME LIKE \'" + eName + "\' ";}
        if (Job.equals("") || Job == null){ sql = sql + "AND E.JOB LIKE \'%\' "; }
            else { sql = sql + "AND E.JOB LIKE \'" + Job + "\' ";}
        if (Sex.equals("") || Sex == null){ sql = sql + "AND SEX LIKE \'%\' "; }
            else { sql = sql + "AND SEX LIKE \'" + Sex + "\' ";}
        if (idNo.equals("") || idNo == null){ sql = sql + "AND ID_NUMBER LIKE \'%\' "; }
            else { sql = sql + "AND ID_NUMBER LIKE \'" + idNo + "\' ";}
        if (Phone.equals("") || Phone==null){ sql = sql + "AND PHONE LIKE \'%\' "; }
            else { sql = sql + "AND PHONE LIKE \'" + Phone + "\' ";}
        if (birthDate.equals("") || birthDate==null){ sql = sql + "AND BIRTH_DATE LIKE \'%\' "; }
            else { sql = sql + "AND BIRTH_DATE = \'" + birthDate + "\' ";}
        if (entryDate.equals("") || entryDate==null){ sql = sql + "AND ENTRY_DATE LIKE \'%\' "; }
            else { sql = sql + "AND ENTRY_DATE = \'" + entryDate + "\' ";}
        if (dName.equals("") || dName==null){ sql = sql + "AND DEPT_NAME LIKE \'%\' "; }
            else { sql = sql + "AND DEPT_NAME LIKE \'" + dName + "\' ";}
        if (dPhone.equals("") || dPhone==null){ sql = sql + "AND DEPT_PHONE LIKE \'%\' "; }
            else { sql = sql + "AND DEPT_PHONE LIKE \'" + dPhone + "\' ";}

        System.out.println(sql);
        PreparedStatement preparedStatement;
        Connection conn = DBProperties.getSQLServerConnection();
        preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        Data data = new Data();

        while (resultSet.next()) {
            String eno = resultSet.getString("EMP_NO");
            String ename = resultSet.getString("EMP_NAME");
            String idno = resultSet.getString("ID_NUMBER");
            String sex = resultSet.getString("SEX");
            String phone = resultSet.getString("PHONE");
            String job = resultSet.getString("JOB");
            String birthdate = resultSet.getString("BIRTH_DATE");
            String entrydate = resultSet.getString("ENTRY_DATE");
            //String accountno = resultSet.getString("ACCOUNT_NO");
            //String password = resultSet.getString("PASSWORD");
            //int authority = resultSet.getInt("AUTHORITY");

            String dno = resultSet.getString("DEPT_NO");
            String dname = resultSet.getString("DEPT_NAME");
            String dphone = resultSet.getString("DEPT_PHONE");

            data.setEMP_NO(eno);
            data.setEMP_NAME(ename);
            data.setID_NUMBER(idno);
            data.setSEX(sex);
            data.setPHONE(phone);
            data.setJOB(job);
            data.setBIRTH_DATE(birthdate);
            data.setENTRY_DATE(entrydate);
            //data.setACCOUNT_NO(accountno);
            //data.setPASSWORD(password);
            //data.setAUTHORITY(authority);

            data.setDEPT_NO(dno);
            data.setDEPT_NAME(dname);
            data.setDEPT_PHONE(dphone);
            System.out.println(data.getEMP_NO()+"empname："+data.getEMP_NAME());
        }
        conn.close();
        preparedStatement.close();

        return data;
    }
}
