package org.example.StrongBox;

public class StrongBox<E> {
  private E item;
  private KeyType keyType;
  private long count;

  public StrongBox(KeyType keyType) {
    this.keyType = keyType;
    this.count = 0;
  }

  public void put(E i) {
    this.item = i;
  }

  public E get() {
    this.count++;

    if (this.keyType == KeyType.PADLOCK && this.count < 1024) {
      return null;
    } else if (this.keyType == KeyType.BUTTON && this.count < 10000) {
      return null;
    } else if (this.keyType == KeyType.DIAL && this.count < 30000) {
      return null;
    } else if (this.keyType == KeyType.FINGER && this.count < 1000000) {
      return null;
    }

    return this.item;
  }
}
