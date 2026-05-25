/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mavenproject3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Delicia
 */
public class MessageSystemTest {
    
    public MessageSystemTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class MessageSystem.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MessageSystem.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMessages method, of class MessageSystem.
     */
    @Test
    public void testSendMessages() {
        System.out.println("sendMessages");
        MessageSystem.sendMessages();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkRecipientCell method, of class MessageSystem.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        String number = "";
        boolean expResult = false;
        boolean result = MessageSystem.checkRecipientCell(number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageID method, of class MessageSystem.
     */
    @Test
    public void testCreateMessageID() {
        System.out.println("createMessageID");
        String expResult = "";
        String result = MessageSystem.createMessageID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageHash method, of class MessageSystem.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        int messageNumber = 0;
        String message = "";
        String expResult = "";
        String result = MessageSystem.createMessageHash(messageNumber, message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeMessage method, of class MessageSystem.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        String messageID = "";
        String messageHash = "";
        String recipient = "";
        String message = "";
        MessageSystem.storeMessage(messageID, messageHash, recipient, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
