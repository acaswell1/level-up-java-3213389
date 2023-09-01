package com.linkedin.javacodechallenges;

import java.io.File;
import java.io.FileReader;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.RowFilter.Entry;

import org.javatuples.Pair;

import au.com.bytecode.opencsv.CSVReader;

public class App {

    private static String csv_location = "ticketholders.csv";

    private static Map<String, Integer> processCSV() {
        Map<String, Integer> admitees = new HashMap<>();

        try (CSVReader reader = new CSVReader(new FileReader(csv_location))) {
            String[] nextLine;
            nextLine = reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                admitees.put(nextLine[0], Integer.parseInt(nextLine[1]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return admitees;
    }

    private static Pair<String, Integer> patron() {
        System.out.println("Please enter your full name and # tickets purchased (e.g. Fname Lname, #tickets)");
        Scanner scanner = new Scanner(System.in);

        scanner.useDelimiter("\\W");

        String fname = scanner.next();
        ;
        String lname = scanner.next();
        String name = fname + " " + lname;
        scanner.next();
        int ticket_num = scanner.nextInt();

        scanner.close();

        return new Pair<>(name, ticket_num);
    }

    public static void main(String[] args) {
        Pair<String, Integer> patron_to_check = patron();
        Map<String, Integer> patrons_with_tickets = processCSV();

        if (patrons_with_tickets.containsKey(patron_to_check.getValue0())) {
            int ticktes_bought = patrons_with_tickets.get(patron_to_check.getValue0());
            int tickets_requested = patron_to_check.getValue1();

            if (ticktes_bought >= tickets_requested) {
                System.out.println("Thank you for your patronage, here are your " + tickets_requested + " ticket(s).");
            } else {
                System.out.println("Thank you for your patronage, unfortunatley you have only purchased "
                        + ticktes_bought + " ticket(s).");
            }
        } else {
            System.out.println("Sorry for the inconvienece, but you must purchase tickets prior to arrival.");
        }
    }
}
