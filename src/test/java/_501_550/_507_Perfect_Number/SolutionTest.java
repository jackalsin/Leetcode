package _501_550._507_Perfect_Number;

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
    assertTrue(solution.checkPerfectNumber(28));
  }

  @Test
  void testOnlineCase2() {
    assertFalse(solution.checkPerfectNumber(1));
  }
}