package interviews.airbnb.queueWithFixedSizeArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LinkedListSolutionIITest {
  private MyQueue solution;

  @BeforeEach
  void setUp() {
    solution = new LinkedListSolutionII();
  }

  @Test
  void testOnlineCase1() {
    solution.push(1);
    solution.push(2);
    assertEquals(1, solution.peek());  // returns 1
    assertEquals(1, solution.pop());  // returns 1
    assertFalse(solution.empty());  // returns 1
  }
}


