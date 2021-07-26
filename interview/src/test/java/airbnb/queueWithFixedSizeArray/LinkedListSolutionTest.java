package airbnb.queueWithFixedSizeArray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListSolutionTest {
  static Stream<MyQueue> solutionStream() {
    return Stream.of(
        new LinkedListSolution(),
        new LinkedListSolutionII(),
        new LinkedListSolutionIII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(MyQueue solution) {
    solution.push(1);
    solution.push(2);
    assertEquals(1, solution.peek());  // returns 1
    assertEquals(1, solution.pop());  // returns 1
    assertFalse(solution.empty());  // returns 1
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase10(MyQueue solution) {
    final int N = 10;
    for (int i = 0; i < N; i++) {
      solution.push(i);
    }
    for (int i = 0; i < N; i++) {
      assertEquals(i, solution.pop());  // returns 1
    }
    assertTrue(solution.empty());  // returns 1
    solution.push(1);
    assertFalse(solution.empty());  // returns 1
    assertEquals(1, solution.pop());  // returns 1
    assertTrue(solution.empty());  // returns 1
  }
}


