package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StockNew {

    public static final int SLOT_LOCATION = 0;
    public static final int SLOT_NAME = 1;
    public static final int SLOT_PRICE = 2;
    public static final int SLOT_TYPE = 3;

    public Map<String, Product> getInventory() {
        File inventoryFile = new File("vendingmachine.csv");

        Map<String, Product> vendingMachineInventory = new HashMap<>();

        try (Scanner stockImporter = new Scanner(inventoryFile)) {
            while (stockImporter.hasNextLine()) {
                String line = stockImporter.nextLine();

                String[] stockImporterArray = line.split("|");
              //TODO: Consider re-factor
                if (stockImporterArray[SLOT_LOCATION].contains("A")) {
                    Double cash = (Double.valueOf(stockImporterArray[SLOT_PRICE]) * 100);
                    ChipsProduct chipSlot = new ChipsProduct(stockImporterArray[SLOT_LOCATION], stockImporterArray[SLOT_NAME],Integer.parseInt(String.valueOf(cash)), stockImporterArray[SLOT_TYPE]);
                    vendingMachineInventory.put(stockImporterArray[SLOT_LOCATION], chipSlot);
                }

                if (stockImporterArray[SLOT_LOCATION].contains("B")) {
                    Double cash = (Double.valueOf(stockImporterArray[SLOT_PRICE]) * 100);
                    CandyProduct candySlot = new CandyProduct(stockImporterArray[SLOT_LOCATION], stockImporterArray[SLOT_NAME],Integer.parseInt(String.valueOf(cash)), stockImporterArray[SLOT_TYPE]);
                    vendingMachineInventory.put(stockImporterArray[SLOT_LOCATION], candySlot);
                }

                if (stockImporterArray[SLOT_LOCATION].contains("C")) {
                    Double cash = (Double.valueOf(stockImporterArray[SLOT_PRICE]) * 100);
                    BeverageProduct bevSlot = new BeverageProduct(stockImporterArray[SLOT_LOCATION], stockImporterArray[SLOT_NAME], Integer.parseInt(String.valueOf(cash)), stockImporterArray[SLOT_TYPE]);
                    vendingMachineInventory.put(stockImporterArray[SLOT_LOCATION], bevSlot);
                }

                if (stockImporterArray[SLOT_LOCATION].contains("D")) {
                    Double cash = (Double.valueOf(stockImporterArray[SLOT_PRICE]) * 100);
                    GumProduct gumSlot = new GumProduct(stockImporterArray[SLOT_LOCATION], stockImporterArray[SLOT_NAME], Integer.parseInt(String.valueOf(cash)), stockImporterArray[SLOT_TYPE]);
                    vendingMachineInventory.put(stockImporterArray[SLOT_LOCATION], gumSlot);
                }
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return vendingMachineInventory;
    }
}

