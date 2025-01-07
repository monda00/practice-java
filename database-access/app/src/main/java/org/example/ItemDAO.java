package org.example;

import java.sql.*;
import java.util.*;

public class ItemDAO {
  public static ArrayList<Item> findByMinimumPrice(int i) {
    try {
      Class.forName("org.h2.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    Connection con = null;
    try {
      con = DriverManager.getConnection("jdbc:h2:~/test");

      PreparedStatement pstmt = con.prepareStatement("SELECT * FROM ITEMS WHERE PRICE > ?");
      pstmt.setInt(1, i);
      ResultSet rs = pstmt.executeQuery();
      ArrayList<Item> items = new ArrayList<>();
      while (rs.next()) {
        String name = rs.getString("name");
        int price = rs.getInt("price");
        int weight = rs.getInt("weight");
        Item item = new Item(name, price, weight);
        items.add(item);
      }
      rs.close();
      pstmt.close();
      return items;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (con != null) {
        try {
          con.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
