package _0701_0750._716_Max_Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxStackPopMaxO1Test {
  @Test
  void testOnlineCase1() {
    MaxStack stack = new MaxStackPopMaxO1();
    stack.push(5);
    stack.push(1);
    stack.push(5);
    assertEquals(5, stack.top());
    assertEquals(5, stack.popMax());
    assertEquals(1, stack.top());
    assertEquals(5, stack.peekMax());
    assertEquals(1, stack.pop());
    assertEquals(5, stack.top());
  }
}