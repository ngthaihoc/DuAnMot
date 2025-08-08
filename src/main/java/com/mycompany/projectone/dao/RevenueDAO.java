/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.dao;

import com.mycompany.projectone.entity.Revenue;
import java.util.Date;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public interface RevenueDAO {
    List<Revenue.ByDate> getByDate(Date begin, Date end);
    List<Revenue.ByBooks> getByBookses(Integer bookID, String Category);
    
    
}
