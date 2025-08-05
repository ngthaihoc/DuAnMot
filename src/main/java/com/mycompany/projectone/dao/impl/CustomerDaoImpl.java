package com.mycompany.projectone.dao.impl;


import com.mycompany.projectone.dao.CustomerDao;
import com.mycompany.projectone.entity.Customer;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    private final String createSql = "INSERT INTO Customers(CustomerId, FirstName, Age, EmailNum, Phone, Address) VALUES(?, ?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE Customers SET FirstName=?, Age=?, EmailNum=?, Phone=?, Address=? WHERE CustomerId=?";
    private final String deleteByIdSql = "DELETE FROM Customers WHERE CustomerId=?";
    
    private final String findAllSql = "SELECT * FROM Customers";
    private final String findByIdSql = findAllSql + " WHERE CustomerId=?";

    @Override
    public Customer create(Customer entity) {
        Object[] values = {
            entity.getCustomerID(),
            entity.getFirstName(),
            entity.getAge(),
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

    @Override
    public List<Customer> findByKeyword(String keyword) {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM Customers WHERE FirstName LIKE ?";
        try (
            Connection conn = DBHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Customer c = new Customer();
                c.setCustomerID(rs.getInt("makh"));
                c.setFirstName(rs.getString("FirstName"));
                c.setEmailNum(rs.getString("EmailNum"));
                c.setAddress(rs.getString("Address"));
                c.setPhone(rs.getString("Phone"));
                c.setAge(rs.getInt("Age"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
