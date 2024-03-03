package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class CreateTransactionFile {
    public static void main(String[] args) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("transaction.xml"))) {
            @SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
            System.out.println("Enter account number and amount:");
            while (true) {
                int accountNumber = scanner.nextInt();
                if (accountNumber == -1) {
                    break;
                }
                double amount = scanner.nextDouble();

                output.writeObject(new TransactionRecord(accountNumber, amount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
