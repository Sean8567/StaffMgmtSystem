package com.mds.service;

import com.mds.database.model.Dept;

import java.sql.SQLException;

public interface StaffManagementService {
    Dept selectList(Integer deptNo) throws SQLException;
}
