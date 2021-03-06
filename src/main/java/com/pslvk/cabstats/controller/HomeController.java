package com.pslvk.cabstats.controller;

import com.pslvk.cabstats.model.Customer;
import com.pslvk.cabstats.request.CustomerRegistrationRequest;
import com.pslvk.cabstats.request.TravelDataRequest;
import com.pslvk.cabstats.service.CustomerService;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@Controller
public class HomeController {

    public static final int SERVER_ERROR = 500;
    private CustomerService customerService;

    @Autowired
    public HomeController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = {"/", "/registerCustomer"})
    public String home() {
        return "/layouts/registerCustomer";
    }

    @RequestMapping(value = "/travelData")
    public String travelData() {
        return "/layouts/travelData";
    }

    @RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView register(@ModelAttribute("customer") CustomerRegistrationRequest customerRegistrationRequest) throws IOException {
        customerService.registerCustomer(customerRegistrationRequest);

        String successMessage = "Customer has been registered successfully";
        return new ModelAndView("layouts/registerCustomer").addObject("successMessage", successMessage);
    }

    @RequestMapping(value = "/enterTravelData", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView register(@ModelAttribute("travelData") TravelDataRequest travelDataRequest) throws IOException, ParseException {
        customerService.registerTravelData(travelDataRequest);

        String successMessage = "Travel Data has been entered successfully";
        return new ModelAndView("layouts/travelData").addObject("successMessage", successMessage);
    }

    @RequestMapping(value = "/getCustomer", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomer(@RequestParam String msisdn, HttpServletResponse httpServletResponse) {
        Customer customer = customerService.getDetails(NumberUtils.toLong(msisdn));
        if (customer == null) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
        return customer;

    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ModelAndView handleException(final Exception exception, HttpServletResponse response) throws IOException {
        response.setStatus(SERVER_ERROR);
        String errorMessage = "Snap!, An error has occurred";
        return new ModelAndView("layouts/error").addObject("errorMessage", errorMessage);
    }
}
