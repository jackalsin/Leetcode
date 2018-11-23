package _0501_0550._525_Contiguous_Array;

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
    assertEquals(2, solution.findMaxLength(new int[]{0, 1}));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(2, solution.findMaxLength(new int[]{0, 1, 0}));
  }

  @Test
  void testOnlineCase101() {
    assertEquals(2, solution.findMaxLength(new int[]{1, 0, 1}));
  }

  @Test
  void testFailedCase1() {
    final int[] input = new int[]{0, 0, 1, 0, 0, 0, 1, 1};
    assertEquals(6, solution.findMaxLength(input));
  }
}