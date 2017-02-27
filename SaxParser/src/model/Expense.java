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
public class Expense {
    private int expenseID;
    //F key
    private int employeeID;
    //F key
    private int truckID;
    //F key (optional)
    private int officeExpID;
    private String expenseType;
    private String expenseCategoty;
    private String purposOfExpense;
    private double amount;
    private String description;
    private String datePurchased;
    private String dateSubmitted;
    private double advanceAmount;
    //paymentMethod property 
    
    public Expense(){
        
    }
}
