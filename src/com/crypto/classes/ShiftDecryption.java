package com.crypto.classes;

public class ShiftDecryption implements Decryption{

    @Override
    public String decrypt(String encryptedText, byte key) {

        String plainText= "";
        //şifrelenmiş texti harf harf dolaşır.
        //her harfin ascii karşılığını alır. daha sonra belirtilen key ile shift
        //şifre çözme algoritmasına göre belirtilen keyin 26'ya modu alınır ve çıkan sonuç 26'dan çıkarılır
        //daha sonra elde edilen sonuçla şifreli harfin ascii değeri toplanır ve tekrardan 26'ya modu alınır.
        //Elde edilen sonuc bu normal harfin ascii değeridir. Bu değeri harfe dönüştürüp art arda
        //ekleyerek şifresi çözülmüş texti oluşturur.
        for (char character : encryptedText.toCharArray()) {
            if (character != ' ') {
                int position = character - 'a';
                int newPosition = (position + (26 - (key % 26))) % 26;
                char newCharacter = (char) ('a' + newPosition);
                plainText += newCharacter;
            } else {
                plainText += character;
            }
        }
        return plainText;
    }

}
