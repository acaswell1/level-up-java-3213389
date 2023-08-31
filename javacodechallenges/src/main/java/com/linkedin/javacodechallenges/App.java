package com.linkedin.javacodechallenges;

import java.util.List;
import java.lang.Math;

public class App {
    public static double calculateAverageChangeInvested(List<Double> purchases) {
        int num_purchases = purchases.size();

        if (num_purchases == 0) {
            return 0.0;
        } 

        double changeInvested = 0.0;

        for (double purchase : purchases) {
            changeInvested += (Math.ceil(purchase) - purchase);
        } 
        
        return changeInvested / num_purchases;
    }

    public static void main(String[] args) {
        List<Double> purchases = List.of(12.38, 38.29, 5.27, 3.21);
        System.out.println(calculateAverageChangeInvested(purchases));
    }
}
