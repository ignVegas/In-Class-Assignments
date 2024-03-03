package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CreateSequentialFile {
    public static void main(String[] args) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("old.xml"))) {
            // Create some sample Account objects and write them to the file
            output.writeObject(new Account(101, "Vegas", "Mantsch", 1234.0));
            output.writeObject(new Account(102, "Jasmine", "Smith", 1234.0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
