package org.pm.springjdbc.dao;

import org.pm.springjdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository("dao")
public class EmployeeDaoImpl implements IEmployeeDao {
    private static final String SQL_QUERY = "select * from employee";
    List<Employee> list =  null;
    @Autowired
    private DataSource dataSource;



    @Override
    public List<Employee> getEmployeeInfo() {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
            ResultSet res = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (res.next()){
                Employee emp = new Employee();
                emp.setId(res.getInt(1));
                emp.setName(res.getString(2));
                emp.setCity(res.getString(3));
                emp.setSalary(res.getInt(4));
                list.add(emp);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return list;
    }
}
