/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.CustomerReviewDAO;
import com.mycompany.projectone.entity.CustomerReview;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public class CustomerReviewDAOImpl implements CustomerReviewDAO {
    
   String createSQL = "INSERT INTO Customer_Reviews(ReviewID, Rating, Comment, BookID, CustomerID) VALUES(?, ?, N'?', ?, ?);";
   String updateSQL = "UPDATE Customer_Reviews SET ReviewID = ? , Rating = ? , Comment = N'?' , BookID = ? , CustomerID = ? ;";
   String deleteSQL = "DELETE Customer_Reviews WHERE ReviewID = ? ;";
   String findAllSQL = "SELECT * from Customer_Reviews ;";
   String findByBookID = "select * from Customer_Reviews WHERE BookID = ? ";

    @Override
    public CustomerReview create(CustomerReview entity) {
            Object[] values = {
        entity.getReviewID(),
                entity.getRating(),
                entity.getComment(),
                entity.getBook(),
                entity.getCustomerID()
        };
        XJdbc.executeUpdate(createSQL, values);
        return entity;
        
    }

    @Override
    public void update(CustomerReview entity) {
        Object[] values = {
        entity.getReviewID(),
                entity.getRating(),
                entity.getComment(),
                entity.getBook(),
                entity.getCustomerID()
        };
        XJdbc.executeUpdate(updateSQL, values);
    }
    

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteSQL, id);
    }

    @Override
    public List<CustomerReview> findAll() {
        return XQuery.getBeanList(CustomerReview.class, findAllSQL);
    }

    @Override
    public CustomerReview findById(Integer id) {
        return XQuery.getSingleBean(CustomerReview.class, findByBookID, id);
    }
    
}
