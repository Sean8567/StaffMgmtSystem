package com.mds.controller;

import com.mds.database.model.Dept;
import com.mds.service.StaffManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;


@Controller
@RequestMapping(value = "luna")
public class StaffManagementController {
    @RequestMapping("/{name}")
    public String greeting(@PathVariable("name") String name) {
        return "Hello, " + name;
    }


    @RequestMapping(value = "lunana", method = RequestMethod.POST)
    public String lunana(@RequestParam("weight") double weight,
                         @RequestParam("height") double height) {
        DecimalFormat df = new DecimalFormat("##.##");
        String s = df.format(weight / (height * height));
        System.err.println();
        return s;
    }

    @ResponseBody
    @RequestMapping(value = "lu", method = RequestMethod.POST)
    public String lu(@RequestParam("DEPT_NO") Integer deptNo) {
        try {
            StaffManagementService staffManagementService = null;
            Dept dept = staffManagementService.selectList(deptNo);
            String s = dept.getList();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return "error! ";
        }
    }
}
