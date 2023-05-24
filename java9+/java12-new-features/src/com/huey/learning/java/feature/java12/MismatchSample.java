package com.huey.learning.java.feature.java12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MismatchSample {

    public static void main(String[] args) throws IOException {

        Path filePath1 = Files.createTempFile("file1", ".txt");
        Path filePath2 = Files.createTempFile("file2", ".txt");
        Files.writeString(filePath1, "Java 12 New Features");
        Files.writeString(filePath2, "Java 12 New Features");

        long mismatch = Files.mismatch(filePath1, filePath2);
        assert mismatch == -1;

    }

}
