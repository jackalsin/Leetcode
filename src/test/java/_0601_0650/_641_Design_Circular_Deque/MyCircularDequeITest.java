package _0601_0650._641_Design_Circular_Deque;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/15/2020
 */
class MyCircularDequeITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Class<MyCircularDeque> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    MyCircularDeque solution = solutionClass.getConstructor(Integer.TYPE).newInstance(3);
    assertTrue(solution.insertLast(1));      // return true
    assertTrue(solution.insertLast(2));      // return true
    assertTrue(solution.insertFront(3));      // return true
    assertFalse(solution.insertFront(4));      // return false, the queue is full
    assertEquals(2, solution.getRear());        // return 2
    assertTrue(solution.isFull());        // return true
    assertTrue(solution.deleteLast());      // return true
    assertTrue(solution.insertFront(4));      // return true
    assertEquals(4, solution.getFront());      // return 4
  }


  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Class<MyCircularDeque> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    MyCircularDeque solution = solutionClass.getConstructor(Integer.TYPE).newInstance(77);
    assertTrue(solution.insertFront(89));
    assertEquals(89, solution.getRear());
    assertTrue(solution.deleteLast());
    assertEquals(-1, solution.getRear());
    assertTrue(solution.insertFront(19));
    assertTrue(solution.insertFront(23));
    assertTrue(solution.insertFront(23));
    assertTrue(solution.insertFront(82));
    assertFalse(solution.isFull());
    assertTrue(solution.insertFront(45));
    assertFalse(solution.isFull());
    assertEquals(19, solution.getRear());
  }

  static Stream<Class> solutionProvider() {
    return Stream.of(
        MyCircularDequeI.class
    );
  }
}