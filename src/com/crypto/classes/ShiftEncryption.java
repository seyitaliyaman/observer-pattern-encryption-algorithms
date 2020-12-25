package com.crypto.classes;

public class ShiftEncryption implements Encryption{


    @Override
    public String encrypt(String plainText, byte key) {
        String encryptedText= "";

        //şifrelenecek texti harf harf dolaşır.
        //her harfin ascii karşılığını alır. daha sonra belirtilen key ile shift
        //şifreleme algoritmasına göre bu ascii değerlerinin toplamını 26'ya modunu alır
        //bu şifrelenmiş harfin ascii değeridir. Bu değeri harfe dönüştürüp art arda
        //ekleyerek şifrelenmiş texti oluşturur.
        for (char character : plainText.toCharArray()) {
            if (character != ' ') {
                int position = character - 'a';
                int newPosition = (position + key) % 26;
                char newCharacter = (char) ('a' + newPosition);
                encryptedText += newCharacter;
            } else {
                encryptedText += character;
            }
        }
        return encryptedText;
    }

}
