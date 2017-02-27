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
public class Order {
    public String orderID; 
    public String orderDate;
    public String customerID;
    public String employeeID;
    public String truckID;
    public String isSpecial;
    public String PONumber;
    public String orderTotalAmount;

    public String getOrderID() {
        return orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getTruckID() {
        return truckID;
    }

    public String getIsSpecial() {
        return isSpecial;
    }

    public String getPON() {
        return PONumber;
    }

    public String getOrderTotalAmount() {
        return orderTotalAmount;
    }
    

    
    public Order(){
        
    }

    @Override
    public String toString() {
        return "Order{" + "orderDate=" + orderDate + ", customerID=" + customerID + ", employeeID=" + employeeID + ", truckID=" + truckID + ", isSpecial=" + isSpecial + ", PON=" + PONumber + ", orderTotalAmount=" + orderTotalAmount + '}';
    }
    
    
    
    
}
