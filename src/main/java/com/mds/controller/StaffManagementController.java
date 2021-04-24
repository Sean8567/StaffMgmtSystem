package com.mds.controller;

import com.mds.database.model.Dept;
import com.mds.service.StaffManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DecimalFormat;


@Controller
@RequestMapping(value = "luna")
public class StaffManagementController {

    @Resource
    private StaffManagementService staffManagementService ;

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

    @ResponseBody
    @RequestMapping(value = "lu", method = RequestMethod.POST)
    public String lu(@RequestParam("DEPT_NO") Integer deptNo) {
        try {
            Dept dept = staffManagementService.selectList(deptNo);
            return dept.getList();
        } catch (Exception e) {
            // TODO 要拿掉 e.printStackTrace();
            e.printStackTrace();
            return "error! ";
        }
    }
}
