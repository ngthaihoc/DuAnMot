/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.PurchaseReceiptDAO;
import com.mycompany.projectone.entity.PurchaseReceipt;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public class PurchaseReceiptDAOImpl implements PurchaseReceiptDAO{

    private String createSQL = "INSERT INTO Purchase_Receipts(ReceiptID, EmployeeID, ReceiptDate, BookID) VALUES(?, ?, ?, ?)";
    private String updateSQL = "UPDATE Purchase_Receipts SET EmployeeID = ?, ReceiptDate = ?, BookID = ? WHERE ReceiptID = ?";
    private String deleteSQL = "DELETE FROM Purchase_Receipts WHERE ReceiptID = ?";
    private String findAllSQL = "SELECT * FROM Purchase_Receipts";
    private String findByIDSQL = "SELECT * FROM Purchase_Receipts WHERE ReceiptID = ?";

    @Override
    public PurchaseReceipt create(PurchaseReceipt entity) {
        Object[] value = {
            entity.getReceiptID(),
            entity.getEmployee(),
            entity.getReceiptDate(),
            entity.getBook()
        };
        XJdbc.executeUpdate(createSQL, value);
        return entity;
    }

    @Override
    public void update(PurchaseReceipt entity) {
         Object[] value = {
            entity.getReceiptID(),
            entity.getEmployee(),
            entity.getReceiptDate(),
            entity.getBook()
        };
        XJdbc.executeUpdate(updateSQL, value);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteSQL, id);
    }

    @Override
    public List<PurchaseReceipt> findAll() {
        return XQuery.getBeanList(PurchaseReceipt.class, findAllSQL);
    }

    @Override
    public PurchaseReceipt findById(Integer id) {
        return XQuery.getSingleBean(PurchaseReceipt.class, findByIDSQL, id);
    }
    
}
