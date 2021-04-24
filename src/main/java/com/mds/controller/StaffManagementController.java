package com.mds.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class StaffManagementController {
  @RequestMapping("/{name}")
  public String greeting(@PathVariable("name") String name) {
    return "Hello, " + name;
  }
}
