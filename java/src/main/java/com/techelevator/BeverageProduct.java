package com.techelevator;

public class BeverageProduct extends Product{

    public BeverageProduct(String slotLocation, String name, int price, String type){
        super(slotLocation,name,price,type);
    }
    public String getSound(){
        return "Glug Glug, Yum!";
    }
}
