package com.crypto.classes;


public class BinaryEncryption implements Encryption{
    @Override
    public String encrypt(String plainText, byte key) {
        String encryptedText = "";
        for (int i = 0; i < plainText.length(); i++) {
            //girilen texti harf harf alır ve verilen key ile her bir harfi xor işlemine sokar;
            //bu işlemin sonucunda harfleri şifrelenmiş harf haline getirir.
            //ve bu harfleri art arda ekleyerek şifrelenmiş texti oluşturur.
            encryptedText += Character.toString((char) (plainText.charAt(i) ^ key));
        }
        return encryptedText;
    }


}
