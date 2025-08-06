/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.BookDAO;
import com.mycompany.projectone.entity.Book;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author WellyOwO 
 */
public class BookDAOImpl implements BookDAO{
    String createSQL = "INSERT INTO Books(BookID, Title, Author, PublisherYear, Price, CategoryID, SupplierID, QuantityInStock)VALUES(?, N'?', N'?', ?, ?, ?, ?, ?);";
    String deleteSQL = "DELETE Books WHERE BookID = ? ";
    String updateSQL = "Update Books SET BookID = ?, Title = N'?', Author = N'?' , PublisherYear = ? , Price = ? ,CategoryID = ?, SupplierID = ?, QuantityInStock = ? ";
    String findAllSQL = "SELECT b.BookID,Title, Author, PublisherYear, Price, cate.CategoryName, sp.SupplierName, s.Quantity   from Books b, Categories cate, Supplier sp, Stock s where b.CategoryID = cate.CategoryID and b.SupplierID = sp.SupplierID and b.BookID = s.BookID";
    String fingByAuthorSQL = "SELECT b.BookID,Title, b.Author, PublisherYear, Price, cate.CategoryName, sp.SupplierName, s.Quantity   from Books b, Categories cate, Supplier sp, Stock s where b.CategoryID = cate.CategoryID and b.SupplierID = sp.SupplierID and b.BookID = s.BookID and b.Author = N'?' ";
    String findBySupplierSQL = "SELECT b.BookID,Title, b.Author, PublisherYear, Price, cate.CategoryName, sp.SupplierName, s.Quantity   from Books b, Categories cate, Supplier sp, Stock s where b.CategoryID = cate.CategoryID and b.SupplierID = sp.SupplierID and b.BookID = s.BookID and sp.SupplierName = N'?' ";
    String findByCategorySQL = "SELECT b.BookID,Title, b.Author, PublisherYear, Price, cate.CategoryName, sp.SupplierName, s.Quantity   from Books b, Categories cate, Supplier sp, Stock s where b.CategoryID = cate.CategoryID and b.SupplierID = sp.SupplierID and b.BookID = s.BookID and cate.CategoryName = N'?' ";
    

    @Override
    public Book create(Book entity) {
        Object[] value = {
            entity.getBookID(),
            entity.getTitle(),
            entity.getAuthor(),
            entity.getPublisherYear(),
            entity.getPrice(),
            entity.getCategory(),
            entity.getSupplier(),
            entity.getQuantityInStock()
        };
        XJdbc.executeUpdate(createSQL, value);
        return entity;
    }

    @Override
    public void update(Book entity) {
        Object[] value = {
            entity.getBookID(),
            entity.getTitle(),
            entity.getAuthor(),
            entity.getPublisherYear(),
            entity.getPrice(),
            entity.getCategory(),
            entity.getSupplier(),
            entity.getQuantityInStock()
        };
        XJdbc.executeUpdate(updateSQL, value);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteSQL, id);
    }

    @Override
    public List<Book> findAll() {
       return XQuery.getBeanList(Book.class, findAllSQL);
    }

    @Override
    public Book findById(Integer id) {
          return XQuery.getSingleBean(Book.class, findByCategorySQL, id);
    }

    @Override
    public Book fingByAuthor(String id) {
        return XQuery.getSingleBean(Book.class, fingByAuthorSQL, id);
    }

    @Override
    public Book findBySupplie(String id) {
        return XQuery.getSingleBean(Book.class, findBySupplierSQL, id);
    }
    
    
    
}
