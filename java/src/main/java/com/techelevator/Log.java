package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Date;


public class Log{
    public void writer ( String typesOfTransaction, double amount, double balance){

        LocalTime now = LocalTime.now();
        Format f = new SimpleDateFormat("MM/dd/yy hh:mm:ss");


        try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(new File("log.txt"),true))){


            String strDate = f.format(new Date());
            double newBalance = balance/100;
            String srtTypesOfTransaction = typesOfTransaction.toString();

            logWriter.println("> " + strDate + " " + " " + srtTypesOfTransaction
                    + " $" + String.format("%.2f", amount) + " " + " $" + String.format("%.2f", newBalance) + " ");

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

    }

}
