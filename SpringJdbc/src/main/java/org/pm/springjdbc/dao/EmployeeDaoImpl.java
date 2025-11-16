package org.pm.springjdbc.dao;

import org.pm.springjdbc.model.Employee;

import java.util.List;

public class EmployeeDaoImpl extends IEmployeeDao{
    @Override
    public List<Employee> getEmployeeInfo() {
        try {

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return List.of();
    }
}
