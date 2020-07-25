package com.fed.basics;

public class Generics<T extends Number> {

    T whatever;

    Generics(T whatever) {
        this.whatever = whatever;
    }

    void printIt() {
        System.out.println(whatever.intValue() * 2);
    }
}
