/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.dao;

import com.mycompany.projectone.entity.OrderDetail;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public interface OrderDetailDAO extends CurdDAO<OrderDetail, Integer> {
    List<OrderDetail> findByOrderId(Integer orderId);
}
