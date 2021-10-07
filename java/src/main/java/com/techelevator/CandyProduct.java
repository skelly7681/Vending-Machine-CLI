package com.techelevator;

public class CandyProduct extends Product{

    public CandyProduct(String name, int price){
        super(name,price);
    }
    public String getSound(){
        return "Munch Munch, Yum!";
    }
}
