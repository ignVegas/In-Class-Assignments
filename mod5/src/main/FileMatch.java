package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileMatch {
    public static void main(String[] args) {
        try (ObjectInputStream oldInput = new ObjectInputStream(new FileInputStream("old.xml"));
             ObjectInputStream transactionInput = new ObjectInputStream(new FileInputStream("transaction.xml"));
             ObjectOutputStream newOutput = new ObjectOutputStream(new FileOutputStream("new.xml"))) {
            Account account1 = (Account) oldInput.readObject();
            Account account2 = (Account) oldInput.readObject();

            while (true) {
                try {
                    TransactionRecord transaction = (TransactionRecord) transactionInput.readObject();
                    account1.combine(transaction);
                    account2.combine(transaction);
                } catch (IOException | ClassNotFoundException e) {
                    break;
                }
            }
            newOutput.writeObject(account1);
            newOutput.writeObject(account2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
