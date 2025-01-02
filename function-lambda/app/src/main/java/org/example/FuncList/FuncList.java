package org.example.FuncList;

public class FuncList {
  public static boolean isOdd(int x) {
    return x % 2 == 1;
  }

  public String passCheck(int point, String name) {
    return name + " " + (point > 65 ? "OK" : "NG");
  }
}
