package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ClassView sv = new ClassView(new Scanner(System.in), new ClassDAOImpl());

        while (true) {

            sv.controller();

           }
        }
}
