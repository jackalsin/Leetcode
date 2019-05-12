package _1001_1050._1041_Robot_Bounded_In_Circle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    assertTrue(solution.isRobotBounded("GGLLGG"));
  }

  @Test
  void testOnlineCase2() {
    assertFalse(solution.isRobotBounded("GG"));
  }

  @Test
  void testOnlineCase3() {
    assertTrue(solution.isRobotBounded("GL"));
  }

  @Test
  void testFailedCase3() {
    assertTrue(solution.isRobotBounded("LRRRRLLLRL"));
  }
}