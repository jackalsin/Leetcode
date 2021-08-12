package _0551_0600._562_Longest_Line_of_Consecutive_One_in_Matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[][] nums = {
        {0, 1, 1, 0},
        {0, 1, 1, 0},
        {0, 0, 0, 1}
    };
    assertEquals(3, solution.longestLine(nums));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[][] nums = {
        {0, 1, 0, 1, 1},
        {1, 1, 0, 0, 1},
        {0, 0, 0, 1, 0},
        {1, 0, 1, 1, 1},
        {1, 0, 0, 0, 1}
    };

    assertEquals(3, solution.longestLine(nums));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final int[][] nums = {
        {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
        {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
        {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
        {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
        {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
        {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
        {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
        {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}
    };

    assertEquals(7, solution.longestLine(nums));
  }
}