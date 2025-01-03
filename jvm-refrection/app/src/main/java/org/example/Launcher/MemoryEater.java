package org.example.Launcher;

import java.util.*;

public class MemoryEater {
  public static void main(String[] args) {
    if (Locale.getDefault().getLanguage().equals("ja")) {
      System.out.println("メモリを食います");
    } else {
      System.out.println("Memory eater");
    }

    long[] l = new long[1280000];
    for (int i = 0; i < l.length; i++) {
      l[i] = i;
    }
  }
}
