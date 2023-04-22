package edu.guilford;

public class User {

String firstName;
String lastName;
String userName;
int birthYear;
Boolean isMale;

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

public Boolean getIsMale() {
    return isMale;
}

public Boolean setIsMale() {
    return isMale;
}

//Constructor
public User(String firstName, String lastName, String userName, int birthYear, Boolean isMale) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.birthYear = birthYear;
    this.isMale = isMale;
}

}

