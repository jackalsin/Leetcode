package google.quicksort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 1/27/2018.
 */
public class SolutionTest {
  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {10, 80, 30, 90, 40, 50, 70};
    Solution.quickSort(nums);
    final int[] expected = {10, 30, 40, 50, 70, 80, 90};
    assertArrayEquals(expected, nums);
  }
}
