package com.techelevator;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

                System.out.println(key + " " + value.get(0).getName() + " " + Double.valueOf(value.get(0).getPrice())/100 + " " + value.size());
            }
        }
    }


    public void purchase(String chosenProduct) {
        //checks inventory for userinput which equals chosenProduct
        try {

            if (vendingMachineInventory.containsKey(chosenProduct)) {
                if (vendingMachineInventory.get(chosenProduct).size() < 1) {
                    System.out.println("Sorry out of stock");
                }

                if (vendingMachineInventory.get(chosenProduct).size() >= 1) {
                    if (vmChangeAccount.getBalance() >= (vendingMachineInventory.get(chosenProduct).get(0).price)) {
                        System.out.println("The cost is " + Double.valueOf(vendingMachineInventory.get(chosenProduct).get(0).price) / 100 + " dollars");
                        System.out.println("The item you have chosen is " + vendingMachineInventory.get(chosenProduct).get(0).getName());
                        System.out.println(vendingMachineInventory.get(chosenProduct).get(0).getSound());
                        vmChangeAccount.decreaseBalance(vendingMachineInventory.get(chosenProduct).get(0).price);
                        Product removed = vendingMachineInventory.get(chosenProduct).remove(0);
                    } else {
                        System.out.println("Not enough money");
                    }
                }
            }
            System.out.println("Your balance is " + Double.valueOf(vmChangeAccount.getBalance()) / 100);
        } catch (Exception e){
            System.out.println("Invalid Input, Choose Again.");
        }
    }

    public void feedMoney(int value) {
        vmChangeAccount.insertMoney(value);
        String typeOfTransaction = "Feed Money";
        if(value == 1) {
            audit(vmChangeAccount.balance, vmChangeAccount.balance, typeOfTransaction);
        }
    }

    public void finishTransaction(){

        vmChangeAccount.makeChange(vmChangeAccount.balance);

    }




//    public void writer ( String typesOfTransaction, int amount, int balance){
//
//        LocalDate today = LocalDate.now();
//        LocalTime now = LocalTime.now();
//
//        try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(new File("log.txt"),true))){
//
//            String printToday = today.toString();
//            String printTime = now.toString();
//            int printAmount = amount;
//             int printBalance = vmChangeAccount.balance;
//            String printTypesOfTransaction = typesOfTransaction.toString();
//            System.out.printf(printToday + printTime + printAmount + printBalance);
//
//        } catch (FileNotFoundException fileNotFoundException) {
//            fileNotFoundException.printStackTrace();
//        }

    public void audit(double originalBalance, double updatedBalance, String type) {
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        String dateAndTime = dateTime.format(LocalDateTime.now());
        File auditLog = new File("src/main/resources/log.txt");
        try(FileWriter writer = new FileWriter(auditLog, true)) {
            if(!auditLog.exists()) {
                auditLog.createNewFile();
            }
            writer.write(dateAndTime + " " + type + " $" + originalBalance + " $" + updatedBalance + "\n");
        } catch(IOException e) {
            System.err.println("Audit Log not created");
        }


    }

}