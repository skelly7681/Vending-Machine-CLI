package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VendingMachine {

    ChangeAccount vmChangeAccount = new ChangeAccount() {
    };
    List<Product> chipSlotList = new ArrayList<>();
    Map<String, List<Product>> vendingMachineInventory = new TreeMap<>();
    Log writer = new Log();


    public VendingMachine(Map<String, List<Product>> vendingMachineInventory) {
        this.vendingMachineInventory = vendingMachineInventory;
    }

    public VendingMachine() {
    }


    public void displayInventory() {
        for (Map.Entry<String, List<Product>> entry : vendingMachineInventory.entrySet()) {
            String key = entry.getKey();
            List<Product> value = entry.getValue();
            if (value.size() == 1) {
                System.out.println(key + " Product Out of stock");
            } else {
                //TODO //why is this printing memory reference
            }
            if (value.size() == 0) {

                System.out.println("Sold Out!");
            } else {

                System.out.println(key + " " + value.get(0).getName() + " " + value.get(0).getPrice() + " " + value.size());
            }
        }
    }


    public void purchase(String chosenProduct) {


        //checks inventory for userinput which equals chosenProduct
        if (vendingMachineInventory.containsKey(chosenProduct)) {
            if (vendingMachineInventory.get(chosenProduct).size() < 1) {
                System.out.println("Sorry out of stock");
            }

            if (vendingMachineInventory.get(chosenProduct).size() >= 1) {
                if (vmChangeAccount.getBalance() >= (vendingMachineInventory.get(chosenProduct).get(0).price)) {
                    vmChangeAccount.decreaseBalance(vendingMachineInventory.get(chosenProduct).get(0).price);
                } else {
                    System.out.println("Not enough money");
                }
            }
        }
        System.out.println("Your balance is " + vmChangeAccount.getBalance());
    }

    public void feedMoney(int value) {
        vmChangeAccount.insertMoney(value);
        String typeOfTransaction = "Feed Money";
        if(value == 1) {
            writer.writer(typeOfTransaction, vmChangeAccount.balance);
        }
    }

    public void writer ( String typesOfTransaction, int amount, int balance){

        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(new File("log.txt"),true))){

            String printToday = today.toString();
            String printTime = now.toString();
            int printAmount = amount;
             int printBalance = vmChangeAccount.balance;
            String printTypesOfTransaction = typesOfTransaction.toString();
            System.out.println(printToday);

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

    }

}