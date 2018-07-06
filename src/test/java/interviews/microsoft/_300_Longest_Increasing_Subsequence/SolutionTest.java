package interviews.microsoft._300_Longest_Increasing_Subsequence;

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
  void testOnlineCase() {
    final int[] input = {10, 9, 2, 5, 3, 7, 101, 18};
    assertEquals(4, solution.lengthOfLIS(input));
  }

}