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
    public void writer ( String typesOfTransaction, int amount, int balance){

        LocalTime now = LocalTime.now();
        Format f = new SimpleDateFormat("MM/dd/yy");

        try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(new File("log.txt"),true))){


            String strDate = f.format(new Date());
            String strTime = now.toString();
            String srtAmount = String.valueOf(amount);
            String srtBalance = String.valueOf(balance/100);
            String srtTypesOfTransaction = typesOfTransaction.toString();

            logWriter.print("> " + strDate + " " + strTime + " " + srtTypesOfTransaction
                    + " $" + srtAmount + " " + " $" + srtBalance + " ");

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

    }
}
