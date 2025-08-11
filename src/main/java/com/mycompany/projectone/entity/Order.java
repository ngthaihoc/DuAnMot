    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package com.mycompany.projectone.entity;


    import java.util.Date;
    import java.util.List;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
  public class Order {
    private int orderID;
    private String customerName; 
    private String employeeName;
    private Date orderDate;
    private String paymentMethod;  
    private String promoTitle;   
    private double TotalAmount ; 
}
