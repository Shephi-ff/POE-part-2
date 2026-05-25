/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

/**
 *
 * @author Delicia
 */
import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class MessageSystem {

    static Scanner input = new Scanner(System.in);

    static int totalMessages = 0;

    public static void main(String[] args) {

        System.out.println("===== QUICKCHAT =====");

        sendMessages();
    }



    public static void sendMessages() {

        System.out.print("How many messages do you want to send? ");
        int num = input.nextInt();
        input.nextLine();

        for (int i = 1; i <= num; i++) {

            System.out.println("\n===== MESSAGE " + i + " =====");

            // Recipient Number
            String recipient;

            while (true) {

                System.out.print("Enter recipient number: ");
                recipient = input.nextLine();

                if (checkRecipientCell(recipient)) {

                    System.out.println("Cell phone number successfully captured.");
                    break;

                } else {

                    System.out.println("Cell phone number incorrectly formatted.");
                }
            }

            // Message
            String message;

            while (true) {

                System.out.print("Enter message: ");
                message = input.nextLine();

                if (message.length() <= 250) {

                    System.out.println("Message ready to send.");
                    break;

                } else {

                    int extra = message.length() - 250;

                    System.out.println("Message exceeds 250 characters by "
                            + extra + ", please reduce size.");
                }
            }

            // Generate ID
            String messageID = createMessageID();

            // Generate Hash
            String messageHash = createMessageHash(i, message);

            // Display Details
            System.out.println("\n===== MESSAGE DETAILS =====");

            System.out.println("Message ID: " + messageID);
            System.out.println("Message Hash: " + messageHash);
            System.out.println("Recipient: " + recipient);
            System.out.println("Message: " + message);

            // Menu
            System.out.println("\n1. Send Message");
            System.out.println("2. Disregard Message");
            System.out.println("3. Store Message");

            System.out.print("Choose option: ");
            int option = input.nextInt();
            input.nextLine();

            switch (option) {

                case 1:

                    totalMessages++;

                    System.out.println("Message successfully sent.");
                    break;

                case 2:

                    System.out.println("Press 0 to delete message.");
                    break;

                case 3:

                    storeMessage(messageID,
                                 messageHash,
                                 recipient,
                                 message);

                    System.out.println("Message successfully stored.");
                    break;

                default:

                    System.out.println("Invalid option.");
            }
        }

        System.out.println("\nTotal messages sent: "
                + totalMessages);
    }

    public static boolean checkRecipientCell(String number) {

        return number.matches("^\\+27\\d{9}$");
    }


    public static String createMessageID() {

        Random random = new Random();

        int number = 100000000
                + random.nextInt(900000000);

        return String.valueOf(number);
    }



    public static String createMessageHash(int messageNumber,
                                           String message) {

        String[] words = message.split(" ");

        String firstWord =
                words[0].toUpperCase();

        String lastWord =
                words[words.length - 1].toUpperCase();

        return messageNumber + ":"
                + firstWord + lastWord;
    }

    public static void storeMessage(String messageID,
                                    String messageHash,
                                    String recipient,
                                    String message) {

        try {

            FileWriter writer =
                    new FileWriter("storedMessages.json",
                            true);

            writer.write("{\n");

            writer.write("\"MessageID\":\""
                    + messageID + "\",\n");

            writer.write("\"MessageHash\":\""
                    + messageHash + "\",\n");

            writer.write("\"Recipient\":\""
                    + recipient + "\",\n");

            writer.write("\"Message\":\""
                    + message + "\"\n");

            writer.write("}\n\n");

            writer.close();

        } catch (IOException e) {

            System.out.println("Error saving message.");
        }
    }
}