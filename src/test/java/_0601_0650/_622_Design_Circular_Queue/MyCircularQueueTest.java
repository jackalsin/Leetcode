package _0601_0650._622_Design_Circular_Queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/26/2019
 */
class MyCircularQueueTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Class<Solution> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    Solution circularQueue = solutionClass.getConstructor(Integer.TYPE).newInstance(3);
    assertTrue(circularQueue.enQueue(1));  // return true
    assertTrue(circularQueue.enQueue(2));  // return true
    assertTrue(circularQueue.enQueue(3));  // return true
    assertFalse(circularQueue.enQueue(4));  // return false, the queue is full
    assertEquals(3, circularQueue.Rear());  // return 3
    assertTrue(circularQueue.isFull());  // return true
    assertTrue(circularQueue.deQueue());  // return true
    assertTrue(circularQueue.enQueue(4));  // return true
    assertEquals(4, circularQueue.Rear());  // return 4
  }

  static Stream<Class> solutionProvider() {
    return Stream.of(
        MyCircularQueue.class,
        MyCircularQueueI.class
    );
  }
}