package com.techelevator;

public class ChipsProduct extends Product{

    public ChipsProduct(String slotLocation, String name, int price, String type){
        super(slotLocation,name,price,type);
    }

    public String getSound(){
        return "Crunch Crunch, Yum!";
    }

}
