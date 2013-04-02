package com.pslvk.cabstats.controller;

import com.pslvk.cabstats.request.CustomerRegistrationRequest;
import com.pslvk.cabstats.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class HomeController {


    private CustomerService customerService;

    @Autowired
    public HomeController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/")
    public String home() {
        return "/layouts/home";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public void register(@ModelAttribute("customer") CustomerRegistrationRequest customerRegistrationRequest) throws IOException {
        customerService.register(customerRegistrationRequest);
        return;
    }
}
