package org.pm.springjdbc;

import org.pm.springjdbc.dao.EmployeeDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext connection = SpringApplication.run(SpringJdbcApplication.class, args);
        EmployeeDaoImpl employeeDao = connection.getBean(EmployeeDaoImpl.class);
        employeeDao.getEmployeeInfo().forEach(ele -> System.out.println(ele.getId() + " " + ele.getName()));
    }

}
