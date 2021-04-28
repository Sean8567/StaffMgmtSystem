package com.mds.service.impl;

import com.mds.database.DBProperties;
import com.mds.database.model.Emp;
import com.mds.service.StaffManagementService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class StaffManagementServiceImpl implements StaffManagementService {
    //登入驗證
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

        }
        conn.close();
        preparedStatement.close();
        return emp;
    }

    //查詢資料
    public List<Map> inQuiry(String eNo, String eName, String Job, String Sex, String idNo, String Phone,
                             String birthDate, String entryDate, String dNo, String dName, String dPhone)
            throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        String sql = "SELECT EMP_NO, EMP_NAME, ID_NUMBER, SEX, PHONE, E.JOB, BIRTH_DATE, ENTRY_DATE, " +
                "DEPT_NO,DEPT_NAME,DEPT_PHONE FROM EMP E,DEPT D WHERE E.JOB=D.JOB ";
        if (eNo.equals("") || eNo == null) {
            sql = sql + "AND EMP_NO LIKE \'%\' ";
        } else {
            sql = sql + "AND EMP_NO= \'" + eNo + "\' ";
        }
        if (dNo.equals("") || dNo == null) {
            sql = sql + "AND DEPT_NO LIKE \'%\' ";
        } else {
            sql = sql + "AND DEPT_NO= \'" + dNo + "\' ";
        }
        if (eName.equals("") || eName == null) {
            sql = sql + "AND EMP_NAME LIKE \'%\' ";
        } else {
            sql = sql + "AND EMP_NAME LIKE \'" + eName + "\' ";
        }
        if (Job.equals("") || Job == null) {
            sql = sql + "AND E.JOB LIKE \'%\' ";
        } else {
            sql = sql + "AND E.JOB LIKE \'" + Job + "\' ";
        }
        if (Sex.equals("") || Sex == null) {
            sql = sql + "AND SEX LIKE \'%\' ";
        } else {
            sql = sql + "AND SEX LIKE \'" + Sex + "\' ";
        }
        if (idNo.equals("") || idNo == null) {
            sql = sql + "AND ID_NUMBER LIKE \'%\' ";
        } else {
            sql = sql + "AND ID_NUMBER LIKE \'" + idNo + "\' ";
        }
        if (Phone.equals("") || Phone == null) {
            sql = sql + "AND PHONE LIKE \'%\' ";
        } else {
            sql = sql + "AND PHONE LIKE \'" + Phone + "\' ";
        }
        if (birthDate.equals("") || birthDate == null) {
            sql = sql + "AND BIRTH_DATE LIKE \'%\' ";
        } else {
            sql = sql + "AND BIRTH_DATE = \'" + birthDate + "\' ";
        }
        if (entryDate.equals("") || entryDate == null) {
            sql = sql + "AND ENTRY_DATE LIKE \'%\' ";
        } else {
            sql = sql + "AND ENTRY_DATE = \'" + entryDate + "\' ";
        }
        if (dName.equals("") || dName == null) {
            sql = sql + "AND DEPT_NAME LIKE \'%\' ";
        } else {
            sql = sql + "AND DEPT_NAME LIKE \'" + dName + "\' ";
        }
        if (dPhone.equals("") || dPhone == null) {
            sql = sql + "AND DEPT_PHONE LIKE \'%\' ";
        } else {
            sql = sql + "AND DEPT_PHONE LIKE \'" + dPhone + "\' ";
        }

        System.out.println(sql);
        PreparedStatement preparedStatement;
        Connection conn = DBProperties.getSQLServerConnection();
        preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Map> result = new ArrayList<Map>();

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
            //String authority = resultSet.getInt("AUTHORITY");

            String dno = resultSet.getString("DEPT_NO");
            String dname = resultSet.getString("DEPT_NAME");
            String dphone = resultSet.getString("DEPT_PHONE");

            Map map = new HashMap();
            map.put(1, eno);
            map.put(2, ename);
            map.put(3, idno);
            map.put(4, sex);
            map.put(5, phone);
            map.put(6, job);
            map.put(7, birthdate);
            map.put(8, entrydate);
            map.put(9, dno);
            map.put(10, dname);
            map.put(11, dphone);


            result.add(map);
            for (Map map1 : result) {
                System.out.println(map1);
            }


        }
        conn.close();
        preparedStatement.close();

        return result;
    }

    //新增資料
    public void addData(String eName, String job, String sex, String idNo, String phone, String birthDate,
                        String entryDate, String accountNo, String password, String authority)
            throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        String sqlInsert = "INSERT INTO EMP(EMP_NAME, ID_NUMBER, SEX, PHONE, JOB, BIRTH_DATE, ENTRY_DATE, ACCOUNT_NO,PASSWORD,AUTHORITY) " +
                "VALUES ( ";
        if (eName.equals("") || eName == null) {
            sqlInsert = sqlInsert + " \'\' ";
        } else {
            sqlInsert = sqlInsert + "\'" + eName + "\' ";
        }
        if (idNo.equals("") || idNo == null) {
            sqlInsert = sqlInsert + ", \'\' ";
        } else {
            sqlInsert = sqlInsert + ", \'" + idNo + "\' ";
        }
        if (sex.equals("") || sex == null) {
            sqlInsert = sqlInsert + ", \'\' ";
        } else {
            sqlInsert = sqlInsert + ", \'" + sex + "\' ";
        }
        if (phone.equals("") || phone == null) {
            sqlInsert = sqlInsert + ", \'\' ";
        } else {
            sqlInsert = sqlInsert + ", \'" + phone + "\' ";
        }
        if (job.equals("") || job == null) {
            sqlInsert = sqlInsert + ", \'\' ";
        } else {
            sqlInsert = sqlInsert + ", \'" + job + "\' ";
        }
        if (birthDate.equals("") || birthDate == null) {
            sqlInsert = sqlInsert + ", \'\' ";
        } else {
            sqlInsert = sqlInsert + ", \'" + birthDate + "\' ";
        }
        if (entryDate.equals("") || entryDate == null) {
            sqlInsert = sqlInsert + ", \'\' ";
        } else {
            sqlInsert = sqlInsert + ", \'" + entryDate + "\' ";
        }
        if (accountNo.equals("") || accountNo == null) {
            sqlInsert = sqlInsert + ", \'\' ";
        } else {
            sqlInsert = sqlInsert + ", \'" + accountNo + "\' ";
        }
        if (password.equals("") || password == null) {
            sqlInsert = sqlInsert + ", \'\' ";
        } else {
            sqlInsert = sqlInsert + ", \'" + password + "\' ";
        }
        if (authority.equals("") || authority == null) {
            sqlInsert = sqlInsert + ", \'\' ";
        } else {
            sqlInsert = sqlInsert + ", \'" + authority + "\' ";
        }
        sqlInsert += " ) ;";
        System.out.println(sqlInsert);

        PreparedStatement preparedStatement;

        Connection conn = DBProperties.getSQLServerConnection();
        preparedStatement = conn.prepareStatement(sqlInsert);
        preparedStatement.executeUpdate();




        conn.close();
        preparedStatement.close();

        return;
    }

    //修改資料
    public void editData(String eNo, String eName, String job, String sex, String idNo, String phone, String birthDate, String entryDate, String accountNo, String password, String authority)
            throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sqledit = "UPDATE EMP ";

        if (eName.equals("") || eName == null) { sqledit+=" SET " ;} else { sqledit = sqledit + "SET EMP_NAME= \'" + eName + "\'  ";}
        if (idNo.equals("") || idNo == null) { } else { sqledit += ", ID_NUMBER= \'" + idNo + "\'  ";}
        if (sex.equals("") || sex == null) { } else { sqledit += ", SEX= \'" + sex + "\'  ";}
        if (phone.equals("") || phone == null) { } else { sqledit += ", PHONE= \'" + phone + "\'  ";}
        if (job.equals("") || job == null) { } else { sqledit += ", JOB= \'" + job + "\'  ";}
        if (birthDate.equals("") || birthDate == null) { } else { sqledit +=  ", BIRTH_DATE= \'" + birthDate + "\'  ";}
        if (entryDate.equals("") || entryDate == null) { } else { sqledit +=  ", ENTRY_DATE= \'" + entryDate + "\'  ";}
        if (accountNo.equals("") || accountNo == null) { } else { sqledit +=  ", ACCOUNT_NO= \'" + accountNo + "\'  ";}
        if (password.equals("") || password == null) { } else { sqledit +=  ", PASSWORD= \'" + password + "\'  ";}
        if (authority.equals("") || authority == null) { } else { sqledit +=  ", AUTHORITY \'" + authority + "\'  ";}
        sqledit += " WHERE EMP_NO= \'"+eNo+" \' " ;
        System.out.println(sqledit);

        PreparedStatement preparedStatement;
        Connection conn = DBProperties.getSQLServerConnection();
        preparedStatement = conn.prepareStatement(sqledit);
        preparedStatement.executeUpdate();

        conn.close();
        preparedStatement.close();

        return;
    }

    //刪除資料
    public void deleteData(String eNo) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sqldelete = "DELETE FROM EMP WHERE EMP_NO= ";
        if (eNo.equals("") || eNo == null) {
        } else {
            sqldelete+="\'"+eNo+"\' ";
        }
        PreparedStatement preparedStatement;
        Connection conn = DBProperties.getSQLServerConnection();
        preparedStatement = conn.prepareStatement(sqldelete);
        preparedStatement.executeUpdate();

        conn.close();
        preparedStatement.close();

        return;
    }


}



