package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VendingMachine {


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
                System.out.println(key + " Out of stock");
            } else {

            }
            System.out.println(key + " " + value.subList(0, 1) + " " + (value.size() - 1));
        }
    }
}