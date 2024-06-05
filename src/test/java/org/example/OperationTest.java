package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

  @Test
  @DisplayName("2 add 3 should equal 5")
  void add() {
    Operation operation = new Operation();
    operation.calculate = new StubCalculate();
    operation.sum(2, 3);
  }
}


class StubCalculate implements Calculate {

  @Override
  public int add(int a, int b) {
    return a+b;
  }
}