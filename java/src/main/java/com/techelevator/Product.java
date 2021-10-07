package com.techelevator;

public abstract class Product {

    private String name;
    private int price;
    private String slotLocation;
    private String type;
    //count (can be put into inventory class)
    //abstract method for getsound to make sure children ints

    public abstract String getSound();

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public void setSlotLocation(String slotLocation) {
        this.slotLocation = slotLocation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
