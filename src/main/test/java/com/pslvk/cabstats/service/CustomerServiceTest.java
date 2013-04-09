package com.pslvk.cabstats.service;

import com.pslvk.cabstats.model.Customer;
import com.pslvk.cabstats.model.Travel;
import com.pslvk.cabstats.repository.AllCustomers;
import com.pslvk.cabstats.request.CustomerRegistrationRequest;
import com.pslvk.cabstats.request.TravelDataRequest;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class CustomerServiceTest {

    @Mock
    private AllCustomers allCustomers;
    @Mock
    private Customer customer;

    @Before
    public void setUp() {
        initMocks(this);
    }

   /* @Test
    public void shouldSaveTravelForExistingCustomer() {

        CustomerService customerService = new CustomerService(allCustomers);
        long msisdn = 1;
        int amount = 100;
        int distance = 10;
        DateTime dateTime = DateTime.now();
        when(allCustomers.findByMsisdn(msisdn)).thenReturn(customer);
        Travel travel = new Travel(amount, distance, dateTime, customer);
        ArgumentCaptor<Travel> travelArgumentCaptor = ArgumentCaptor.forClass(Travel.class);

        CustomerRegistrationRequest customerRegistrationRequest = new CustomerRegistrationRequest("name", msisdn, "area", "street", 123456);

        customerService.registerTravelData(new TravelDataRequest(msisdn, distance, amount, dateTime, customerRegistrationRequest));

        verify(customer).addTravelDetails(travelArgumentCaptor.capture());
        Travel actualTravel = travelArgumentCaptor.getValue();

        assertEquals(travel, actualTravel);

    }

    @Test
    public void shouldCreateANewCustomerAndAddTravelDetails() {
        CustomerService customerService = new CustomerService(allCustomers);
        long msisdn = 1;
        int amount = 100;
        int distance = 10;
        DateTime dateTime = DateTime.now();
        when(allCustomers.findByMsisdn(msisdn)).thenReturn(null);
        Travel travel = new Travel(amount, distance, dateTime, customer);
        CustomerRegistrationRequest customerRegistrationRequest = new CustomerRegistrationRequest("name", msisdn, "area", "street", 123456);

        customerService.registerTravelData(new TravelDataRequest(msisdn, distance, amount, dateTime, customerRegistrationRequest));

        verify(customer).addTravelDetails(travel);
        verify(allCustomers).save(customer);

    }*/
}
