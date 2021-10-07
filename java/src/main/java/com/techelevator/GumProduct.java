package com.techelevator;

public class GumProduct extends Product{
    public GumProduct(String name, int price){
        super(name,price);
    }
    public String getSound(){
        return "Chew Chew, Yum!";
    }
}
