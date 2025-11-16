package org.pm.springjpamongodb.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.pm.springjpamongodb.dto.CustomerDto;
import org.pm.springjpamongodb.model.Customer;
import org.pm.springjpamongodb.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomer {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public String registerUser(CustomerDto customerDto) {
        Customer cx  = new Customer();
        BeanUtils.copyProperties(customerDto,cx);
        repository.save(cx);
        return "User Created Successfully";
    }

    @Override
    public List<Customer> findAllCustomer() {
        return  repository.findAll();
    }
}
