package com.pslvk.cabstats.repository;

import com.pslvk.cabstats.model.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AllCustomers extends HibernateTemplate {

    private SessionFactory sessionFactory;

    @Autowired
    public AllCustomers(SessionFactory sessionFactory) {
        super(sessionFactory);
        setAllowCreate(true);
    }

    public void save(Customer customer) {
        saveOrUpdate(customer);
    }
}
