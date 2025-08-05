/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.EmployeeDAO;
import com.mycompany.projectone.entity.Employee;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Employee entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Employee> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Employee findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
