package com.example.sampleapispringboot.service;

import com.example.sampleapispringboot.model.Item;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
  private List<Item> allItems = new ArrayList<>(Arrays.asList(new Item("10001", "itemA", "categoryA"),
      new Item("10002", "itemB", "categoryB"),
      new Item("10003", "itemC", "categoryC"),
      new Item("10004", "itemD", "categoryD"),
      new Item("10005", "itemE", "categoryE")));

  public List<Item> getAllItems() {
    return allItems;
  }

  public Item getItem(String itemId) {
    for (int i = 0; i < allItems.size(); i++) {
      if (allItems.get(i).getItemId().equals(itemId)) {
        return (Item) allItems.get(i);
      }
    }
    return null;
  }

  public void addItem(Item item) {
    allItems.add(item);
  }

  public void updateItem(String itemId, Item item) {
    for (int i = 0; i < allItems.size(); i++) {
      if (allItems.get(i).getItemId().equals(itemId)) {
        allItems.set(i, item);
      }
    }
  }

  public void deleteItem(String itemId) {
    allItems.removeIf(i -> i.getItemId().equals(itemId));
  }
}
