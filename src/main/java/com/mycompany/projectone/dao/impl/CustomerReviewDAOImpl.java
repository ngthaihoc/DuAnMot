/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.CustomerReviewDAO;
import com.mycompany.projectone.entity.CustomerReview;
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
   String findByCustomer = "SELECT * from Customer_Reviews WHERE CustomerID = ? ;";
   String findByBookID = "select * from Customer_Reviews WHERE BookID = ? ";

    @Override
    public CustomerReview create(CustomerReview entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(CustomerReview entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CustomerReview> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CustomerReview findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
