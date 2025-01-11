package org.example;

public class Bank {
  private String name;

  public String getName() {
    return this.name;
  }

  public void setName(String newName) {
    if (newName.length() < 3) {
      throw new IllegalArgumentException("Bank name must be longer than 3 characters.");
    }
    this.name = newName;
  }
}
