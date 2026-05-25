/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject3;

/**
 *
 * @author shephi
 */
import java.util.Scanner;



public class Mavenproject3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        Login user = new Login(firstName, lastName);

        String username = "";
        String password = "";
        String phoneNumber = "";
        String message = "";

        // registration attempts
        for (int attempt = 1; attempt <= 3; attempt++) {

            System.out.println("\n--- REGISTRATION ATTEMPT " + attempt + " ---");

            System.out.print("Enter username: ");
            username = input.nextLine();

            System.out.print("Enter password: ");
            password = input.nextLine();

            System.out.print("Enter SA phone number (+27): ");
            phoneNumber = input.nextLine();

            message = user.registerUser(username, password, phoneNumber);

            System.out.println(message);

            if (message.equals("User has been registered successfully.")) {
                break;
            }
        }

        // login attempts
        boolean success = false;

        for (int attempt = 1; attempt <= 3; attempt++) {

            System.out.println("\n--- LOGIN ATTEMPT " + attempt + " ---");

            System.out.print("Enter username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = input.nextLine();

            success = user.loginUser(loginUsername, loginPassword);

            System.out.println(user.returnLoginStatus(success));

            if (success) {
                System.out.println("Menu");
                System.out.println("option 1) Send Messages");
                System.out.println("option 2) recently sent messages ");
                System.out.println("option 3) Exit");
                
                int choice = input.nextInt();
                
                switch(choice){
                
                    case 1:
                        MessageSystem w = new MessageSystem();
                    w.sendMessages();
                        break;
                    
                    case 2:  
                        System.out.println("Coming soon!!");
                        break;
                    case 3:
                        System.exit(0);
                        break;
                        
                    default:
                        break;
                        
                }
                
                break;
            }
        }

        input.close();
    }
}