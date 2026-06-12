/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registeruserpoe;



/**
 *
 * @author Tokollo Austin Monama
 */

import java.util.Random;

public class Message {

    // Variables
    private String messageID;
    private String recipient;
    private String message;
    private String messageHash;

    // Constructor
    public Message(String recipient, String message) {

        this.recipient = recipient;
        this.message = message;

        messageID = generateID();

        messageHash = createMessageHash();
    }

    
    // method for checking the lenght of the message ID

    public boolean checkMessageID() {

        return messageID.length() <= 10;
    }

    
    // method for checking the recipient cellphone number conditions

    public String checkRecipientCell() {

        if (recipient.matches("^\\+27\\d{9}$")) {

            return "Cell phone number successfully captured.";

        } else {

            return "Cell phone number is incorrectly formatted or does not contain an international code.";
        }
    }

  
    // method for creating message hash

    public String createMessageHash() {

        String firstTwo = messageID.substring(0, 2);

        String[] words = message.trim().split(" ");

        String firstWord = words[0].toUpperCase();

        String lastWord = words[words.length - 1].toUpperCase();

        return firstTwo + ":"
                + RegisterUserPOE.numMessagesSent + ":"
                + firstWord + lastWord;
    }

    
    // 

    public String sentMessage(String choice) {

        if (choice.equals("1")) {

            storeMessage();

            return "Message successfully sent.";

        } else if (choice.equals("2")) {

            return "Message disregarded.";

        } else if (choice.equals("3")) {

            storeMessage();

            return "Message successfully stored.";

        } else {

            return "Invalid option.";
        }
    }

   
    // method to display message details after sending

    public String printMessages() {

        return "\nMessage ID: " + messageID
                + "\nRecipient: " + recipient
                + "\nMessage: " + message
                + "\nMessage Hash: " + messageHash;
    }


    // method for total messages sent

    public int returnTotalMessages() {

        return RegisterUserPOE.numMessagesSent;
    }


    // method for storing the message in a json file

    public void storeMessage() {

        RegisterUserPOE.saveMessage(
                messageID,
                recipient,
                message,
                messageHash
        );
    }


    // generate message ID method

    private String generateID() {

        Random random = new Random();

        String id = "";

        for (int i = 0; i < 10; i++) {

            id += random.nextInt(10);
        }

        return id;
    }

    
    // MessageId method

    public String getMessageID() {

        return messageID;
    }

    public String getRecipient() {

        return recipient;
    }

    public String getMessage() {

        return message;
    }

    public String getMessageHash() {

        return messageHash;
    }
}