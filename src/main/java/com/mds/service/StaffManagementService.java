package com.mds.service;

import com.mds.database.model.Data;
import com.mds.database.model.Dept;
import com.mds.database.model.Emp;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.sql.SQLException;

public interface StaffManagementService {
    Dept selectList(Integer deptNo) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    Emp signIn(String accountNo, String passWord) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    Data manageInquiry (int eNo,String eName,String job,String sex,String idNo,String phone,String birthDate,String entryDate,String dNo,String dName,
                        String dPhone) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
