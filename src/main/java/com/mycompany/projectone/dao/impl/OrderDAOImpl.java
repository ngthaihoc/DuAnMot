/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.OrderDAO;
import com.mycompany.projectone.entity.Order;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public class OrderDAOImpl implements OrderDAO{
    
     private String createSQL = "INSERT INTO Orders(OrderID, CustomerID, EmployeeID, OrderDate, PromotionID) VALUES(?, ?, ?, ?, ?)";
    private String updateSQL = "UPDATE Orders SET CustomerID = ?, EmployeeID = ?, OrderDate = ?, PromotionID = ? WHERE OrderID = ?";
    private String deleteSQL = "DELETE FROM Orders WHERE OrderID = ?";
    private String findAllSQL = "SELECT * FROM Orders";
    private String findByIDSQL = "SELECT * FROM Orders WHERE OrderID = ?";

    @Override
    public Order create(Order entity) {
        Object[] values = {
                       entity.getOrderID(),
            entity.getCustomer(),
            entity.getEmployee(),
            entity.getOrderDate(),
            entity.getPromotion()
                          };
        XJdbc.executeUpdate(createSQL, values);
        return entity;
    }

    @Override
    public void update(Order entity) {
          Object[] values = {
                       entity.getOrderID(),
            entity.getCustomer(),
            entity.getEmployee(),
            entity.getOrderDate(),
            entity.getPromotion()
                          };
        XJdbc.executeUpdate(updateSQL, values);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteSQL, id);
    }

    @Override
    public List<Order> findAll() {
        return XQuery.getBeanList(Order.class, findAllSQL);
    }

    @Override
    public Order findById(Integer id) {
        return XQuery.getSingleBean(Order.class, findByIDSQL, id);
    }
    
}
