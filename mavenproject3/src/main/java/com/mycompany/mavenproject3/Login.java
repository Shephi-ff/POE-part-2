/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

/**
 *
 * @author Shephi6
 */
class Login {

    private String storedUsername;
    private String storedPassword;
    private String storedPhoneNumber;
    private String firstName;
    private String lastName;

    public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Own method for username validation
    public boolean checkUserName(String username) {
        if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    // Own method for password validation
    public boolean checkPasswordComplexity(String password) {
        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        if (password.length() < 8) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }

        if (hasUpper && hasNumber && hasSpecial) {
            return true;
        } else {
            return false;
        }
    }

    // Own method for cellphone validation
    public boolean checkCellPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("^\\+27\\d{9}$")) {
            return true;
        } else {
            return false;
        }
    }

    // registerUser now handles all validations
    public String registerUser(String username, String password, String phoneNumber) {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted. Please try again.";
        } else if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted. Please try again.";
        } else if (!checkCellPhoneNumber(phoneNumber)) {
            return "Cell phone number incorrectly formatted. Please try again.";
        } else {
            storedUsername = username;
            storedPassword = password;
            storedPhoneNumber = phoneNumber;

            return "User has been registered successfully.";
        }
    }

    // loginUser for login stage
    public boolean loginUser(String username, String password) {
        if (username.equals(storedUsername) &&
                password.equals(storedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public String returnLoginStatus(boolean success) {
        if (success) {
            return "Welcome " + firstName + " " + lastName +
                    ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}