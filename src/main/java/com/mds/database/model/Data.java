package com.mds.database.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {
    //EMP
    private int EMP_NO;
    private String EMP_NAME;
    private String ID_NUMBER;
    private String SEX;
    private String PHONE;
    private String JOB;
    private String BIRTH_DATE;
    private String ENTRY_DATE;
    private String ACCOUNT_NO;
    private String PASSWORD;
    private int AUTHORITY;
    //DEPT
    private int DEPT_NO;
    private String DEPT_NAME;
    private String DEPT_PHONE;

}
