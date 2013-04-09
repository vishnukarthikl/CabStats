package com.pslvk.cabstats.service;

import com.pslvk.cabstats.mapper.CustomerRegistrationMapper;
import com.pslvk.cabstats.mapper.TravelDataRequestMapper;
import com.pslvk.cabstats.model.Customer;
import com.pslvk.cabstats.model.Travel;
import com.pslvk.cabstats.repository.AllCustomers;
import com.pslvk.cabstats.request.CustomerRegistrationRequest;
import com.pslvk.cabstats.request.TravelDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

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

    public void registerTravelData(TravelDataRequest travelDataRequest) throws ParseException {
        Travel travel = TravelDataRequestMapper.map(travelDataRequest);
        Customer customerFromRequest = travel.getCustomer();
        Customer customerFromDb = allCustomers.findByMsisdn(customerFromRequest.getMsisdn());

        if (customerFromDb != null) {
            customerFromDb.update(customerFromRequest);
            travel.setCustomer(customerFromDb);
            customerFromDb.addTravelDetails(travel);
            allCustomers.save(customerFromDb);
        } else {
            customerFromRequest.addTravelDetails(travel);
            allCustomers.save(customerFromRequest);
        }
    }

    public Customer getDetails(long msisdn) {
        return allCustomers.findByMsisdn(msisdn);
    }
}
