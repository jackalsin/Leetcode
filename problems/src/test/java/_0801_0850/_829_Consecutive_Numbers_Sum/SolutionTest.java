package _0801_0850._829_Consecutive_Numbers_Sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(2, solution.consecutiveNumbersSum(5));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(3, solution.consecutiveNumbersSum(9));
  }

  @Test
  void testOnlineCase3() {
    assertEquals(4, solution.consecutiveNumbersSum(15));
  }

  @Test
  void testOnlineCase4() {
    assertEquals(1, solution.consecutiveNumbersSum(2));
  }

  @Test
  void testFailedCase1() {
    assertEquals(2, solution.consecutiveNumbersSum(3));
  }
}