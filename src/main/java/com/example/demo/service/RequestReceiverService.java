package com.example.demo.service;

import com.example.demo.dao.jpa.Customer;
import com.example.demo.dao.jpa.CustomerRepository;
import com.example.demo.dao.jpa.Stats;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class RequestReceiverService {

    @Autowired
    private CustomerRepository customerRepository;

    public RequestReceiverService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        if (validate(customer)) {
            customerRepository.save(customer);
        } else {
            //log
        }
        return customer;
    }

    public boolean validate(Customer customer) {

        return false;
    }

    public Stats getlastHourStatistics(Customer customer, Date date) {
        return null;
    }
}


