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
 * @author pc
 */
public class EmployeeManagerDAOImpl implements EmployeeDAO{
    private final String createSql = "INSERT INTO Employees (EmployeeID, Name, FirstName, Age, sex, Email, PhoneNum, Address, Role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE Employees SET Name=?, FirstName=?, Age=?, sex=?, Email=?, PhoneNum=?, Address=?, Role=? WHERE EmployeeID=?";
    private final String deleteByIdSql = "DELETE FROM Employees WHERE EmployeeID=?";
    private final String findAllSql = "SELECT * FROM Employees";
    private final String findByIdSql = findAllSql + " WHERE EmployeeID=?";

    @Override
    public Employee create(Employee entity) {
        Object[] values = {
            entity.getEmployeeID(),
            entity.getName(),
            entity.getFirstName(),
            entity.getAge(),
            entity.isSex(),           
            entity.getEmail(),
            entity.getPhoneNum(),
            entity.getAddress(),
            entity.getRole()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Employee entity) {
        Object[] values = {
            entity.getName(),
            entity.getFirstName(),
            entity.getAge(),
            entity.isSex(),           // đã thêm sex
            entity.getEmail(),
            entity.getPhoneNum(),
            entity.getAddress(),
            entity.getRole(),
            entity.getEmployeeID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Integer employeeID) {
        XJdbc.executeUpdate(deleteByIdSql, employeeID);
    }

    @Override
    public List<Employee> findAll() {
        return XQuery.getBeanList(Employee.class, findAllSql);
    }

    @Override
    public Employee findById(Integer employeeID) {
        return XQuery.getSingleBean(Employee.class, findByIdSql, employeeID);
    }

    @Override
    public void deletebyID(Integer entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Employee> findALl() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Employee FindByID(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
      
    

