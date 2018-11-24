package _0051_0100._053_Maximum_Subarray;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 3/27/2017.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void maxSubArrayWithPositiveMore() throws Exception {
    final int[] input = new int[]{4, 5, 3, -3, 2};
    assertEquals(12, solution.maxSubArray(input));
  }

  @Test
  public void testWithOneElement() throws Exception {
    final int[] input = new int[]{3};
    assertEquals(3, solution.maxSubArray(input));
  }

  @Test
  public void testWithOneNegativeElement() throws Exception {
    final int[] input = new int[]{-3};
    assertEquals(-3, solution.maxSubArray(input));
  }

  @Test
  public void testWithTwoNegativeElement() throws Exception {
    final int[] input = new int[]{-3, -2};
    assertEquals(-2, solution.maxSubArray(input));
  }

  @Test
  public void testWithTwoNegativeElementReverse() throws Exception {
    final int[] input = new int[]{-2, -3};
    assertEquals(-2, solution.maxSubArray(input));
  }
}