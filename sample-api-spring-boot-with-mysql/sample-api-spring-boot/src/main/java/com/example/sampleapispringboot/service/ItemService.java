package com.example.sampleapispringboot.service;

import com.example.sampleapispringboot.model.Item;
import com.example.sampleapispringboot.repo.ItemRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
  @Autowired
  private ItemRepository itemRepository;

  public List<Item> getAllItems() {
    List<Item> allItems = new ArrayList<>();
    itemRepository.findAll().forEach(allItems::add);
    return allItems;
  }

  public Optional<Item> getItem(Long itemId) {
    return itemRepository.findById(itemId);
  }

  public void addItem(Item item) {
    itemRepository.save(item);
  }

  public void updateItem(Long itemId, Item item) {
    if (itemRepository.findById(itemId).get() != null) {
      itemRepository.save(item);
    }
  }

  public void deleteItem(Long itemId) {
    itemRepository.deleteById(itemId);
  }
}
