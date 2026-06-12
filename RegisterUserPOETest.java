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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
 
public class RegisterUserPOETest {
 
    // These mirror the static arrays in RegisterUserPOE
    ArrayList<String> sentMessages;
    ArrayList<String> storedMessages;
    ArrayList<String> disregardedMessages;
    ArrayList<String> messageHashes;
    ArrayList<String> messageIDs;
    ArrayList<String> storedRecipients;
    ArrayList<String> storedSenders;
 
    // Separate sent recipients and IDs to avoid index mix-ups
    ArrayList<String> sentRecipients;
    ArrayList<String> sentIDs;
    ArrayList<String> sentHashes;
 
    // This runs before every test - loads all 5 test messages
    @BeforeEach
    public void setUp() {
 
        sentMessages        = new ArrayList<>();
        storedMessages      = new ArrayList<>();
        disregardedMessages = new ArrayList<>();
        messageHashes       = new ArrayList<>();
        messageIDs          = new ArrayList<>();
        storedRecipients    = new ArrayList<>();
        storedSenders       = new ArrayList<>();
        sentRecipients      = new ArrayList<>();
        sentIDs             = new ArrayList<>();
        sentHashes          = new ArrayList<>();
 
        // Test Message 1 - Flag: Sent
        sentMessages.add("Did you get the cake?");
        sentRecipients.add("+27834557896");
        sentIDs.add("1111111111");
        sentHashes.add("11:1:DIDCAKE?");
 
        // Test Message 2 - Flag: Stored
        storedMessages.add("Where are you? You are late! I have asked you to be on time.");
        storedRecipients.add("+27838884567");
        storedSenders.add("Me");
        messageIDs.add("2222222222");
        messageHashes.add("22:2:WHERETIME.");
 
        // Test Message 3 - Flag: Disregard
        disregardedMessages.add("Yohoooo, I am at your gate.");
 
        // Test Message 4 - Flag: Sent (developer number - no +27)
        sentMessages.add("It is dinner time !");
        sentRecipients.add("0838884567");
        sentIDs.add("0838884567");
        sentHashes.add("08:4:ITTIME!");
 
        // Test Message 5 - Flag: Stored
        storedMessages.add("Ok, I am leaving without you.");
        storedRecipients.add("+27838884567");
        storedSenders.add("Me");
        messageIDs.add("5555555555");
        messageHashes.add("55:5:OKYOU.");
    }
 
    @Test
    public void testSentMessagesArrayPopulated() {
 
        assertEquals("Did you get the cake?", sentMessages.get(0));
        assertEquals("It is dinner time !",   sentMessages.get(1));
    }
 
    @Test
    public void testDisplayLongestMessage() {
 
        // combine sent and stored the same way displayLongestMessage() would
        ArrayList<String> allMessages = new ArrayList<>();
        allMessages.addAll(sentMessages);
        allMessages.addAll(storedMessages);
 
        String longest = allMessages.get(0);
 
        for (int i = 1; i < allMessages.size(); i++) {
            if (allMessages.get(i).length() > longest.length()) {
                longest = allMessages.get(i);
            }
        }
 
        assertEquals("Where are you? You are late! I have asked you to be on time.", longest);
    }
 
    @Test
    public void testSearchByMessageID() {
 
        String searchID = "0838884567";
        String foundMessage = null;
 
        for (int i = 0; i < sentIDs.size(); i++) {
            if (sentIDs.get(i).equals(searchID)) {
                foundMessage = sentMessages.get(i);
                break;
            }
        }
 
        assertEquals("It is dinner time !", foundMessage);
    }
 
    @Test
    public void testSearchByRecipient() {
 
        String searchNumber = "+27838884567";
        ArrayList<String> results = new ArrayList<>();
 
        // search stored recipients - same logic as searchByRecipient() in RegisterUserPOE
        for (int i = 0; i < storedRecipients.size(); i++) {
            if (storedRecipients.get(i).equals(searchNumber)) {
                results.add(storedMessages.get(i));
            }
        }
 
        assertTrue(results.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(results.contains("Ok, I am leaving without you."));
    }
 
    @Test
    public void testDeleteByHash() {
 
        String hashToDelete = "22:2:WHERETIME.";
 
        int indexToRemove = -1;
 
        // find the hash - same logic as deleteByHash() in RegisterUserPOE
        for (int i = 0; i < messageHashes.size(); i++) {
            if (messageHashes.get(i).equals(hashToDelete)) {
                indexToRemove = i;
                break;
            }
        }

        assertNotEquals(-1, indexToRemove);

        messageHashes.remove(indexToRemove);
        storedMessages.remove(indexToRemove);
        storedRecipients.remove(indexToRemove);
        storedSenders.remove(indexToRemove);
        messageIDs.remove(indexToRemove);
 
        assertFalse(messageHashes.contains(hashToDelete));
        assertFalse(storedMessages.contains(
                "Where are you? You are late! I have asked you to be on time."));
    }
 
    @Test
    public void testDisplayReport() {
 
        assertFalse(sentMessages.isEmpty());
        assertFalse(sentHashes.isEmpty());
        assertFalse(sentRecipients.isEmpty());

        assertEquals("Did you get the cake?", sentMessages.get(0));
        assertEquals("+27834557896",           sentRecipients.get(0));
        assertNotNull(sentHashes.get(0));

        assertEquals("It is dinner time !", sentMessages.get(1));
        assertEquals("0838884567",           sentRecipients.get(1));
        assertNotNull(sentHashes.get(1));
    }
}