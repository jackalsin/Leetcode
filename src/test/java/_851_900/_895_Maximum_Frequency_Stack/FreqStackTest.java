package _851_900._895_Maximum_Frequency_Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FreqStackTest {

  @Test
  void testOnlineCase1() {
    final FreqStack stack = new FreqStack();
    stack.push(5);
    stack.push(7);
    stack.push(5);
    stack.push(7);
    stack.push(4);
    stack.push(5);

    assertEquals(5, stack.pop());
    assertEquals(7, stack.pop());
    assertEquals(5, stack.pop());
    assertEquals(4, stack.pop());
  }
}