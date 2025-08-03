/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.CategoriesDAO;
import com.mycompany.projectone.entity.Categories;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public class CategoriesDAOImpl implements CategoriesDAO{
    
    String createSQL = "INSERT INTO Categories(CategoryID, CategoryName)VALUES(?, N'?');";
    String updateSQL = "UPDATE Categories SET CategoryID = ? , CategoryName = N'?' WHERE CategoryID = ? ";
    String deleteSQL = "DELETE Categories WHERE CategoryID = ? ";
    String findAllSQL = "select * from Categories";
    String findByIDSQL = "select * from Categories WHERE CategoryID = ?";

    @Override
    public Categories create(Categories entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Categories entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Categories> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categories findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
