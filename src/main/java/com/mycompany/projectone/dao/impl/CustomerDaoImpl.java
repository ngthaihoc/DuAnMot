package com.mycompany.projectone.dao.impl;


import com.mycompany.projectone.dao.CustomerDao;
import com.mycompany.projectone.entity.Customer;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    private String createSql = "INSERT INTO Customers(CustomerId, FirstName, Age,sex, EmailNum, Phone, Address) VALUES(?,?, ?, ?, ?, ?, ?)";
    private  String updateSql = "UPDATE Customers SET FirstName=?, Age=?, Sex = ?, EmailNum=?, Phone=?, Address=? WHERE CustomerId=?";
    private  String deleteByIdSql = "DELETE FROM Customers WHERE CustomerId=?";
    private  String findAllSql = "SELECT * FROM Customers";
    private  String findByIdSql = findAllSql + " WHERE CustomerId=?";

    @Override
    public Customer create(Customer entity) {
        Object[] values = {
            entity.getCustomerID(),
            entity.getFirstName(),
            entity.getAge(),
            entity.getSex(),
            entity.getEmailNum(),
            entity.getPhone(),
            entity.getAddress()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Customer entity) {
        Object[] values = {
            entity.getFirstName(),
            entity.getAge(),
            entity.getSex(),
            entity.getEmailNum(),
            entity.getPhone(),
            entity.getAddress(),
            entity.getCustomerID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<Customer> findAll() {   
        return XQuery.getBeanList(Customer.class, findAllSql);
    }

    @Override
    public Customer findById(String id) {
        return XQuery.getSingleBean(Customer.class, findByIdSql, id);
    }

}
