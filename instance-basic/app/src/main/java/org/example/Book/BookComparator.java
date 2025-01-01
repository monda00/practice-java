package org.example.Book;

import java.util.*;

public class BookComparator implements Comparator<Book> {
  public int compare(Book b1, Book b2) {
    return b1.titile().compareTo(b2.titile());
  }
}
