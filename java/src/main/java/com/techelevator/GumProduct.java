package com.techelevator;

public class GumProduct extends Product{
    public GumProduct(String slotLocation, String name, int price, String type){
        super(slotLocation,name,price,type);
    }
    public String getSound(){
        return "Chew Chew, Yum!";
    }
}
