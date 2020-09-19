package com.huey.learning.java.exception.trywithresources;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author huey
 */
public class TryWithResourcesSample {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
