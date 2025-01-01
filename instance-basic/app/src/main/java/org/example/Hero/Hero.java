package org.example.Hero;

public class Hero {
  private String name;
  private int hp, mp;

  public Hero(String name, int hp, int mp) {
    this.name = name;
    this.hp = hp;
    this.mp = mp;
  }

  public String toString() {
    return "name: " + this.name + ", hp: " + this.hp + ", mp: " + this.mp;
  }

}
