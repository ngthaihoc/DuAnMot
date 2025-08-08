/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author Administrator
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ReceiptSummary {
    private int receiptSummaryID;
    private double totalAmount;
    private String paymentStatus;
    private PurchaseReceipt receipt;
    
}
