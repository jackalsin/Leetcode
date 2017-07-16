package _151_200._152_Maximum_Product_Subarray;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 7/15/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnline() throws Exception {
    final int[] input = new int[] {2, 3, -2, 4};
    assertEquals(6, solution.maxProduct(input));
  }

  @Test
  public void testOnline2() throws Exception {
    final int[] input = new int[] {-4, -3, -2};
    assertEquals(12, solution.maxProduct(input));
  }
}
