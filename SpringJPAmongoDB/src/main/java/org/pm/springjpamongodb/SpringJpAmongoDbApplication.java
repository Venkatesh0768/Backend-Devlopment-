package org.pm.springjpamongodb;

import org.pm.springjpamongodb.dto.CustomerDto;
import org.pm.springjpamongodb.model.Customer;
import org.pm.springjpamongodb.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJpAmongoDbApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext container = SpringApplication.run(SpringJpAmongoDbApplication.class, args);
        CustomerService service = container.getBean(CustomerService.class);
        service.registerUser(new CustomerDto("Rahul" , "Surat" , 200));
        List<Customer> list  =service.findAllCustomer();
        System.out.println(list);


    }

}
