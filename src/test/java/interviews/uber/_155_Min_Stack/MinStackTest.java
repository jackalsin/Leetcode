package interviews.uber._155_Min_Stack;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinStackTest {

  @Test
  void testOnlineCase1() {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    assertEquals(-3, minStack.getMin()); //   --> Returns -3.
    minStack.pop();
    assertEquals(0, minStack.top());//      --> Returns 0.
    assertEquals(-2, minStack.getMin());  //  --> Returns -2.
  }
}