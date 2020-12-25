package com.crypto.classes;

public class General implements Listener{

    private ShiftDecryption shiftDecryption;

    General(){
        this.shiftDecryption = new ShiftDecryption();
    }

    @Override
    public void update(String s, byte key) {
        System.out.println("General class encrypted text : "+s);
        String original = shiftDecryption.decrypt(s,key);
        System.out.println("General class original text : "+original);
    }
}
