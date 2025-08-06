/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.entity;


import java.util.Locale.Category; 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
/**
 *
 * @author Administrator
 */
public class Book {
    private int bookID;
    private String title;
    private String author;
    private int publisherYear;  // năm xuất bản sách
    private double price;
    private Category category;
    private Supplier supplier;
    private int quantityInStock;
    
}
