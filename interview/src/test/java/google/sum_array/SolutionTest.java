package google.sum_array;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/20/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[][] nums = {
        {1, 2, 3},
        {4, 5, 6}
    };

    final int[][] expected = {
        {1, 3, 6},
        {5, 12, 21}
    };
    final int[][] actual = solution.getSum(nums);
    assertTrue(Arrays.deepEquals(expected, actual));
  }
}
