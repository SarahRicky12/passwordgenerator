package edu.guilford;


public class Password 
{
    public static void main( String[] args )
    {


    //Instantiate two User objects and uses the gatherInfo method to gather the information for each user.
    User user1 = new User();
    user1.gatherInfo();

    User user2 = new User();
    user2.gatherInfo();

    //Create passwords using the generatePassword method for each user.
    user1.setPassword(user1.generatePassword());
    user2.setPassword(user2.generatePassword());

    //Print out both passwords
    System.out.println("User 1's password is: " + user1.generatePassword());
    System.out.println("User 2's password is: " + user2.generatePassword());

    //Creating secret keys for each user 
    String secretKey = user1.getPassword().substring(user1.getPassword().length() - 8); //This makes the secret key the last 8 characters of the password
    String secretKey2 = user2.getPassword().substring(user2.getPassword().length() - 8); //This makes the secret key the last 8 characters of the password

    //Print out both secret keys
    System.out.println("User 1's secret key is: " + secretKey);
    System.out.println("User 2's secret key is: " + secretKey2);

    //Encrypting the passwords using the secret keys
    String encryptedPassword = AES.encrypt(user1.getPassword(), secretKey);
    String encryptedPassword2 = AES.encrypt(user2.getPassword(), secretKey2);

    //Print out both encrypted passwords
    System.out.println("User 1's encrypted password is: " + encryptedPassword);
    System.out.println("User 2's encrypted password is: " + encryptedPassword2);

    //Decrypting the passwords using the secret keys
    String decryptedPassword = AES.decrypt(encryptedPassword, secretKey);
    String decryptedPassword2 = AES.decrypt(encryptedPassword2, secretKey2);

    //Print out both decrypted passwords
    System.out.println("User 1's decrypted password is: " + decryptedPassword);
    System.out.println("User 2's decrypted password is: " + decryptedPassword2);

    




        
    }
}
