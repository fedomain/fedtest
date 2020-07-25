package com.fed.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        int i = 100;

        while (i != 0) {
            if (i % 5 == 0) {
                if (i % 5 != 0)
                System.out.println(i);
            }
            i--;
        }


    }

}
