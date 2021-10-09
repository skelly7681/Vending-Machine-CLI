package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VendingMachine {

    ChangeAccount vmChangeAccount = new ChangeAccount(){};
    List<Product> chipSlotList = new ArrayList<>();
    Map<String, List<Product>> vendingMachineInventory = new TreeMap<>();


    public VendingMachine(Map<String, List<Product>> vendingMachineInventory) {
        this.vendingMachineInventory = vendingMachineInventory;
    }

    public VendingMachine() {
    }

    public void displayInventory() {
        for (Map.Entry<String, List<Product>> entry : vendingMachineInventory.entrySet()) {
            String key = entry.getKey();
            List value = entry.getValue();
            if (value.size() == 1) {
                System.out.println(key + " Product Out of stock");
            } else {
                //TODO //why is this printing memory reference
            }
            System.out.println(key + " " + value.subList(0, 1) + " " + (value.size()));
        }
    }


    public void purchase(String chosenProduct) {
        int thisBalance = vmChangeAccount.getBalance();

        //checks inventory for userinput which equals chosenProduct
        if (vendingMachineInventory.containsKey(chosenProduct)) {
            if (vendingMachineInventory.get(chosenProduct).size() < 1) {
                System.out.println("Sorry out of stock");
            }

            if (vendingMachineInventory.get(chosenProduct).size() >= 1) {
                if (thisBalance > (vendingMachineInventory.get(chosenProduct).get(0).price) ) {
                    thisBalance = vmChangeAccount.getBalance() - (vendingMachineInventory.get(chosenProduct).get(0).price);

                } else {
                    System.out.println("Not enough money");
                }
            }
        }
        System.out.println("Your balance is " + thisBalance);
    }

}