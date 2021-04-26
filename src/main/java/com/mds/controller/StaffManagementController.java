package com.mds.controller;

import com.mds.database.model.Data;
import com.mds.database.model.Emp;
import com.mds.service.StaffManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.DecimalFormat;


@Controller
@RequestMapping(value = "Sean")
public class StaffManagementController {
    @Resource
    private StaffManagementService staffManagementService;

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

    @RequestMapping(value = "manageInquiry", method = RequestMethod.POST)
    public ModelAndView manageInquiry(
            @ModelAttribute("EMP_NO") int eNo,
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
            Data data = staffManagementService.manageInquiry(eNo, eName, job, sex, idNo, phone, birthDate, entryDate, dNo, dName, dPhone);
            //StringBuilder s = new StringBuilder();
            //s.append(emp.getEMP_NAME()).append(emp.getACCOUNT_NO());
            //System.out.println(s);
            if (data.getAUTHORITY() <= 1) {
                return new ModelAndView("queryResult", "Emp", data);
            } else {
                return new ModelAndView("/WEB-INF/query.jsp", "Emp", data);
            }
        } catch (Exception e) {
            // TODO 要拿掉 e.printStackTrace();
            //e.printStackTrace();
            System.out.println("ERROR");
            return null;
        }
    }

    @RequestMapping(value = "result", method = RequestMethod.POST)
    public Void result() {
        ModelAndView mv = new ModelAndView("managerQuery");
        return null;
    }

    @RequestMapping(value = "addData", method = RequestMethod.POST)
    public ModelAndView addData() {
        return new ModelAndView("addData");
    }

    @RequestMapping(value = "editData", method = RequestMethod.POST)
    public ModelAndView editData() {
        return new ModelAndView("editData");
    }

    @RequestMapping(value = "deleteData", method = RequestMethod.POST)
    public ModelAndView deleteData() {
        return new ModelAndView("deleteData");
    }


    @RequestMapping(value = "lunana", method = RequestMethod.POST)
    public String lunana(@RequestParam("weight") double weight,
                         @RequestParam("height") double height) {
        DecimalFormat df = new DecimalFormat("##.##");
        String s = df.format(weight / (height * height));
        return s;
    }


}
