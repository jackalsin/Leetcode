package _751_800._780_Reaching_Points;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/7/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    assertFalse(solution.reachingPoints(1, 1, 2, 2));
  }

  @Test
  void testOnlineCase2() {
    assertTrue(solution.reachingPoints(1, 1, 1, 1));
  }

  @Test
  void testTLECase() {
    assertTrue(solution.reachingPoints(1, 2, 999999999, 2));
  }

  @Test
  void testFailedCase() {
    assertTrue(solution.reachingPoints(3, 3, 12, 9));
  }
}
