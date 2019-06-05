package interviews.airbnb.queueWithFixedSizeArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListSolutionIIITest {
  private MyQueue solution;

  @BeforeEach
  void setUp() {
    solution = new LinkedListSolutionIII();
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
}