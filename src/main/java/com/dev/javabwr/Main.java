package com.dev.javabwr;

import com.dev.javabwr.PTable;

public class Main {
    public static void main(String[] args) {
        PTable element = PTable.URANIUM;
        System.out.println("name: " + element.getName());
        System.out.println("Z: " + element.getAtomicNumber());
    }
}