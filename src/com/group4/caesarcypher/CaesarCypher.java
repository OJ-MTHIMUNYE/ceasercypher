package com.group4.caesarcypher;

import javax.swing.JOptionPane;

/**
 *
 * @author Donald
 */
public class CaesarCypher {

    // String of alphabets from A-Z
    public static final String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";
    public static final int KEY = 3;

    public static void main(String[] args) {

        /* Setting up JOptionPae to get input from the user and send output to the user */
        String[] options = { "Encrypt", "Decrypt"};
        var selection = JOptionPane.showOptionDialog(null, "Encrypt or decrypt text:", "Caesar Cipher",
                0, 3, null, options, options[0]);
        if (selection == 0) {
            String plainTextInput=JOptionPane.showInputDialog(null,"Enter Plaintext :");

            JOptionPane.showMessageDialog(null, encryptText(plainTextInput, KEY) ,"Encrypted Ciphertext" , JOptionPane.INFORMATION_MESSAGE);
        }
        if (selection == 1) {
            String cipherTextInput=JOptionPane.showInputDialog(null,"Enter Ciphertext :");

            JOptionPane.showMessageDialog(null, decryptText(cipherTextInput, KEY) ,"Decrypted Plaintext" , JOptionPane.INFORMATION_MESSAGE);
        }

    }

    /**
     * method for encrypting user input plainText(string) with the given shift key(int/3)
     * will return encrypted cypherText(string)
     */
    private static String encryptText(String plainText, int key){

        //convert plain text to lowercase
        plainText = plainText.toLowerCase();

        //cypher text to store encypted data
        String cipherText = "";

        // looping through each alphabet of the plain text
        for (int i = 0; i < plainText.length(); i++)
        {
            // getting the position of each alphabet of plainText in ALPHABETS
            int pos = ALPHABETS.indexOf(plainText.charAt(i));

            // getting the position of the corresponding cypher alphabet in the ALPHABETS string
            int cipherPos = (key + pos) % 26;
            char cipherChar = ALPHABETS.charAt(cipherPos);

            // add encrypted char to encrypted string
            cipherText += cipherChar;
        }


        return cipherText;
    }



    /**
     * method for decrypting user input cipherText(string) with the given shift key(int/3)
     * will return decrypted plainText(string)
     */
    private static String decryptText(String cipherText, int key){

        //convert cipherText to lowercase
        cipherText = cipherText.toLowerCase();

        //plainText to store decypted data
        String plainText = "";

        // looping through each alphabet of the cipherText
        for (int i = 0; i < cipherText.length(); i++)
        {
            // getting the position of each alphabet of cipherText in ALPHABETS
            int pos = ALPHABETS.indexOf(cipherText.charAt(i));

            // getting the position of the corresponding plainText alphabet in the ALPHABETS string
            int plainTextPos = (pos - key) % 26;

            //adjust the position if it's negative
            if(plainTextPos < 0){
                plainTextPos = plainTextPos + ALPHABETS.length();
            }

            char plainTextChar = ALPHABETS.charAt(plainTextPos);

            // add encrypted char to encrypted string
            plainText += plainTextChar;
        }


        return plainText;
    }

}