package com.mds.service;

import com.mds.database.model.Dept;
import com.mds.database.model.Emp;

import java.sql.SQLException;

public interface StaffManagementService {
    Dept selectList(Integer deptNo) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    Emp signIn(String accountNo, String passWord) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

}
