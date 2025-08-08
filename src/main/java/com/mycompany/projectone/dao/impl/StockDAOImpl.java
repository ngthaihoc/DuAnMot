/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.StockDAO;
import com.mycompany.projectone.entity.Stock;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public class StockDAOImpl  implements StockDAO{
    

    private String createSQL = "INSERT INTO Stock(StockID, BookID, Quantity, LastUpdated) VALUES(?, ?, ?, ?)";
    private String updateSQL = "UPDATE Stock SET BookID = ?, Quantity = ?, LastUpdated = ? WHERE StockID = ?";
    private String deleteSQL = "DELETE FROM Stock WHERE StockID = ?";
    private String findAllSQL = "SELECT * FROM Stock";
    private String findByIDSQL = "SELECT * FROM Stock WHERE StockID = ?";

    @Override
    public Stock create(Stock entity) {
          Object[] value = {
            entity.getStockID(),
            entity.getBook(),
            entity.getQuantity(),
            entity.getLastUpdated()
        };
        XJdbc.executeUpdate  (createSQL, value);
        return entity;
    }

    @Override
    public void update(Stock entity) {
        Object[] value = {
            entity.getStockID(),
            entity.getBook(),
            entity.getQuantity(),
            entity.getLastUpdated()
        };
        XJdbc.executeUpdate  (createSQL, value);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteSQL, id);
    }

    @Override
    public List<Stock> findAll() {
        return XQuery.getBeanList(Stock.class, findAllSQL);
    }

    @Override
    public Stock findById(Integer id) {
        return XQuery.getSingleBean(Stock.class,  findByIDSQL , id);
    }

    
    
}
