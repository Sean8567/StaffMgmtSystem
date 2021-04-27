package com.mds.controller;

import com.mds.database.model.Data;
import com.mds.database.model.Emp;
import com.mds.service.StaffManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;



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
            //StringBuilder s = new StringBuilder();
            //s.append(emp.getEMP_NAME()).append(emp.getACCOUNT_NO());
            //System.out.println(s);
            if (emp.getACCOUNT_NO() != null && emp.getAUTHORITY() <= 1) {
                return new ModelAndView("managerQuery", "Emp", emp);
            } else if (emp.getACCOUNT_NO() != null && emp.getAUTHORITY() > 1) {
                return new ModelAndView("query", "Emp", emp);
            } else {
                return new ModelAndView("loginFailed");
            }
        } catch (Exception e) {
            // TODO 要拿掉 e.printStackTrace();
            //e.printStackTrace();
            System.out.println("ERROR");
            return null;
        }
    }

    //查詢資料
    @RequestMapping(value = "manageInquiry", method = RequestMethod.POST)
    public ModelAndView manageInquiry(
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
            System.out.println("eno:"+eNo+"ename"+eName);
            Data data = staffManagementService.manageInquiry(eNo, eName, job, sex, idNo, phone, birthDate, entryDate, dNo, dName, dPhone);

            StringBuilder s = new StringBuilder();
            s.append(data.getEMP_NAME()).append(data.getJOB());
            System.out.println(s);
            return new ModelAndView("queryResult","Data",data);
        } catch (Exception e) {
            // TODO 要拿掉 e.printStackTrace();
            e.printStackTrace();
            System.out.println("ERROR");
            return null;
        }
    }

    //返回查詢
    @RequestMapping(value = "backQuery", method = RequestMethod.POST)
    public ModelAndView backQuery() {
        return new ModelAndView("managerQuery");
    }

    //按鈕跳轉新增資料頁面
    @RequestMapping(value = "addData", method = RequestMethod.POST)
    public ModelAndView addData() {
        return new ModelAndView("addData");
    }

    //按鈕跳轉修改資料頁面
    @RequestMapping(value = "editData", method = RequestMethod.POST)
    public ModelAndView editData() {
        return new ModelAndView("editData");
    }

    //按鈕跳轉刪除資料頁面
    @RequestMapping(value = "deleteData", method = RequestMethod.POST)
    public ModelAndView deleteData() {
        return new ModelAndView("deleteData");
    }


}
