package com.fed.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class map {
    public static void main(String[] args) {
        Path file = Paths.get("/Users/federickkwok/projects/fedtest/java/src/com/fed/streams/test.txt");

        // This is a test file
        // This test file is
        // a demo of flatmap

        try {
            Files.lines(file)
                    .map(e -> e.toUpperCase())
                    .map(e -> e.split("\\s+"))
                    .flatMap(a -> Arrays.stream(a))
                    .distinct()
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*try (Stream<String> stream = Files.lines(file)) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {
            Files.lines(file)
                    .map(e -> e.split("\\s+"))
                    .flatMap(array -> Arrays.stream(array))
                    .distinct()
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
