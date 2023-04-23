package edu.guilford;

/**
 *
 * @author bousabacw
 */
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    private static SecretKeySpec secretKey;
    private static byte[] key;


    //This method sets the key for the encryption and decryption
    public static void setKey(String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8"); //Converts the key to bytes 
            sha = MessageDigest.getInstance("SHA-1"); //Creates a SHA-1 hash to help with readability
            key = sha.digest(key); //Creates a digest of the key and stores it in the key variable
            key = Arrays.copyOf(key, 16); //Copies the key to a new array of length 16
            secretKey = new SecretKeySpec(key, "AES"); //Creates a new secret key using the key variable
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    //This method encrypts the password
    public static String encrypt(String strToEncrypt, String secret) {
        try {
            setKey(secret); //Sets the key as a secret key
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); //Creates a new cipher using the AES algorithm
            cipher.init(Cipher.ENCRYPT_MODE, secretKey); //Initializes the cipher to encrypt mode
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))); //Returns the encrypted password
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString()); //Prints an error message if the encryption fails
        }
        return null;
    }

    //This method decrypts the password
    public static String decrypt(String strToDecrypt, String secret) {
        try {
            setKey(secret); //Sets the key as a secret key
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING"); //Creates a new cipher using the AES algorithm
            cipher.init(Cipher.DECRYPT_MODE, secretKey); //Initializes the cipher to decrypt mode
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt))); //Returns the decrypted password
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString()); //Prints an error message if the decryption fails
        }
        return null;
    }
}
