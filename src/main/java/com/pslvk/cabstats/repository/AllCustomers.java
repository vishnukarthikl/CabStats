package com.pslvk.cabstats.repository;

import com.pslvk.cabstats.model.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public Customer findByMsisdn(long msisdn) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        detachedCriteria.add(Restrictions.eq("msisdn", msisdn));
        List customers = findByCriteria(detachedCriteria);

        return customers.size() == 1 ? (Customer) customers.get(0) : null;
    }
}
