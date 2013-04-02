package com.pslvk.cabstats.repository;

import com.pslvk.cabstats.model.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AllCustomers {

    private SessionFactory sessionFactory;

    @Autowired
    public AllCustomers(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Customer customer) {
    }
}
