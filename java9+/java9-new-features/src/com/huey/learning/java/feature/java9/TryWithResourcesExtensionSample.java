package com.huey.learning.java.feature.java9;

import java.util.Scanner;

public class TryWithResourcesExtensionSample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try (scanner) {

        }

    }

}
