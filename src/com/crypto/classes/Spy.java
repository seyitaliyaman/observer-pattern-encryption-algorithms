package com.crypto.classes;

public class    Spy implements Listener{

    private BinaryDecryption binaryDecryption;

    Spy(){
        this.binaryDecryption = new BinaryDecryption();
    }

    @Override
    public void update(String s,byte key) {
        System.out.println("Spy class encrypted text : "+s);
        String original = binaryDecryption.decrypt(s,key);
        System.out.println("Spy class original text : "+original);
    }
}
