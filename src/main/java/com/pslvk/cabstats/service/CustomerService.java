package com.pslvk.cabstats.service;

import com.pslvk.cabstats.mapper.CustomerRegistrationMapper;
import com.pslvk.cabstats.model.Customer;
import com.pslvk.cabstats.repository.AllCustomers;
import com.pslvk.cabstats.request.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private AllCustomers allCustomers;

    public void register(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = CustomerRegistrationMapper.map(customerRegistrationRequest);
        allCustomers.save(customer);
    }
}