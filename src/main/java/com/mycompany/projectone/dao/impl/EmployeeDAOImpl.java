/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.EmployeeDAO;
import com.mycompany.projectone.entity.Employee;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public class EmployeeDAOImpl implements EmployeeDAO {
    
    private String createSQL = "INSERT INTO Employees(EmployeeID, Name, FirstName, Age, Email, PhoneNum, Address, Role) VALUES(?, ?, ?, ?, ?,? , ?, ?)";
    private String updateSQL = "UPDATE Employees SET EmployeeID = ? , Name = ?, FirstName = ?, Age = ?, Email = ?, PhoneNum = ?, Address = ?, Role = ?";
    private String deleteSQL = "delete FROM Employees WHERE EmployeeID = ? ";
    private String findAllSQL = "select * from Employees";
    private String findByIDSQL = "select * from Employees where EmployeeID = ?";

    @Override
    public Employee create(Employee entity) {
                    Object[] values = {
                        entity.getEmployeeID(),
                        entity.getName(),
                        entity.getFirstName(),
                        entity.getAge(),
                        entity.getEmail(),
                        entity.getAddress(),
                        entity.getRole(),
                          };
        XJdbc.executeUpdate(createSQL, values);
        return entity;
    }

    @Override
    public void update(Employee entity) {
        Object[] values = {
                        entity.getEmployeeID(),
                        entity.getName(),
                        entity.getFirstName(),
                        entity.getAge(),
                        entity.getEmail(),
                        entity.getAddress(),
                        entity.getRole(),
                          };
        XJdbc.executeUpdate(updateSQL, values);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteSQL, id);
    }

    @Override
    public List<Employee> findAll() {
        return XQuery.getBeanList(Employee.class, findAllSQL);
    }

    @Override
    public Employee findById(Integer id) {
        return XQuery.getSingleBean(Employee.class, findByIDSQL, id);
    }
    
}
