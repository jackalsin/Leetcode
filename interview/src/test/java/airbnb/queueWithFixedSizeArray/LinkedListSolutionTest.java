package airbnb.queueWithFixedSizeArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/26/2019.
 */
class LinkedListSolutionTest {

  private MyQueue solution;

  @BeforeEach
  void setup() {
    solution = new LinkedListSolution();
  }

  @Test
  void testOnlineCase1() {
    solution.push(1);
    solution.push(2);
    assertEquals(1, solution.peek());  // returns 1
    assertEquals(1, solution.pop());  // returns 1
    assertFalse(solution.empty());  // returns 1
  }

  @Test
  void testOnlineCase10() {
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

  @Test
  void testOnlineCase20() {
    final int N = 10;
    for (int i = 0; i < 2 * N; i++) {
      solution.push(i);
    }
    for (int i = 0; i < N; i++) {
      assertEquals(i, solution.pop());  // returns 1
    }
    assertFalse(solution.empty());  // returns 1
    for (int i = 10; i < 2 * N; i++) {
      assertEquals(i, solution.pop());  // returns 1
    }
    assertTrue(solution.empty());  // returns 0
    solution.push(1);
    assertFalse(solution.empty());  // returns 1
    assertEquals(1, solution.pop());  // returns 1
    assertTrue(solution.empty());  // returns 1
  }

}