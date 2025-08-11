/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.OrderDetailDAO;
import com.mycompany.projectone.entity.OrderDetail;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public class OrderDetailDAOImpl implements OrderDetailDAO {
    
     private String createSQL = "INSERT INTO Order_Details(DetailedOrderID, BookID, OrderID, Quantity) VALUES(?, ?, ?, ?)";
    private String updateSQL = "UPDATE Order_Details SET BookID = ?, OrderID = ?, Quantity = ? WHERE DetailedOrderID = ?";
    private String deleteSQL = "DELETE FROM Order_Details WHERE DetailedOrderID = ?";
    private String findAllSQL = "SELECT * FROM Order_Details";
   private String findByOrderIdSQL = "SELECT o.OrderID, b.Title AS nameBook, c.CategoryName AS category, od.Quantity AS quantity, (od.Quantity * b.Price) AS totalAmount FROM Order_Details od JOIN Books b ON od.BookID = b.BookID JOIN Categories c ON b.CategoryID = c.CategoryID JOIN Orders o ON od.OrderID = o.OrderID WHERE o.OrderID = ? ORDER BY o.OrderID";

    @Override
    public OrderDetail create(OrderDetail entity) {
        Object[] value = {
            entity.getOrderID(),
            entity.getNameBook(),
            entity.getCategory(),
            entity.getQuantity(),
            entity.getTotalAmount()
        };
        XJdbc.executeUpdate(createSQL, value);
        return entity;
    }

    @Override
    public void update(OrderDetail entity) {
        Object[] value = {
           entity.getOrderID(),
            entity.getNameBook(),
            entity.getCategory(),
            entity.getQuantity(),
            entity.getTotalAmount()
        };
        XJdbc.executeUpdate(updateSQL, value);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteSQL, id);
    }

    @Override
    public List<OrderDetail> findAll() {
        return XQuery.getBeanList(OrderDetail.class, findAllSQL);
    }

    @Override
    public OrderDetail findById(Integer id) {
        return null;
    }

    @Override
    public List<OrderDetail> findByOrderId(Integer orderId) {
        return XQuery.getBeanList(OrderDetail.class, findByOrderIdSQL, orderId);
    }
    
}
