package interviews.linkedin._300_Longest_Increasing_Subsequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() throws Exception {
    final int[] input = {10, 9, 2, 5, 3, 7, 101, 18};
    assertEquals(4, solution.lengthOfLIS(input));
  }
}