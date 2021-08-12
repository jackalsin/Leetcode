package _0301_0350._325_Maximum_Size_Subarray_Sum_Equals_k;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/25/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] input = {1, -1, 5, -2, 3};
    assertEquals(4, solution.maxSubArrayLen(input, 3));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] input = {-2, -1, 2, 1};
    assertEquals(2, solution.maxSubArrayLen(input, 1));
  }

}
