package linkedin.mianjing._716_Max_Stack;

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

  @Test
  void testOnlineCase2() {
    //["MaxStack","push","push","popMax","peekMax"]
    //[[],[5],[1],[],[]]
    MaxStack stack = new MaxStackPopMaxO1();
    stack.push(5);
    stack.push(1);
    assertEquals(5, stack.popMax());
    assertEquals(1, stack.peekMax());
  }
}