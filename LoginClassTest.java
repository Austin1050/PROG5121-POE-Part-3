/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registeruserpoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Tokollo Austin Monama
 */
public class LoginClassTest {

    LoginClass login = new LoginClass();

    // USERNAME TESTS

    @Test
    public void testUsernameCorrectlyFormatted() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    // PASSWORD TESTS

    @Test
    public void testPasswordMeetsComplexity() {
        assertTrue(login.checkPasswordComplexity("Ch&8&sec@ke99!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    // CELL PHONE TESTS

    @Test
    public void testCellphoneCorrectlyFormatted() {
        assertTrue(login.checkCellphoneNumber("+27838968976"));
    }

    @Test
    public void testCellphoneIncorrectlyFormatted() {
        assertFalse(login.checkCellphoneNumber("08966553"));
    }

    // LOGIN TESTS (assertTrue / False)

    @Test
    public void testLoginSuccessful() {
        boolean result = login.checkUserName("kyl_1") &&
                         login.checkPasswordComplexity("Ch&8&sec@ke99!") &&
                         login.checkCellphoneNumber("+27838968976");

        assertTrue(result);
    }

    @Test
    public void testLoginFailed() {
        boolean result = login.checkUserName("kyle!!!!!!!") &&
                         login.checkPasswordComplexity("password") &&
                         login.checkCellphoneNumber("08966553");

        assertFalse(result);
    }

    // assertEquals TESTS (MESSAGES)

    @Test
    public void testRegisterUserSuccess() {
        String result = login.registerUser("kyl_1", "Ch&8&sec@ke99!", "+27838968976");
        assertEquals("User registered successfully.", result);
    }

    @Test
    public void testRegisterUserPasswordFail() {
        String result = login.registerUser("kyle!!!!!!!", "password", "+27838968976");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number and a special character.", result);
    }

    @Test
    public void testRegisterUserCellphoneFail() {
        String result = login.registerUser("kyl_1", "Ch&8&sec@ke99!", "08966553");
        assertEquals("Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.", result);
    }

    @Test
    public void testRegisterUserUsernameFail() {
        String result = login.registerUser("kyle!!!!!!!", "Ch&8&sec@ke99!", "+27838968976");
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }
}