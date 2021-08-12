package _0201_0250._225_Implement_Stack_using_Queues;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/16/2017.
 */
class MyStackTest {
  private MyStack stack;

  @BeforeEach
  void setUp() throws Exception {
    stack = new MyStack();
  }

  @Test
  void testFailed1() throws Exception {
    stack.push(1);
    stack.push(2);
    assertEquals(2, stack.top());
  }

}
