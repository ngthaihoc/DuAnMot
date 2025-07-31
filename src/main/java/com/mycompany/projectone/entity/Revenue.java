/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.entity;

import java.util.Date;
import java.util.Locale.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author WellyOwO
 */
public class Revenue {
    
 @AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
 
 public static class ByDate{
     private int bookID;
     private String bookName;
     private Category category;
     private Date orderDate;
     private double Revenue;
     private String  nameEmp;
     private String customerName;
 }
     
  
  @AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
 
 public static class ByBooks{
     private int bookID;
     private String bookName;
     private Category category;
     private int quantityInStock;
     private double Revenue;
 }
     
     
 }

    
