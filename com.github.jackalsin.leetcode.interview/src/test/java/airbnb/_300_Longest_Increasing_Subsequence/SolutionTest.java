package airbnb._300_Longest_Increasing_Subsequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/3/2019.
 */
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

  @Test
  void testOnlineCase2() throws Exception {
    final int[] input = {2, 2};
    assertEquals(1, solution.lengthOfLIS(input));
  }
}