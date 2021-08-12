package _0601_0650._643_Maximum_Average_Subarray_I;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
  private static final double DELTA = 1E-7;
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {1, 12, -5, -6, 50, 3};
    final int k = 4;
    assertEquals(12.75, solution.findMaxAverage(nums, k), DELTA);
  }
}