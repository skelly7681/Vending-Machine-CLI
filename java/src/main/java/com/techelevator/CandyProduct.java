package com.techelevator;

public class CandyProduct extends Product{

    public CandyProduct(String slotLocation, String name, int price, String type){
        super(slotLocation,name,price,type);
    }
    public String getSound(){
        return "Munch Munch, Yum!";
    }
}
