package com.crypto.classes;

import java.io.*;
import java.util.ArrayList;

public class Encrypter {


    private ArrayList<Listener> listeners; //list of references to its listeners.
    private ArrayList<Encryption> algorithms; //list of references to encryption algorithms.
    private ArrayList<Byte> keys; //list of encryption algorithms keys.
    private String text = "the attack will start at five am";
    private String filename;

    //Encrypter class constructor method
    Encrypter(String filename){
        listeners = new ArrayList<>(); // initialize listeners list
        algorithms = new ArrayList<>(); // initialize algorithm list
        keys = new ArrayList<>(); // initialize keys list
        this.filename = filename;
    }


    public void register(Encryption encryption, byte key, Listener listener){
        listeners.add(listener); // adds listener reference in listeners list
        algorithms.add(encryption);// adds encryption algorithm reference in algorithms list
        keys.add(key); //adds key in keys list
    }


    public void sendAll(){
        for(int i=0; i<listeners.size(); i++){
            Listener listener = listeners.get(i); // gets listener class from listeners list
            Encryption encryption = algorithms.get(i);// gets encryption class from algorithms list
            byte key = keys.get(i); //gets key from key list
            String plainText = getText();
            String encryptedText = encryption.encrypt(plainText,key); // encrypts the message using encryption class encrypt method and gets encrypted message
            listener.update(encryptedText,key); // notify listener classes
        }
    }


    //dosyadan texti okuyup geri döndüren metot
    private String  getText(){
        File file = new File(filename);
        FileInputStream fileInputStream = null;
        String text = "";
        try {
            fileInputStream = new FileInputStream(file);
            byte fileContent[] = new byte[(int)file.length()];
            fileInputStream.read(fileContent);
            text = new String(fileContent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }


    public void setFilename(String filename) {
        this.filename = filename;
    }
}
