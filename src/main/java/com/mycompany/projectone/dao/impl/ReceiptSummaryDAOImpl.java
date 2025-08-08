/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.ReceiptSummaryDAO;
import com.mycompany.projectone.entity.ReceiptSummary;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public class ReceiptSummaryDAOImpl implements ReceiptSummaryDAO {

    private String createSQL = "INSERT INTO Receipt_Summary(ReceiptSummaryID, TotalAmount, PaymentStatus, ReceiptID) VALUES(?, ?, ?, ?)";
    private String updateSQL = "UPDATE Receipt_Summary SET TotalAmount = ?, PaymentStatus = ?, ReceiptID = ? WHERE ReceiptSummaryID = ?";
    private String deleteSQL = "DELETE FROM Receipt_Summary WHERE ReceiptSummaryID = ?";
    private String findAllSQL = "SELECT * FROM Receipt_Summary";
    private String findByIDSQL = "SELECT * FROM Receipt_Summary WHERE ReceiptSummaryID = ?";

    @Override
    public ReceiptSummary create(ReceiptSummary entity) {
        Object[] value = {
            entity.getReceiptSummaryID(),
            entity.getTotalAmount(),
            entity.getPaymentStatus(),
            entity.getReceipt()
        };
        XJdbc.executeUpdate(createSQL, value);
        return entity;
    }

    @Override
    public void update(ReceiptSummary entity) {
        Object[] value = {
            entity.getReceiptSummaryID(),
            entity.getTotalAmount(),
            entity.getPaymentStatus(),
            entity.getReceipt()
        };
        XJdbc.executeUpdate(updateSQL , value);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteSQL, id);
    }

    @Override
    public List<ReceiptSummary> findAll() {
        return XQuery.getBeanList(ReceiptSummary.class, findAllSQL);
    }

    @Override
    public ReceiptSummary findById(Integer id) {
        return XQuery.getSingleBean(ReceiptSummary.class, findByIDSQL, id);
    }
    
}
