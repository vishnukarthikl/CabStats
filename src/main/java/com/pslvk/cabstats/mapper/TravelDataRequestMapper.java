package com.pslvk.cabstats.mapper;

import com.pslvk.cabstats.model.Customer;
import com.pslvk.cabstats.model.Travel;
import com.pslvk.cabstats.request.TravelDataRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TravelDataRequestMapper {

    public static Travel map(TravelDataRequest travelDataRequest) throws ParseException {
        Date dateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm a").parse(travelDataRequest.getDate() + " " + travelDataRequest.getTime());
        Customer customer = null;
        if (travelDataRequest.getCustomerRegistrationRequest() != null) {
            customer = CustomerRegistrationMapper.map(travelDataRequest.getCustomerRegistrationRequest());
        }
        return new Travel(travelDataRequest.getAmount(),
                travelDataRequest.getDistance(),
                dateTime,
                customer);
    }
}
