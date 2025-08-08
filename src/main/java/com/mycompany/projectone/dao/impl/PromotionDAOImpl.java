/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.PromotionDAO;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public class PromotionDAOImpl implements PromotionDAO {


    private String createSQL = "INSERT INTO Promotion(PromotionID, PromoTitle, Description, StartDate, EndDate, isActive, DiscountValue) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private String updateSQL = "UPDATE Promotion SET PromoTitle = ?, Description = ?, StartDate = ?, EndDate = ?, isActive = ?, DiscountValue = ? WHERE PromotionID = ?";
    private String deleteSQL = "DELETE FROM Promotion WHERE PromotionID = ?";
    private String findAllSQL = "SELECT * FROM Promotion";
    private String findByIDSQL = "SELECT * FROM Promotion WHERE PromotionID = ?";

    @Override
    public com.mycompany.projectone.entity.Promotion create(com.mycompany.projectone.entity.Promotion entity) {
        Object[] value = {
            entity.getPromotionID(),
            entity.getPromoTitle(),
            entity.getDescription(),
            entity.getStartDate(),
            entity.getEndDate(),
            entity.isActive(),
            entity.getDiscountValue()
        };
        XJdbc.executeUpdate(createSQL, value);
        return entity;
    }

    @Override
    public void update(com.mycompany.projectone.entity.Promotion entity) {
           Object[] value = {
            entity.getPromotionID(),
            entity.getPromoTitle(),
            entity.getDescription(),
            entity.getStartDate(),
            entity.getEndDate(),
            entity.isActive(),
            entity.getDiscountValue()
        };
        XJdbc.executeUpdate(updateSQL, value);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteSQL, id);
    }

    @Override
    public List<com.mycompany.projectone.entity.Promotion> findAll() {
        return XQuery.getBeanList(com.mycompany.projectone.entity.Promotion.class, findAllSQL);
    }

    @Override
    public com.mycompany.projectone.entity.Promotion findById(Integer id) {
        return XQuery.getSingleBean(com.mycompany.projectone.entity.Promotion.class, findByIDSQL, id);
    }
    

    
}
