package oracle._232_Implement_Queue_using_Stacks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author jacka
 * @version 1.0 on 10/15/2019
 */
class MyQueueTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(MyQueue queue) {
    queue.push(1);
    queue.push(2);
    assertEquals(1, queue.peek());  // returns 1
    assertEquals(1, queue.pop());  // returns 1
    assertFalse(queue.empty()); // returns false
  }

  static Stream<MyQueue> solutionStream() {
    return Stream.of(
        new MyQueueI()
    );
  }
}