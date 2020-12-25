package com.crypto.classes;

public class TestClass {

    public static void main(String[] args) {

        //Encrypter sınıfndan bir obje oluşturuyoruz ve constructor kısmına şifrelencek dosyanın adını giriyoruz
        //General ve spy sınıfından birer obje oluşturup encrypter objesine şifreleme türü ve keyleri ile kayıt ediyoruz.
        //encrypter sınıfını sendAll metodunu çağırdığımızda general ve spy sınıfları şifrelenmiş metinleri elde edecek ve
        // bu metinlerin şifresini çözüp ekrana yazdıracaktır.

        Encrypter encrypter = new Encrypter("test.txt");
        General general = new General();
        Spy spy = new Spy();
        encrypter.register(new ShiftEncryption(),(byte) 1,general);
        encrypter.register(new BinaryEncryption(),(byte) 'P',spy);
        encrypter.sendAll();

        encrypter.setFilename("test2.txt");
        encrypter.sendAll();

    }
}
