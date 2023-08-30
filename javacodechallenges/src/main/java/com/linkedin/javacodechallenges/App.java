package com.linkedin.javacodechallenges;

import java.util.Scanner;
import java.lang.Math;

public class App {

    private static final int CCF = 748;

    public static double calculateWaterBill(double gallonsUsage) {
        int ccfs_used = (int) Math.ceil(gallonsUsage / CCF);
        int ccfs_to_charge_for = ccfs_used - 2;
        double additional_charges = 0.0;
        if (ccfs_to_charge_for >= 1) {
            additional_charges = ccfs_to_charge_for * 3.90;
        }

        return 18.84 + additional_charges;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many gallons of water did you " +
                "use this month?");
        double usage = scanner.nextDouble();
        System.out.println("Your water bill is " +
                calculateWaterBill(usage));
        scanner.close();
    }
}
