package com.fed.basics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class MapTest {

    public static void main(String[] args) {

        ClassLoader classLoader = MapTest.class.getClassLoader();
        Path file = null;

        System.out.println(classLoader);

        try {
            file = Paths.get(classLoader.getResource("test.txt").toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }

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
