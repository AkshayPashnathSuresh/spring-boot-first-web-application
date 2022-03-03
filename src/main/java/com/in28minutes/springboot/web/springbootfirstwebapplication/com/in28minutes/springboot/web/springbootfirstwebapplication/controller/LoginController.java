package com.in28minutes.springboot.web.springbootfirstwebapplication.com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import com.in28minutes.springboot.web.springbootfirstwebapplication.com.in28minutes.springboot.web.springbootfirstwebapplication.com.in28minutes.springboot.web.springbootfirstwebapplication.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(ModelMap modelMap) {
//        modelMap.put("name", name);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showWelcome(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {
        if(!loginService.validateUser(name, password))
            return "login";
        modelMap.put("name", name);
        modelMap.put("password", password);
        return "welcome";
    }
}
