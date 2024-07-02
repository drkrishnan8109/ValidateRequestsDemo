package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.model.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
            System.out.println("Saving valid Customer");
            customerRepository.save(customer);
        } else {
            //log
            System.out.println("Invalid Customer");
        }
        return customer;
    }

    public boolean validate(Customer customer) {

        return true;
    }

    public Stats getlastHourStatistics(Customer customer, Date date) {
        return null;
    }

    public Customer getCustomerById(@PathVariable Integer customerId) {
        Customer customer = customerRepository.findCustomerBycustomerId(customerId);
        if(customer==null) throw new RuntimeException("Customer not found");
        return customer;
    }
}


