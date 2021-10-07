package com.techelevator;

public class ChangeAccount {

    private int balance;  //multiply input by 100 - dont need to convert back to dollars since change doesn't include dollars
    private int quarter;
    private int dime;
    private int nickle;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
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

}
