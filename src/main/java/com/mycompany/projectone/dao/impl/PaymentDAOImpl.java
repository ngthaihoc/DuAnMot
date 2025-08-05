/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.CrudDAO;
import com.mycompany.projectone.dao.PaymentDAO;
import com.mycompany.projectone.entity.Order;
import com.mycompany.projectone.entity.Payment;
import com.mycompany.projectone.util.XJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class PaymentDAOImpl implements PaymentDAO {
    private final String createSql = "INSERT INTO Payment(PaymentId,Name,OderID) VALUES(?, ?, ?)";
    private final String updateSql = "UPDATE Payment SET Name=?, OderID=? WHERE PaymentId=?";
    private final String deleteByIdSql = "DELETE FROM Payment WHERE PaymentId=?";
    
    private final String findAllSql = "SELECT * FROM Payment";
    private final String findByIdSql = findAllSql + " WHERE PaymentId=?";



    @Override
    public Payment create(Payment payment) {
        String sql = "INSERT INTO Payments (PaymentsID, Name, OrderID) VALUES (?, ?, ?)";
        XJdbc.executeUpdate(sql,
                payment.getPaymentsID(),
                payment.getName(),
                payment.getOrder().getOrderId());
        return payment;
    }

    @Override
    public void update(Payment payment) {
        String sql = "UPDATE Payments SET Name = ?, OrderID = ? WHERE PaymentsID = ?";
        XJdbc.executeUpdate(sql,
                payment.getName(),
                payment.getOrder().getOrderId(),
                payment.getPaymentsID());
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM Payments WHERE PaymentsID = ?";
        XJdbc.executeUpdate(sql, id);
    }

    @Override
    public List<Payment> findAll() {
        List<Payment> list = new ArrayList<>();
        String sql = "SELECT * FROM Payments";
        try {
            ResultSet rs = XJdbc.executeQuery(sql);
            while (rs.next()) {
                Payment p = mapResultSetToPayment(rs);
                list.add(p);
            }
            rs.getStatement().getConnection().close(); // đóng sau khi truy vấn xong
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Payment findById(Integer id) {
        String sql = "SELECT * FROM Payments WHERE PaymentsID = ?";
        try {
            ResultSet rs = XJdbc.executeQuery(sql, id);
            if (rs.next()) {
                Payment p = mapResultSetToPayment(rs);
                rs.getStatement().getConnection().close();
                return p;
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Payment mapResultSetToPayment(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setOrderId(rs.getInt("OrderID"));

       return Payment.builder()
        .paymentsID(rs.getInt("PaymentsID"))
        .name(rs.getString("Name"))
        .order(order)
        .build();

    }
}

