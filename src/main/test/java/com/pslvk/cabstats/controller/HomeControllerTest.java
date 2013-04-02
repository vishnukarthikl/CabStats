package com.pslvk.cabstats.controller;


import com.pslvk.cabstats.request.CustomerRegistrationRequest;
import com.pslvk.cabstats.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest {

    @Mock
    private CustomerService customerService;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void shouldSaveCustomersWhenRegistered() throws Exception {

        HomeController homeController = new HomeController(customerService);
        standaloneSetup(homeController).build().perform(post("/registerCustomer").body(new byte[0])).andExpect(status().isOk());

        verify(customerService).registerCustomer(any(CustomerRegistrationRequest.class));
    }
}
