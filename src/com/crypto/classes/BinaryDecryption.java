package com.crypto.classes;

//binary decryption class
public class BinaryDecryption implements Decryption {
    @Override
    public String decrypt(String encryptedText, byte key) {
        String plainText = "";
        for (int i = 0; i < encryptedText.length(); i++) {
            //girilen texti harf harf alır ve verilen key ile her bir harfi xor işlemine sokar;
            //bu işlemin sonucunda şifrelenmiş harfler normal harf haline getirir.
            //ve bu harfleri art arda ekleyerek texti oluşturur.
            plainText += Character.toString((char) (encryptedText.charAt(i) ^ key));
        }
        return plainText;
    }
}
