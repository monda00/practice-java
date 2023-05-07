package com.example.sampleapispringboot.exception;

public class ItemNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ItemNotFoundException(Long itemId) {
    super("Item ID:" + itemId + "Not Found");
  }
}
