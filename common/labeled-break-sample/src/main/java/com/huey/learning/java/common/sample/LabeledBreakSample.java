package com.huey.learning.java.common.sample;

import org.apache.commons.math3.primes.Primes;

/**
 * @author huey
 */
public class LabeledBreakSample {

    public static void main(String[] args) {

        int[][] numbers = createNumbers();

        // declares the label
        primeLabel:
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {

                if (Primes.isPrime(numbers[i][j])) {
                    System.out.println("Finds the first prime number: " + numbers[i][j]);
                    // labeled break
                    break primeLabel;
                }

            }
        }

        // does other things...

    }

    private static int[][] createNumbers() {
        return new int[][] {
                {10, 58, 49, 77, 24},
                {63, 45, 66, 91, 36},
                {44, 23, 84, 35, 19},
                {96, 72, 54, 30, 27},
                {67, 81, 26, 15, 49}
        };
    }

}
