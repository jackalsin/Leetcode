package _0601_0650._621_Task_Scheduler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/11/2018.
 */
class MathSolutionTest {
  private MathSolution solution;

  @BeforeEach
  void setUp() {
//  solution = new Solution();
    solution = new MathSolution();
  }

  @Test
  void testOnlineCase1() {
    final char[] chars = {'A', 'A', 'A', 'B', 'B', 'B'};
    assertEquals(8, solution.leastInterval(chars, 2));
  }
}
