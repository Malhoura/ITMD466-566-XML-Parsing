/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Mazen
 */
public class Transaction {
    private int transactionID;
    //F key
    private int orderID;
    //F key
    private int priceID;
    private String transactionData;
    private double transactionAmount;
    //F Key
    private double VIN;
    //F key
    private double truckNo;
    //F key
    private int employeeID;
    private double discount;
    private int quantity;
    private double unitPrice;
    private double driverPrice;
    
    public Transaction(){
        
    }
    
}
