/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.example.Hero.Hero;
import org.example.Book.Book;
import org.example.Book.BookComparator;
import org.example.Monster.Monster;
import java.util.*;
import java.util.Calendar;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Hero hero = new Hero("Hero", 100, 50);

        System.out.println(hero);
        System.out.println(new App().getGreeting());

        Calendar cal = Calendar.getInstance();

        cal.set(2023, Calendar.DECEMBER, 1);
        Book book1 = new Book("Java", cal.getTime(), "Bad");

        cal.set(2023, Calendar.NOVEMBER, 1);
        Book book2 = new Book("Java Basic", cal.getTime(), "Good");
        System.out.println(book1.equals(book2));


        List<Book> books = new ArrayList<>();

        cal.set(2023, Calendar.MARCH, 1);
        Book book3 = new Book("C++", cal.getTime(), "Bad");

        cal.set(2023, Calendar.APRIL, 1);
        Book book4 = new Book("Java Basic", cal.getTime(), "Good");

        cal.set(2023, Calendar.MAY, 1);
        Book book5 = new Book("Go", cal.getTime(), "Bad");

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        System.out.println("Before sort");
        for (Book book : books) {
            System.out.println("title: " + book.titile() + ", publishDate: " + book.publishDate() + ", comment: " + book.comment());
        }
        System.out.println("After sort");
        Collections.sort(books);
        for (Book book : books) {
            System.out.println("title: " + book.titile() + ", publishDate: " + book.publishDate() + ", comment: " + book.comment());
        }

        System.out.println("After sort by BookComparator");
        Collections.sort(books, new BookComparator());
        for (Book book : books) {
            System.out.println("title: " + book.titile() + ", publishDate: " + book.publishDate() + ", comment: " + book.comment());
        }
        Monster monster = new Monster("Monster", 100, false);
        System.out.println(monster);
    }
}
