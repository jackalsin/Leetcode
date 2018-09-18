package interviews.linkedin._155_Min_Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinStack2StacksTest {
  @Test
  void testOnlineCase1() {
    final MinStack minStack = new MinStack2Stacks();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    assertEquals(-3, minStack.getMin());  //  --> Returns -3.
    minStack.pop();
    assertEquals(0, minStack.top());
    assertEquals(-2, minStack.getMin());
  }
}