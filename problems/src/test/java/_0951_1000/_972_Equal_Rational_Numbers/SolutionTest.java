package _0951_1000._972_Equal_Rational_Numbers;

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
    final String S = "0.(52)", T = "0.5(25)";
    assertTrue(solution.isRationalEqual(S, T));
  }

  @Test
  void testOnlineCase2() {
    final String S = "0.1666(6)", T = "0.166(66)";
    assertTrue(solution.isRationalEqual(S, T));
  }

  @Test
  void testOnlineCase3() {
    final String S = "0.9(9)", T = "1.";
    assertTrue(solution.isRationalEqual(S, T));
  }

  @Test
  void testOnlineCase4() {
    final String S = "8.123(4567)", T = "8.123(4566)";
    assertFalse(solution.isRationalEqual(S, T));
  }
}