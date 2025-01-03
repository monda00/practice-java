package org.example.Launcher;

import java.lang.reflect.*;

public class Launcher {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide two arguments.");
            return;
        }

        String fqcn = args[0];
        String sw = args[1];

        showMemory();

        try {
          Class<?> clazz = Class.forName(fqcn);
          listMethods(clazz);
          if (sw.equals("E")) {
            launchExternal(clazz);
          } else if (sw.equals("I")) {
            launchInternal(clazz);
          } else {
            throw new IllegalArgumentException(
              "Illegal argument"
            );
          }
        } catch (Exception e) {
          System.out.println(e.getMessage());
          e.printStackTrace();
          System.exit(1);
        }
        showMemory();
        System.exit(0);
    }

    public static void listMethods(Class<?> clazz) {
      System.out.println("Methods for " + clazz.getName());
      Method[] methods = clazz.getDeclaredMethods();
      for (Method m : methods) {
        System.out.println(m.getName());
      }
    }

    public static void launchExternal(Class<?> clazz) throws Exception {
      ProcessBuilder pb = new ProcessBuilder("java", clazz.getName());
      Process proc = pb.start();
      proc.waitFor();
    }

    public static void launchInternal(Class<?> clazz) throws Exception {
      Method m = clazz.getMethod("main", String[].class);
      String[] args = {};
      m.invoke(null, (Object)args);
    }

    public static void showMemory() {
      long free = Runtime.getRuntime().freeMemory();
      long total = Runtime.getRuntime().totalMemory();
      long usage = (total - free) / 1024 / 1024;
      System.out.println("Usage memory: " + usage);
    }
}
