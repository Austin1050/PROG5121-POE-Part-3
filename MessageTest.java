/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registeruserpoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bratm
 */
public class MessageTest {
    
    @Test
    public void testCheckMessageID() {

        Message msg = new Message(
                "+27718693002",
                "Hi Mike"
        );

        assertTrue(msg.checkMessageID());
    }
    
    @Test
    public void testValidRecipientNumber() {

        Message msg = new Message(
                "+27718693002",
                "Hi Mike"
        );

        String expected =
                "Cell phone number successfully captured.";

        assertEquals(expected, msg.checkRecipientCell());
    }

    @Test
    public void testInvalidRecipientNumber() {

        Message msg = new Message(
                "0812345678",
                "Hello"
        );

        String expected =
                "Cell phone number is incorrectly formatted or does not contain an international code.";

        assertEquals(expected, msg.checkRecipientCell());
    }

    @Test
    public void testCreateMessageHash() {

        Message msg = new Message(
                "+27718693002",
                "Hi Mike"
        );

        String hash = msg.getMessageHash();

        assertNotNull(hash);
        assertFalse(hash.isEmpty());
    }

    @Test
    public void testSendMessage() {

        Message msg = new Message(
                "+27718693002",
                "Hello"
        );

        String expected =
                "Message successfully sent.";

        assertEquals(expected,
                msg.sentMessage("1"));
    }

    @Test
    public void testDisregardMessage() {

        Message msg = new Message(
                "+27718693002",
                "Hello"
        );

        String expected =
                "Message disregarded.";

        assertEquals(expected,
                msg.sentMessage("2"));
    }

    @Test
    public void testStoreMessage() {

        Message msg = new Message(
                "+27718693002",
                "Hello"
        );

        String expected =
                "Message successfully stored.";

        assertEquals(expected,
                msg.sentMessage("3"));
    }

    @Test
    public void testInvalidOption() {

        Message msg = new Message(
                "+27718693002",
                "Hello"
        );

        String expected =
                "Invalid option.";

        assertEquals(expected,
                msg.sentMessage("5"));
    }

    @Test
    public void testPrintMessages() {

        Message msg = new Message(
                "+27718693002",
                "Hello"
        );

        String details = msg.printMessages();

        assertTrue(details.contains("Recipient"));
        assertTrue(details.contains("Message"));
    }

    @Test
    public void testReturnTotalMessages() {

        Message msg = new Message(
                "+27718693002",
                "Hello"
        );

        int total = msg.returnTotalMessages();

        assertEquals(RegisterUserPOE.numMessagesSent,
                total);
    }

    @Test
    public void testGetMessageID() {

        Message msg = new Message(
                "+27718693002",
                "Hello"
        );

        assertNotNull(msg.getMessageID());
    }

    @Test
    public void testGetRecipient() {

        Message msg = new Message(
                "+27718693002",
                "Hello"
        );

        assertEquals("+27718693002",
                msg.getRecipient());
    }

    @Test
    public void testGetMessage() {

        Message msg = new Message(
                "+27718693002",
                "Hello"
        );

        assertEquals("Hello",
                msg.getMessage());
    }

    @Test
    public void testGetMessageHash() {

        Message msg = new Message(
                "+27718693002",
                "Hello"
        );

        assertNotNull(msg.getMessageHash());
    }
}