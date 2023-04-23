package edu.guilford;

import java.util.Scanner;

public class User {

Scanner scan = new Scanner(System.in);

//User attributes
private String firstName;
private String lastName;
private String userName;
private int birthYear;
private char middleInitial;
private String color;

//Password attribute
private String password;


//Getters and Setters for the attributes
public String getFirstName() {
    return firstName;
}
    
public String setFirstName() {
    return firstName;
}

public String getLastName() {
    return lastName;
}

public String setLastName() {
    return lastName;
}

public String getUserName() {
    return userName;
}

public String setUserName() {
    return userName;
}

public int getBirthYear() {
    return birthYear;
}

public int setBirthYear() {
    return birthYear;
}

public char getMiddleInitial() {
    return middleInitial;
}

public char setMiddleInitial() {
    return middleInitial;
}

public String getColor() {
    return color;
}

public String setColor() {
    return color;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

//Empty Constructor
public User() {
}

//Constructor
public User(String firstName, String lastName, String userName, int birthYear, char middleInitial, String color) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.birthYear = birthYear;
    this.middleInitial = middleInitial;
    this.color = color;
}

//A method that generates a password that is easy to remember, but hard to guess
public String generatePassword() {
    String password;
    password = userName + color + lastName.substring(0, 1) + middleInitial + birthYear;
    // this password is composed of the user's username, favorite color, the first letter of their last name, their middle initial, and then their birth year which will
    // be 4 digits long (ex. 1999)
    return password;
}


//Gather all information from the user using the Scanner class
public void gatherInfo() {

    System.out.println("Enter your first name:");
    firstName = scan.nextLine();

    System.out.println("Enter your last name:");
    lastName = scan.nextLine();

    System.out.println("Enter your username:");
    userName = scan.nextLine();

    System.out.println("Enter your birth year:");
    birthYear = scan.nextInt();

    System.out.println("Enter your middle initial:");
    middleInitial = scan.next().charAt(0);

    System.out.println("Enter your favorite color:");
    color = scan.next();
}

}
