package com.tsel.repository.impl;

import com.tsel.data.Customer;
import com.tsel.repository.AbstractCrudRepository;

public class CustomerRepository extends AbstractCrudRepository<Customer, Integer> {

    public CustomerRepository() {
        super(Customer.class);
    }
}
