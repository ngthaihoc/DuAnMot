/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.SupplierDAO;
import com.mycompany.projectone.entity.Supplier;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public class SupplierDAOImpl implements SupplierDAO {
    

    private String createSQL = "INSERT INTO Supplier(SupplierID, SupplierName, NumberOfBooks) VALUES(?, ?, ?)";
    private String updateSQL = "UPDATE Supplier SET SupplierName = ?, NumberOfBooks = ? WHERE SupplierID = ?";
    private String deleteSQL = "DELETE FROM Supplier WHERE SupplierID = ?";
    private String findAllSQL = "SELECT * FROM Supplier";
    private String findByIDSQL = "SELECT * FROM Supplier WHERE SupplierID = ?";


    @Override
    public Supplier create(Supplier entity) {
        Object[] value = {
            entity.getSupplierName(),
            entity.getNumberOfBooks()
        };
        XJdbc.executeUpdate(createSQL, value);
        return entity;
    }

    @Override
    public void update(Supplier entity) {
          Object[] value = {
            entity.getSupplierName(),
            entity.getNumberOfBooks()
        };
        XJdbc.executeUpdate(updateSQL, value);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteSQL, id);
    }

    @Override
    public List<Supplier> findAll() {
        return XQuery.getBeanList(Supplier.class, findAllSQL);
    }

    @Override
    public Supplier findById(Integer id) {
        return XQuery.getSingleBean(Supplier.class, findByIDSQL, id);
    }
    
}
