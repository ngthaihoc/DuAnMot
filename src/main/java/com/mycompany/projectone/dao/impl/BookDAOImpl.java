/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.BookDAO;
import com.mycompany.projectone.entity.Book;
import java.util.List;

/**
 *
 * @author WellyOwO 
 */
public class BookDAOImpl implements BookDAO{
    String createSQL = "INSERT INTO Books (BookID, Title, Author, PublisherYear, Photo, Price, CategoryID, SupplierID, QuantityInStock) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    String deleteSQL = "DELETE Books WHERE BookID = ? ";
    String updateSQL = "Update Books SET BookID = ?, Title = ?, Author = ? , PublisherYear = ? , Price = ? ,CategoryID = ?, SupplierID = ?, QuantityInStock = ? ";
    String findAllSQL = "SELECT b.BookID,Title, Author, PublisherYear, Price, cate.CategoryName, sp.SupplierName, s.Quantity   from Books b, Categories cate, Supplier sp, Stock s where b.CategoryID = cate.CategoryID and b.SupplierID = sp.SupplierID and b.BookID = s.BookID";
    String fingByAuthorSQL = "SELECT b.BookID,Title, b.Author, PublisherYear, Price, cate.CategoryName, sp.SupplierName, s.Quantity   from Books b, Categories cate, Supplier sp, Stock s where b.CategoryID = cate.CategoryID and b.SupplierID = sp.SupplierID and b.BookID = s.BookID and b.Author = '?'";
    String findBySupplierSQL = "SELECT b.BookID,Title, b.Author, PublisherYear, Price, cate.CategoryName, sp.SupplierName, s.Quantity   from Books b, Categories cate, Supplier sp, Stock s where b.CategoryID = cate.CategoryID and b.SupplierID = sp.SupplierID and b.BookID = s.BookID and sp.SupplierName = ?";
    String findByCategorySQL = "SELECT b.BookID,Title, b.Author, PublisherYear, Price, cate.CategoryName, sp.SupplierName, s.Quantity   from Books b, Categories cate, Supplier sp, Stock s where b.CategoryID = cate.CategoryID and b.SupplierID = sp.SupplierID and b.BookID = s.BookID and cate.CategoryName = ?";
    

    @Override
    public Book create(Book entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Book entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Book> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Book findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
