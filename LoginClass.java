/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registeruserpoe;

/**
 *
 * @author Tokollo Austin Monama
 */

public class LoginClass {
    
    //Method to check password conditions   
    public  boolean  checkUserName(String Username){
    return  Username.contains("_") &&  Username.length() <= 5;
    }
    
    //Method to check password conditions
    public boolean checkPasswordComplexity(String Password) {
            
             String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$";
       
       return Password.matches(regex);
    }
    
    //Method to check cellphone number conditions
    public boolean checkCellphoneNumber(String CellPhoneNum) {
        String regex = "^\\+27\\d{9}$";
     return  CellPhoneNum.matches(regex);
    }
    
    //Variables Declaration
    String Username;
    String Password;
    String CellPhoneNum;
    
    //Methods to check register user conditions
    public String registerUser(String Username,String Password,String CellPhoneNum) {
        
        // The messages that will be displayed for the Username
         if (checkUserName(Username)) {
            System.out.println("Username successfully captured");
        }else{
            System.out.println("Username is not correctly formatted;please ensure that your username contains an underscore and is no more than five characters in length.");
        }
        
        // The messages that will displayed for the Password
        if (checkPasswordComplexity(Password)) {
            System.out.println("Password successfully captured");
        }else{
            System.out.println("Password is not correctly formatted;please ensure that the password contains at least eight characters,a capital letter,a number and a special character.");
            }
        
        // The messages that will be displayed for the CellPhoneNum
        if (checkCellphoneNumber(CellPhoneNum)) {
            System.out.println("Cell phone number successfully added");
        }else{
            System.out.println("Cell phone number incorrectly formatted or does not contain international code");
        } 
        this.Username = Username;
        this.Password = Password;
        this.CellPhoneNum = CellPhoneNum;
       
     return "User is registered";
       
    }
    
    //Methods to check login user conditions
    public boolean loginUser(String Username,String Password) {
        return this.Username.equals(Username) && this.Password.equals(Password);
        
    }
        

        public String returnLoginStatus(boolean loginSuccess) {
            
        if (loginSuccess) {
          return "Welcome back,it is great to see you again.";
        } else {
          return "Username or Password incorrect,please try again.";
          
        }
        
        }   
}