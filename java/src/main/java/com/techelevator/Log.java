package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.io.PrintWriter;
import java.io.FileNotFoundException;


public class Log {
    public void log( String typesOfTransaction, int amount, ){

        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(new File("log.txt"),true))){

            String printToday = today.toString();
            String printTime = now.toString();
//            int printAmount = amount.toString();
//            int printBalance = balance.toString();
            String printTypesOfTransaction = typesOfTransaction.toString();




        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

    }
}
