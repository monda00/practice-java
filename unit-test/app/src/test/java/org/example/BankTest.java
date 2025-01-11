package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
  @Test
  public void instantiate() {
    Bank bank = new Bank();
    assertNotNull(bank);
  }

  @Test
  public void setName() {
    Bank bank = new Bank();
    bank.setName("My Bank");
    assertEquals("My Bank", bank.getName());
  }

  @Test
  public void setNameWithNull() {
    try {
      Bank bank = new Bank();
      bank.setName(null);
    } catch (NullPointerException e) {
      return;
    }
    fail();
  }

  @Test
  public void setNameWithShortName() {
    Bank bank = new Bank();
    assertThrows(IllegalArgumentException.class, () -> {
      bank.setName("A");
    });
  }
}
