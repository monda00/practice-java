package org.example;

import java.io.*;
import java.net.*;

public class SendMail {
  public static void main(String[] args) throws Exception {
    Socket sock = new Socket("smtp.example.com", 60025);
    OutputStream os = sock.getOutputStream();

    os.write("HELO smtp.example.com\r\n".getBytes());
    os.write("MAIL FROM: asaka@example.com\r\n".getBytes());
    os.write("RCPT TO: minato@example.com\r\n".getBytes());

    os.flush();
    sock.close();
  }
}
