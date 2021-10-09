package com.techelevator;

public class ChangeAccount {

    public int balance;
    private int quarter;
    private int dime;
    private int nickle;

    public ChangeAccount(){};

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void insertMoney(int amount) {
        if (amount == 1 || amount == 2 || amount == 5 || amount == 10) {
            this.balance += amount * 100;
            System.out.println(amount + " dollars accepted your balance is " + balance/100 + " dollars");
        } else {
            System.out.println("Wrong form of tender");

        }
    }

    public String makeChange() {
        int quarters = 0;
        int dimes = 0;
        int nickles = 0;

        while(balance >=25){
            quarters++;
            balance -= 25;
        } while (balance >=10){
            dimes++;
            balance -=10;
        } while (balance >= 5){
            nickles++;
            balance -=5;
        }
        return "Your change is " + quarters + " quarters, " + dimes + " dimes, " + nickles + " nickles.";
    }

    public void decreaseBalance(int price){
        balance -= price;
    }

}
