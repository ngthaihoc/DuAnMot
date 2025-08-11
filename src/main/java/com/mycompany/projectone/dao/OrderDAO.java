/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.dao;

import com.mycompany.projectone.entity.Order;
import java.util.Date;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public interface OrderDAO extends CurdDAO<Order, Integer> {
     List<Order> findByTimeRange(Date begin, Date end);
}
