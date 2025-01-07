package org.example;

public class Item {
  private String name;
  private int price;
  private int weight;

  public Item(String name, int price, int weight) {
    this.name = name;
    this.price = price;
    this.weight = weight;
  }

  // getter
  public String name() {
    return this.name;
  }

  public int price() {
    return this.price;
  }

  public int weight() {
    return this.weight;
  }

  // setter
  public void name(String name) {
    this.name = name;
  }

  public void price(int price) {
    this.price = price;
  }

  public void weight(int weight) {
    this.weight = weight;
  }
}
