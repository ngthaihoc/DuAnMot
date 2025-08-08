/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.RevenueDAO;
import com.mycompany.projectone.entity.Revenue;
import com.mycompany.projectone.util.XQuery;
import java.util.Date;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public class RevenueDAOImpl implements RevenueDAO{

    @Override
    public List<Revenue.ByDate> getByDate(Date begin, Date end) {
    String revenueByDateSql = 
        "SELECT b.BookID, " +
        "       b.Title AS bookName, " +
        "       c.CategoryName AS category, " +
        "       o.OrderDate, " +
        "       SUM(b.Price * od.Quantity * (1 - ISNULL(p.DiscountValue, 0)/100)) AS Revenue, " +
        "       e.Name AS nameEmp, " +
        "       cust.FirstName AS customerName " +
        "FROM Order_Details od " +
        "JOIN Books b ON b.BookID = od.BookID " +
        "JOIN Categories c ON c.CategoryID = b.CategoryID " +
        "JOIN Orders o ON o.OrderID = od.OrderID " +
        "JOIN Employees e ON e.EmployeeID = o.EmployeeID " +
        "JOIN Customers cust ON cust.CustomerID = o.CustomerID " +
        "LEFT JOIN Promotion p ON p.PromotionID = o.PromotionID " +
        "WHERE o.OrderDate BETWEEN ? AND ? " +
        "GROUP BY b.BookID, b.Title, c.CategoryName, o.OrderDate, e.Name, cust.FirstName " +
        "ORDER BY Revenue DESC";
    
    return XQuery.getBeanList(Revenue.ByDate.class, revenueByDateSql, begin, end);
}



@Override
public List<Revenue.ByBooks> getByBookses(Integer bookID, String category) {
    String revenueByBooksSql = 
        "SELECT b.BookID, " +
        "       b.Title AS bookName, " +
        "       c.CategoryName AS category, " +
        "       b.QuantityInStock, " +
        "       SUM(b.Price * od.Quantity * (1 - ISNULL(p.DiscountValue, 0)/100)) AS Revenue " +
        "FROM Order_Details od " +
        "JOIN Books b ON b.BookID = od.BookID " +
        "JOIN Categories c ON c.CategoryID = b.CategoryID " +
        "JOIN Orders o ON o.OrderID = od.OrderID " +
        "LEFT JOIN Promotion p ON p.PromotionID = o.PromotionID " +
        "WHERE 1=1 ";
    

    if (bookID != null) {
        revenueByBooksSql += " AND b.BookID = ?";
    }
    if (category != null && !category.isEmpty()) {
        revenueByBooksSql += " AND c.CategoryName LIKE ?";
    }
    
    revenueByBooksSql += " GROUP BY b.BookID, b.Title, c.CategoryName, b.QuantityInStock " +
                         " ORDER BY Revenue DESC";
    

    if (bookID != null && category != null && !category.isEmpty()) {
        return XQuery.getBeanList(Revenue.ByBooks.class, revenueByBooksSql, bookID, "%" + category + "%");
    } else if (bookID != null) {
        return XQuery.getBeanList(Revenue.ByBooks.class, revenueByBooksSql, bookID);
    } else if (category != null && !category.isEmpty()) {
        return XQuery.getBeanList(Revenue.ByBooks.class, revenueByBooksSql, "%" + category + "%");
    } else {
        return XQuery.getBeanList(Revenue.ByBooks.class, revenueByBooksSql);
    }
}

}
    

