package com.tsel;

import com.tsel.data.Customer;
import com.tsel.repository.impl.CustomerRepository;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class App {

    private static final CustomerRepository customerRepository = new CustomerRepository();

    public static void main(String[] args) {
//        System.out.println(customerRepository.count());

//        Customer newCustomer = new Customer();
//        newCustomer.setId(2);
//        newCustomer.setFullName("Anton Tsel");
//        newCustomer.setAddress("Toggliaty");
//        newCustomer.setPhone("89063372375");
//        newCustomer.setRegistrationDate(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));

//        customerRepository.save(newCustomer);
        System.out.println("Count: " + customerRepository.count());
        System.out.println("Find by id = 1: " + customerRepository.findOne(1));
        System.out.println("Find all:" + customerRepository.findAll());
    }
}
