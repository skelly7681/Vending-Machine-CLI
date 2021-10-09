package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Stock {

    public static final int SLOT_LOCATION = 0;
    public static final int SLOT_NAME = 1;
    public static final int SLOT_PRICE = 2;
    public static final int SLOT_TYPE = 3;

    public Map<String, List<Product>> getInventory() {
        File inventoryFile = new File("vendingmachine.csv");

        Map<String, List<Product>> vendingMachineInventory = new TreeMap<>();

        try (Scanner stockImporter = new Scanner(inventoryFile)) {
            while (stockImporter.hasNextLine()) {
                String line = stockImporter.nextLine();

                String[] stockImporterArray = line.split("\\|");
                //TODO: Consider re-factor
                if (stockImporterArray[SLOT_LOCATION].contains("A")) {
                    Double cash = (Double.valueOf(stockImporterArray[SLOT_PRICE]) * 100);
                    ChipsProduct chipSlot = new ChipsProduct(stockImporterArray[SLOT_LOCATION], stockImporterArray[SLOT_NAME], cash.intValue(), stockImporterArray[SLOT_TYPE]);
                    List<Product> chipSlotList = new ArrayList<>();
                    for(int i=0; i <5; i++){
                        //ChipsProduct listArray = new ChipsProduct(SLOT_LOCATION, SLOT_NAME, cash, SLOT_TYPE);
                        chipSlotList.add(chipSlot);
                    }
                    vendingMachineInventory.put(stockImporterArray[ SLOT_LOCATION], chipSlotList);
                }

                if (stockImporterArray[SLOT_LOCATION].contains("B")) {
                    Double cash = (Double.valueOf(stockImporterArray[SLOT_PRICE]) * 100);
                    CandyProduct candySlot = new CandyProduct(stockImporterArray[SLOT_LOCATION], stockImporterArray[SLOT_NAME],cash.intValue(), stockImporterArray[SLOT_TYPE]);
                    List<Product> candySlotList = new ArrayList<>();
                    for(int i=0; i <5; i++){
                        candySlotList.add(candySlot);
                    }
                    vendingMachineInventory.put(stockImporterArray[SLOT_LOCATION], candySlotList);
                }

                if (stockImporterArray[SLOT_LOCATION].contains("C")) {
                    Double cash = (Double.valueOf(stockImporterArray[SLOT_PRICE]) * 100);
                    BeverageProduct bevSlot = new BeverageProduct(stockImporterArray[SLOT_LOCATION], stockImporterArray[SLOT_NAME], cash.intValue(), stockImporterArray[SLOT_TYPE]);
                    List<Product> bevSlotList = new ArrayList<>();
                    for(int i=0; i <5; i++){
                        bevSlotList.add(bevSlot);
                    }
                    vendingMachineInventory.put(stockImporterArray[SLOT_LOCATION], bevSlotList);
                }

                if (stockImporterArray[SLOT_LOCATION].contains("D")) {
                    Double cash = (Double.valueOf(stockImporterArray[SLOT_PRICE]) * 100);
                    GumProduct gumSlot = new GumProduct(stockImporterArray[SLOT_LOCATION], stockImporterArray[SLOT_NAME], cash.intValue(), stockImporterArray[SLOT_TYPE]);
                    List<Product> gumSlotList = new ArrayList<>();
                    for(int i=0; i <5; i++){
                        gumSlotList.add(gumSlot);
                    }
                    vendingMachineInventory.put(stockImporterArray[SLOT_LOCATION], gumSlotList);
                }
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return vendingMachineInventory;
    }
}

