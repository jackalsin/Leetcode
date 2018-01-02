package _651_700._689_Maximum_Sum_of_3_Non_Overlapping_Subarrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    // 0  1  2  3  4  5  6  7
    final int[] input = {1, 2, 1, 2, 6, 7, 5, 1};
    int k = 2;
    final int[] actual = solution.maxSumOfThreeSubarrays(input, k);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(new int[]{0, 3, 5}, actual);
  }

  @Test
  public void testKEquals1() {
    final int[] input = {1, 2, 1, 2, 6, 7, 5, 1};
    int k = 1;
    final int[] actual = solution.maxSumOfThreeSubarrays(input, k);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(new int[]{4, 5, 6}, actual);
  }
}