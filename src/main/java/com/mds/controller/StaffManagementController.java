package com.mds.controller;

import com.mds.database.model.Dept;
import com.mds.database.model.Emp;
import com.mds.service.StaffManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.StringWriter;
import java.text.DecimalFormat;


@Controller
@RequestMapping(value = "luna")
public class StaffManagementController {

    @Resource
    private StaffManagementService staffManagementService;

    @RequestMapping("{name}")
    public String greeting(@PathVariable("name") String name) {
        return "Hello, " + name;
    }


    @RequestMapping(value = "lunana", method = RequestMethod.POST)
    public String lunana(@RequestParam("weight") double weight,
                         @RequestParam("height") double height) {
        DecimalFormat df = new DecimalFormat("##.##");
        String s = df.format(weight / (height * height));
        System.err.println(); // ???
        return s;
    }

    @RequestMapping(value = "lu", method = RequestMethod.POST)
    public ModelAndView lu(@ModelAttribute("ACCOUNT_NO") String accountNo,
                           @ModelAttribute("PASSWORD") String passWord) {
        try {
            Emp emp = staffManagementService.signIn(accountNo, passWord);
            StringBuilder s = new StringBuilder();
            s.append(emp.getEMP_NAME()).append(emp.getACCOUNT_NO());

            System.out.println(s);
            if (emp.getAUTHORITY()<=1){
                return new ModelAndView("aa", "EMPName", emp);
            }else{
                return new ModelAndView("bb", "EMPName", emp);
            }


        } catch (Exception e) {
            // TODO 要拿掉 e.printStackTrace();
            e.printStackTrace();
            System.out.println("ERROR");
            return null;
        }
    }
}
