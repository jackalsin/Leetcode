package interviews.microsoft._232_Implement_Queue_using_Stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MyQueueTest {
  private MyQueue myQueue;

  @BeforeEach
  void setUp() {
    myQueue = new MyQueue();
  }

  @Test
  void testOnlineCase1() {
    final MyQueue queue = new MyQueue();
    queue.push(1);
    queue.push(2);
    assertEquals(1, queue.peek());  // returns 1
    assertEquals(1, queue.pop());  // returns 1
    assertFalse(queue.empty()); // returns false
  }
}