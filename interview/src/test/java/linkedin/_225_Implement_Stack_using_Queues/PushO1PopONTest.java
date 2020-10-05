package linkedin._225_Implement_Stack_using_Queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PushO1PopONTest {
  private MyStack stack;

  @BeforeEach
  void setUp() throws Exception {
    stack = new PushO1PopON();
  }

  @Test
  void testFailed1() throws Exception {
    stack.push(1);
    stack.push(2);
    assertEquals(2, stack.top());
  }

}