package interviews.linkedin._152_Maximum_Product_Subarray;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new SolutionII();
  }

  @Test
  public void testFailedNegative() throws Exception {
    final int[] nums = {-2};
    assertEquals(-2, solution.maxProduct(nums));
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] nums = {2, 3, -2, 4};
    assertEquals(6, solution.maxProduct(nums));
  }

  @Test
  public void testZero() throws Exception {
    final int[] nums = {0, 2};
    assertEquals(2, solution.maxProduct(nums));
  }
}
