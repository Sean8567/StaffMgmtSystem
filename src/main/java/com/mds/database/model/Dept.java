package com.mds.database.model;

public class Dept {

    private int DEPT_NO;
    private String DEPT_NAME;
    private String JOB;
    private String DEPT_PHONE;


    public String getList() {
        return "DEPT_NO " + getDEPT_NO() + " ,DEPT_NAME " + getDEPT_NAME() + " ,JOB " + getJOB() + " ,DEPT_PHONE " + getDEPT_PHONE();
    }

    public int getDEPT_NO() {
        return DEPT_NO;
    }

    public void setDEPT_NO(int DEPT_NO) {
        this.DEPT_NO = DEPT_NO;
    }

    public String getDEPT_NAME() {
        return DEPT_NAME;
    }

    public void setDEPT_NAME(String DEPT_NAME) {
        this.DEPT_NAME = DEPT_NAME;
    }

    public String getJOB() {
        return JOB;
    }

    public void setJOB(String JOB) {
        this.JOB = JOB;
    }

    public String getDEPT_PHONE() {
        return DEPT_PHONE;
    }

    public void setDEPT_PHONE(String DEPT_PHONE) {
        this.DEPT_PHONE = DEPT_PHONE;
    }


}

