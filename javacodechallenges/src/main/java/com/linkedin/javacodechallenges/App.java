package com.linkedin.javacodechallenges;

import java.util.Date;
import java.util.Arrays;

public class App {
    private static String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
            "Dec" };
    private static int[] days_p_month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        }
        return true;
    }

    private static String rest_of_the_month() {
        String[] now = (new Date()).toString().split(" ");
        String month = now[1];
        int day = Integer.parseInt(now[2]);
        int year = Integer.parseInt(now[5]);

        int month_val = Arrays.asList(months).indexOf(month);

        int total_days = 0;
        if (month_val == 2 && isLeapYear(year)) {
            total_days = 29 - day;
        } else {
            total_days = days_p_month[month_val] - day;
        }

        while (total_days + days_p_month[((month_val + 1) % 12)] < 100) {
            month_val = ((month_val + 1) % 12);
            total_days += days_p_month[month_val];
        }

        month_val = ((month_val + 1) % 12);
        int date = 100 - total_days;
        String date_in_100_days = months[month_val] + " " + (date);

        if (month_val <= 4) {
            if (month_val < 4) {
                year += 1;
            } else if (date <= 10 || (isLeapYear(year) && date <= 9)) {
                year += 1;
            }
        }

        return date_in_100_days + " " + year;
    }

    // Create function to calculate the date that's
    // 100 days from now
    public static String hundredDays() {
        return rest_of_the_month();
    }

    public static void main(String[] args) {
        System.out.println("100 days from now is... "
                + hundredDays());

    }
}
