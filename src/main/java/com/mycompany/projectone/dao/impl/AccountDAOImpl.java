/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.AccountDAO;
import com.mycompany.projectone.entity.Account;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public class AccountDAOImpl implements AccountDAO {
    
   String createSQL = "INSERT INTO Accounts(AccountID, Username, Password, status, EmployeeID) VALUES (?, ?, ?, ?, ?)";
    String updateSQL = "UPDATE Accounts SET Username = ?, Password = ?, status = ?, EmployeeID = ? WHERE AccountID = ?";
    String deleteSQL = "DELETE FROM Accounts WHERE AccountID = ?";
    String findAllSQL = "SELECT AccountID, Username, Password, status, EmployeeID FROM Accounts";
    String findByIDAccount = "SELECT AccountID, Username, Password, status, EmployeeID FROM Accounts WHERE AccountID = ?";

    @Override
    public Account create(Account entity) {
        Object[] value = {
            entity.getAccountID(),
            entity.getPassword(),
            entity.getUsername(),
            entity.getStatus(),
            entity.getEmployeeID()
        };
        XJdbc.executeUpdate(createSQL, value);
        return entity;
    }

    @Override
    public void update(Account entity) {
         Object[] value = {
            entity.getAccountID(),
            entity.getPassword(),
            entity.getUsername(),
            entity.getStatus(),
            entity.getEmployeeID()
        };
         XJdbc.executeUpdate(updateSQL, value);
    }

    @Override
    public void deleteById(Integer id) {
       XJdbc.executeUpdate(deleteSQL, id);
    }

    @Override
    public List<Account> findAll() {
        return XQuery.getBeanList(Account.class, findAllSQL);
    }

    @Override
    public Account findById(Integer id) {
        return XQuery.getSingleBean(Account.class, findByIDAccount, id);
    }
    
}
