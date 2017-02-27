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
public class Payment {
    private int paymentID;
    //F key
    private int orderID;
    private int paymentMethodID;
    private double paymentAmount;
    private String paymentDate;
    private double checkNumber;
    private double creditCardNumber;
    private String cardHolderName;
    private String creditCardExpDte;
    private int creditCardAuthNumber;
    
    public Payment(){
        
    }
}
