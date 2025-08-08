/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.AccountDAO;
import com.mycompany.projectone.entity.Account;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public class AccountDAOImpl implements AccountDAO {
    
    String createSQL = "INSERT INTO Accounts(AccountID, Username, Password, status, EmployeeID)VALUES(?, '?', '?', ?, ?);";
    String updateSQL = "Update Accounts SET AccountID = ?, Username = '?', Password = '?' , status = ? , EmployeeID = ?";
    String deleteSQL = "DELETE Accounts WHERE AccountID = ? ";
    String findAllSQL = "select * from Accounts";
    String findByIDAccount = "SELECT * from Accounts where AccountID = ? ";
    String findByEmpID = "SELECT * from Accounts where EmployeeID = ? ";

    @Override
    public Account create(Account entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Account entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Account> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Account findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
