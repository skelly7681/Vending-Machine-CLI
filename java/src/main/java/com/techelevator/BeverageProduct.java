package com.techelevator;

public class BeverageProduct extends Product{

    public BeverageProduct(String name, int price){
        super(name,price);
    }
    public String getSound(){
        return "Glug Glug, Yum!";
    }
}
