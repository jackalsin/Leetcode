package interviews.airbnb.queueWithFixedSizeArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

}