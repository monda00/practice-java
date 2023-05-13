package com.example.sampleapispringboot.service;

import com.example.sampleapispringboot.model.Item;
import com.example.sampleapispringboot.repo.ItemRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
  @Autowired
  private ItemRepository itemRepository;

  @Cacheable("getItems")
  public List<Item> getAllItems() {
    List<Item> allItems = new ArrayList<>();

    try {
      Thread.sleep(3000);
    } catch (Exception e) {
      e.printStackTrace();
    }
    itemRepository.findAll().forEach(allItems::add);
    return allItems;
  }

  @Cacheable(value = "getItem", key = "#p0")
  public Optional<Item> getItem(Long itemId) {
    try {
      Thread.sleep(3000);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return itemRepository.findById(itemId);
  }

  @CacheEvict(value = "getItems", allEntries = true)
  public void addItem(Item item) {
    itemRepository.save(item);
  }

  @Caching(evict = {
      @CacheEvict(value = "getItem", key = "#p0"), @CacheEvict(value = "getItems", allEntries = true)
  })
  public void updateItem(Long itemId, Item item) {
    if (itemRepository.findById(itemId).get() != null) {
      itemRepository.save(item);
    }
  }

  @Caching(evict = {
      @CacheEvict(value = "getItem", key = "#p0"), @CacheEvict(value = "getItems", allEntries = true)
  })
  public void deleteItem(Long itemId) {
    itemRepository.deleteById(itemId);
  }
}
