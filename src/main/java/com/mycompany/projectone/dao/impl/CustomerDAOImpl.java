/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.CustomerDAO;
import com.mycompany.projectone.entity.Customer;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public class CustomerDAOImpl implements CustomerDAO  {
    String createSQL = "INSERT INTO Customers(CustomerID, FirstName, Age, EmailNum, Phone, Address)VALUES(?, N'?', ?, '?', '?', N'?');";
    String updateSQL = "UPDATE Customers  SET CustomerID = ? , FirstName = N'?' , Age = ? , EmailNum = '?' , Phone = ? , Address = N'?';";
    String deleteSQL = "DELETE Customers WHERE CustomerID = ? ;";
    String findAllSQL = "select * from Customers";
    String findByIDSQL = "SELECT * from Customers WHERE CustomerID = ? ;";        

    @Override
    public Customer create(Customer entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Customer entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Customer> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Customer findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
