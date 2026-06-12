/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registeruserpoe;

/**
 *
 * @author Tokollo Austin Monama

 */
import java.util.Scanner;

public class LoginUser {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        //Declaring Variables
        String username;
        String password;
        String phone;
        
        //Welcome message for the user
        System.out.println("\n ------ Welcome to the App,You may create an account ------");
        
        
        //Conditions to guide the user when creating a username
        System.out.println("\n ---- Username Conditions ----");
        System.out.println("-must contain an underscore(_)");
        System.out.println("-Length must be no more than five characters long");
   
        //Prompt for the user to create a username
        System.out.print("Enter username: ");
        username = input.nextLine();
        
        //Conditions to guide the user when creating a password
        System.out.println("\n ---- Password Conditions ----");
        System.out.println("-Must be at least eight characters long");
        System.out.println("-Contain a capital letter");
        System.out.println("-Contain a number");
        System.out.println("-Contain a special character");
        
        //Prompt for the user to create a password
        System.out.print("Create a password: ");
        password = input.nextLine();
        
        //Conditions to guide the user when entering their cell phone number
        System.out.println("\n ---- Cell Phone Number Conditions ----");
        System.out.println("-Must contain the international country code(+27)");
        System.out.println("-Must be no more than characters long");
         
        
        //Prompt for the user to enter thier mobile number
        System.out.print("Enter SA mobile number: ");
        phone = input.nextLine();
        
        if (username.contains("_") && username.length() <=5){
            System.out.println("Username successfully captured");
        }
        else {
            System.out.println("Username is not correctly formatted,please ensure that your username contains an underscore and is no more than five characters in length");
        }
        
        //Regular expression for password
        //Reference:Keith Galli(Youtube Channel)
        //Video URL: https://youtu.be/vsa9GGzMFXQ?si=85ZsboJdy-PuriuP
        if (password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$")) {
            System.out.println("Password successfully captured");
        }
        else {
            System.out.println("Password not correctly formatted,please ensure that the password contains at least eight characters;a capital letter;a number; and a special character");
        }
        
        //Regular expression for cellphone number
        //Reference:Keith Galli(Youtube Channel)
        //Video URL: https://youtu.be/vsa9GGzMFXQ?si=85ZsboJdy-PuriuP
        if (phone.matches("^\\+27\\d{9}$")) {
            System.out.println("Cellphone successfully added");
        }
        else {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code");
        }
        
        //Login for the user after a successfull account registration
        System.out.println("\n ---- Account Successfully created,now you can Login ----");
        
        //Prompting the user to enter the same username they created when registering
        System.out.print("Username: ");
        String u = input.nextLine();
        
        //Prompting the user to enter the same password they created when registering
        System.out.print("Password: ");
        String p = input.nextLine();
        
        //Conditions to check if the user entered the correct Login details
        if (u.equals(username) && p.equals(password)) {
            System.out.println("Welcome " + username + " " + ",it is great to see you again");
        }
        else {
            System.out.println("Username or password incorrect,please try again");
        }
    }
    
}
