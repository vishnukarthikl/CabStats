package com.pslvk.cabstats.mapper;

import com.pslvk.cabstats.model.Customer;
import com.pslvk.cabstats.model.Travel;
import com.pslvk.cabstats.request.CustomerRegistrationRequest;
import com.pslvk.cabstats.request.TravelDataRequest;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

public class TravelDataRequestMapperTest {

    @Test
    public void shouldMapFromOnlyTravelData() {
        Date now = new Date();
        TravelDataRequest travelDataRequest = new TravelDataRequest(1, 10, 200, date, time, new CustomerRegistrationRequest("name", 1, "area", "street", 12));
        Customer customer = new Customer("name", 1, "street", "area", 12);
        Travel travel = TravelDataRequestMapper.map(travelDataRequest);

        assertEquals(1, travel.getCustomer().getMsisdn());
        assertEquals(200, travel.getAmount());
        assertEquals(10.0, travel.getDistance());
        assertEquals(now, travel.getDateTime());
        assertEquals(customer, travel.getCustomer());
    }
}
