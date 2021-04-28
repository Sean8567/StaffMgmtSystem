package com.mds.service;

import com.mds.database.model.Emp;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface StaffManagementService {
    Emp signIn(String accountNo, String passWord) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    List<Map> inQuiry(String eNo, String eName, String job, String sex, String idNo, String phone, String birthDate, String entryDate, String dNo, String dName,
                      String dPhone) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    void addData(String eName, String job, String sex, String idNo, String phone, String birthDate, String entryDate, String accountNo, String password, String authority)
            throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    void editData(String eNo, String eName, String job, String sex, String idNo, String phone, String birthDate, String entryDate, String accountNo, String password, String authority)
            throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    void deleteData(String eNo) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
