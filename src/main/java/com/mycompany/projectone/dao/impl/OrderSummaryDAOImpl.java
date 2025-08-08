/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.OrderSummaryDAO;
import com.mycompany.projectone.entity.OrderSummary;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public class OrderSummaryDAOImpl implements OrderSummaryDAO {
    

    private String createSQL = "INSERT INTO Order_Summary(Order_SummaryID, TotalAmount, OrderID, PromotionID) VALUES(?, ?, ?, ?)";
    private String updateSQL = "UPDATE Order_Summary SET TotalAmount = ?, OrderID = ?, PromotionID = ? WHERE Order_SummaryID = ?";
    private String deleteSQL = "DELETE FROM Order_Summary WHERE Order_SummaryID = ?";
    private String findAllSQL = "SELECT * FROM Order_Summary";
    private String findByIDSQL = "SELECT * FROM Order_Summary WHERE Order_SummaryID = ?";


    @Override
    public OrderSummary create(OrderSummary entity) {
              Object[] values = {
             entity.getOrderSummaryID(),
            entity.getTotalAmount(),
            entity.getOrderID(),
            entity.getPromotion()
                          };
        XJdbc.executeUpdate(createSQL, values);
        return entity;
    }

    @Override
    public void update(OrderSummary entity) {
                      Object[] values = {
             entity.getOrderSummaryID(),
            entity.getTotalAmount(),
            entity.getOrderID(),
            entity.getPromotion()
                          };
        XJdbc.executeUpdate(updateSQL, values);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteSQL, id);
    }

    @Override
    public List<OrderSummary> findAll() {
        return XQuery.getBeanList(OrderSummary.class, findAllSQL);
    }

    @Override
    public OrderSummary findById(Integer id) {
        return XQuery.getSingleBean(OrderSummary.class, findByIDSQL, id);
    }
    
    
}
