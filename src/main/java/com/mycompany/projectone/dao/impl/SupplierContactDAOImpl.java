/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.SupplierContactDAO;
import com.mycompany.projectone.entity.SupplierContact;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public class SupplierContactDAOImpl  implements SupplierContactDAO{
    

    private String createSQL = "INSERT INTO Supplier_Contacts(ContactID, Email, Phone, SupplierID) VALUES(?, ?, ?, ?)";
    private String updateSQL = "UPDATE Supplier_Contacts SET Email = ?, Phone = ?, SupplierID = ? WHERE ContactID = ?";
    private String deleteSQL = "DELETE FROM Supplier_Contacts WHERE ContactID = ?";
    private String findAllSQL = "SELECT * FROM Supplier_Contacts";
    private String findByIDSQL = "SELECT * FROM Supplier_Contacts WHERE ContactID = ?";


    @Override
    public SupplierContact create(SupplierContact entity) {
        Object[] value = {
            entity.getContactID(),
            entity.getEmail(),
            entity.getPhone(),
            entity.getSupplier()
        };
        XJdbc.executeUpdate(createSQL, value);
        return entity;
    }

    @Override
    public void update(SupplierContact entity) {
        Object[] value = {
            entity.getContactID(),
            entity.getEmail(),
            entity.getPhone(),
            entity.getSupplier()
        };
        XJdbc.executeUpdate(updateSQL, value);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteSQL, id);
    }

    @Override
    public List<SupplierContact> findAll() {
        return XQuery.getBeanList(SupplierContact.class, findAllSQL);
    }

    @Override
    public SupplierContact findById(Integer id) {
        return XQuery.getSingleBean(SupplierContact.class, findByIDSQL, id);
    }
    
}
