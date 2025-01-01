package org.example.Book;

import java.util.*;

public class Book implements Comparable<Book>, Cloneable {
  private String titile;
  private Date publishDate;
  private String Comment;

  public Book(String titile, Date publishDate, String Comment) {
    this.titile = titile;
    this.publishDate = publishDate;
    this.Comment = Comment;
  }

  public String titile() {
    return this.titile;
  }

  public void setTitile(String titile) {
    this.titile = titile;
  }

  public Date publishDate() {
    return this.publishDate;
  }

  public void setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
  }

  public String comment() {
    return this.Comment;
  }

  public void setComment(String Comment) {
    this.Comment = Comment;
  }

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }

    Book b = (Book) o;
    if (!this.titile().equals(b.titile()) || !this.publishDate().equals(b.publishDate())) {
      return false;
    }

    return true;
  }

  public int hashCode() {
    return Objects.hash(this.titile, this.publishDate);
  }

  public int compareTo(Book o) {
    if (this.publishDate().before(o.publishDate())) {
      return -1;
    }
    if (this.publishDate().after(o.publishDate())) {
      return 1;
    }
    return 0;
  }

  public Book clone() {
    Book b = new Book(this.titile(), this.publishDate(), this.comment());
    return b;
  }
}
