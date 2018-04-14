package _401_450._423_Reconstruct_Original_Digits_from_English;

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
    final String s = "owoztneoer", expected = "012";
    assertEquals(expected, solution.originalDigits(s));
  }

  @Test
  void testOnlineCase2() {
    final String s = "fviefuro", expected = "45";
    assertEquals(expected, solution.originalDigits(s));
  }

  @Test
  void testFailedCase1() {
    final String s = "esnve", expected = "7";
    assertEquals(expected, solution.originalDigits(s));
  }
}