package com.mds.controller;

import com.mds.database.model.Emp;
import com.mds.service.StaffManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "Sean")
public class StaffManagementController {
    @Resource
    private StaffManagementService staffManagementService;

    //登入驗證
    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public ModelAndView signIn(@ModelAttribute("ACCOUNT_NO") String accountNo,
                               @ModelAttribute("PASSWORD") String passWord) {
        try {
            Emp emp = staffManagementService.signIn(accountNo, passWord);
            if (emp.getACCOUNT_NO() != null && emp.getAUTHORITY() <= 1) {
                return new ModelAndView("managerQuery");
            } else if (emp.getACCOUNT_NO() != null && emp.getAUTHORITY() > 1) {
                return new ModelAndView("query");
            } else {
                return new ModelAndView("loginFailed");
            }
        } catch (Exception e) {
            System.out.println("ERROR");
            return null;
        }
    }

    //新增資料
    @RequestMapping(value = "addData", method = RequestMethod.POST)
    public ModelAndView addData(
            @ModelAttribute("EMP_NAME") String eName,
            @ModelAttribute("JOB") String job,
            @ModelAttribute("SEX") String sex,
            @ModelAttribute("ID_NUMBER") String idNo,
            @ModelAttribute("PHONE") String phone,
            @ModelAttribute("BIRTH_DATE") String birthDate,
            @ModelAttribute("ENTRY_DATE") String entryDate,
            @ModelAttribute("ACCOUNT_NO") String accountNo,
            @ModelAttribute("PASSWORD") String password,
            @ModelAttribute("AUTHORITY") String authority) {
        try {
            staffManagementService.addData(eName, job, sex, idNo, phone, birthDate, entryDate, accountNo, password, authority);
            return new ModelAndView("addDataResult");
        } catch (Exception e) {
            System.out.println("ERROR");
            return null;
        }
    }

    //修改資料
    @RequestMapping(value = "editData", method = RequestMethod.POST)
    public ModelAndView editData(
            @ModelAttribute("EMP_NO") String eNo,
            @ModelAttribute("EMP_NAME") String eName,
            @ModelAttribute("JOB") String job,
            @ModelAttribute("SEX") String sex,
            @ModelAttribute("ID_NUMBER") String idNo,
            @ModelAttribute("PHONE") String phone,
            @ModelAttribute("BIRTH_DATE") String birthDate,
            @ModelAttribute("ENTRY_DATE") String entryDate,
            @ModelAttribute("ACCOUNT_NO") String accountNo,
            @ModelAttribute("PASSWORD") String password,
            @ModelAttribute("AUTHORITY") String authority) {
        try {
            staffManagementService.editData(eNo, eName, job, sex, idNo, phone, birthDate, entryDate, accountNo, password, authority);
            return new ModelAndView("editDataResult");
        } catch (Exception e) {
            System.out.println("ERROR");
            return null;
        }
    }

    //刪除資料
    @RequestMapping(value = "deleteData", method = RequestMethod.POST)
    public ModelAndView deleteData(
            @ModelAttribute("EMP_NO") String eNo) {
        try {
            staffManagementService.deleteData(eNo);
            return new ModelAndView("deleteDataResult");
        } catch (Exception e) {
            System.out.println("ERROR");
            return null;
        }
    }

    //查詢資料
    @RequestMapping(value = "inQuiry", method = RequestMethod.POST)
    public ModelAndView inQuiry(
            @ModelAttribute("EMP_NO") String eNo,
            @ModelAttribute("EMP_NAME") String eName,
            @ModelAttribute("JOB") String job,
            @ModelAttribute("SEX") String sex,
            @ModelAttribute("ID_NUMBER") String idNo,
            @ModelAttribute("PHONE") String phone,
            @ModelAttribute("BIRTH_DATE") String birthDate,
            @ModelAttribute("ENTRY_DATE") String entryDate,
            @ModelAttribute("DEPT_NO") String dNo,
            @ModelAttribute("DEPT_NAME") String dName,
            @ModelAttribute("DEPT_PHONE") String dPhone) {
        try {
            List<Map> resultList = staffManagementService.inQuiry(eNo, eName, job, sex, idNo, phone, birthDate, entryDate, dNo, dName, dPhone);

            return new ModelAndView("queryResult", "resultList", resultList);
        } catch (Exception e) {
            System.out.println("ERROR");
            return null;
        }
    }

    //按鈕跳轉新增資料頁面
    @RequestMapping(value = "goToAdd", method = RequestMethod.POST)
    public ModelAndView goToAdd() {
        return new ModelAndView("addData");
    }

    //按鈕跳轉修改資料頁面
    @RequestMapping(value = "goToEdit", method = RequestMethod.POST)
    public ModelAndView goToEdit() {
        return new ModelAndView("editData");
    }

    //按鈕跳轉刪除資料頁面
    @RequestMapping(value = "goToDelete", method = RequestMethod.POST)
    public ModelAndView goToDelete() {
        return new ModelAndView("deleteData");
    }

    //按鈕跳轉查詢資料頁面
    @RequestMapping(value = "goToQuery", method = RequestMethod.POST)
    public ModelAndView goToQuery() {
        return new ModelAndView("managerQuery");
    }

}
