/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.CategoriesDAO;
import com.mycompany.projectone.entity.Categories;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
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
        Object[] value = {
        entity.getCategoryID(),
            entity.getCategoryName()
        };
        XJdbc.executeUpdate(createSQL, value);
        return entity;
    }

    @Override
    public void update(Categories entity) {
        Object[] value = {
        entity.getCategoryID(),
            entity.getCategoryName()
        };
        XJdbc.executeUpdate(createSQL, value);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteSQL, id);
    }
    

    @Override
    public List<Categories> findAll() {
        return XQuery.getBeanList(Categories.class, findAllSQL);
    }

    @Override
    public Categories findById(Integer id) {
        return XQuery.getSingleBean(Categories.class, findByIDSQL, id);
    }
    
}
