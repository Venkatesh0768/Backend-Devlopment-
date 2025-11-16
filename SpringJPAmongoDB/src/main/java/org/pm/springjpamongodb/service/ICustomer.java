package org.pm.springjpamongodb.service;

import org.pm.springjpamongodb.dto.CustomerDto;
import org.pm.springjpamongodb.model.Customer;

import java.util.List;

public interface ICustomer {
    public String registerUser(CustomerDto customerDto);
    public List<Customer> findAllCustomer();
}
