package org.example;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class CopyFile {
  public static void main(String[] args) throws Exception {
    if (args.length < 2) {
      System.out.println("Please provide two arguments.");
      return;
    }

    String src = args[0];
    String dest = args[1];

    try(
      FileInputStream fis = new FileInputStream(src);
      FileOutputStream fos = new FileOutputStream(dest);
      BufferedOutputStream bos = new BufferedOutputStream(fos);
      GZIPOutputStream gzos = new GZIPOutputStream(bos);
    ) {
      int i = fis.read();
      while (i != -1) {
        gzos.write(i);
        i = fis.read();
      }
      gzos.flush();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
