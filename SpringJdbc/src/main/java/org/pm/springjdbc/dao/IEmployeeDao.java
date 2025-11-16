package org.pm.springjdbc.dao;

import org.pm.springjdbc.model.Employee;

import java.util.List;

public interface IEmployeeDao {
    List<Employee> getEmployeeInfo();
}
