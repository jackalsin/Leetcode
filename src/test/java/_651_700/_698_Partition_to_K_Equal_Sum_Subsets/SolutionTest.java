package _651_700._698_Partition_to_K_Equal_Sum_Subsets;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/16/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] input = {4, 3, 2, 3, 5, 2, 1};
    assertTrue(solution.canPartitionKSubsets(input, 4));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[] input = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    System.out.println(input.length);
    assertTrue(solution.canPartitionKSubsets(input, 1));
  }

  @Test
  public void testFailedCase2() throws Exception {
    // (15,1), (4, 1, 1, 10), (3, 11, 1, 1)
    final int[] input = {4, 15, 1, 1, 1, 1, 3, 11, 1, 10};
    assertTrue(solution.canPartitionKSubsets(input, 3));
  }

  @Test
  public void testFailedCase3() throws Exception {
    final int[] input = {1, 1, 2, 4};
    assertFalse(solution.canPartitionKSubsets(input, 4));
  }
}
