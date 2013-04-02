package com.pslvk.cabstats.service;

import com.pslvk.cabstats.mapper.CustomerRegistrationMapper;
import com.pslvk.cabstats.model.Customer;
import com.pslvk.cabstats.repository.AllCustomers;
import com.pslvk.cabstats.request.CustomerRegistrationRequest;
import com.pslvk.cabstats.request.TravelDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private AllCustomers allCustomers;

    @Autowired
    public CustomerService(AllCustomers allCustomers) {
        this.allCustomers = allCustomers;
    }

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = CustomerRegistrationMapper.map(customerRegistrationRequest);
        allCustomers.save(customer);
    }

    public void registerTravelData(TravelDataRequest travelDataRequest) {
        //To change body of created methods use File | Settings | File Templates.
    }
}
