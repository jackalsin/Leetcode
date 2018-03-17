package interviews.uber._300_Longest_Increasing_Subsequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/16/2018.
 */
class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new NLogNSolution();
  }

  @Test
  void testOnlineCase() throws Exception {
    final int[] input = {10, 9, 2, 5, 3, 7, 101, 18};
    assertEquals(4, solution.lengthOfLIS(input));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final int[] input = {};
    assertEquals(0, solution.lengthOfLIS(input));
  }

  @Test
  void testOnlineCase3() throws Exception {
    final int[] input = {0};
    assertEquals(1, solution.lengthOfLIS(input));
  }

  @Test
  void testOnlineCase4() throws Exception {
    final int[] input = {2, 2};
    assertEquals(1, solution.lengthOfLIS(input));
  }
}
