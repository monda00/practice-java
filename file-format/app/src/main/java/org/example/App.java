/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import java.io.*;
import java.util.*;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("perf");
        String capital = rb.getString("tokyo.capital");
        String food = rb.getString("tokyo.food");

        System.out.println("capital: " + capital);
        System.out.println("food: " + food);
    }
}
