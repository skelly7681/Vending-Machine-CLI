package com.techelevator;

public class ChipsProduct extends Product{

    public ChipsProduct(String name, int price){
        super(name,price);
    }

    public String getSound(){
        return "Crunch Crunch, Yum!";
    }

}
