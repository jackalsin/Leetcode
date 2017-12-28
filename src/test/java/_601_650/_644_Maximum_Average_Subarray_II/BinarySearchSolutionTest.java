package _601_650._644_Maximum_Average_Subarray_II;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/25/2017.
 */
public class BinarySearchSolutionTest {
  private static final double DELTA = 1E-5;
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new BinarySearchSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {1, 12, -5, -6, 50, 3};
    assertEquals(12.75, solution.findMaxAverage(nums, 4), DELTA);
  }

}
