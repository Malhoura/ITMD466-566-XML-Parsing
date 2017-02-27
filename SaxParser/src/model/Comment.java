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
public class Comment {
    private int commentID;
    private String commentDateTime;
    private String comment;
    //F key
    private int customerID;
    //F key
    private int locationID;
    //F key
    private int transactionID;
    //F key 
    private int truckID;
    
    public Comment(){
        
    }
}
