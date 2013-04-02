package com.pslvk.cabstats.mapper;

import com.pslvk.cabstats.model.Customer;
import com.pslvk.cabstats.request.CustomerRegistrationRequest;

public class CustomerRegistrationMapper {

    public static Customer map(CustomerRegistrationRequest customerRegistrationRequest) {
        return new Customer(customerRegistrationRequest.getName(), customerRegistrationRequest.getMsisdn(), customerRegistrationRequest.getStreet(), customerRegistrationRequest.getArea(), customerRegistrationRequest.getPincode());
    }
}
