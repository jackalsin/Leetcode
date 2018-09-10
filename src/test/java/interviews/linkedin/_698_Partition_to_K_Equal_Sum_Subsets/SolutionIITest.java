package interviews.linkedin._698_Partition_to_K_Equal_Sum_Subsets;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/16/2017.
 */
public class SolutionIITest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new SolutionII();
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

  @Test
  public void testFailedCase4() throws Exception {
    final int[] input = {5, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3};
    assertTrue(solution.canPartitionKSubsets(input, 15));
  }

  @Test
  public void testFailedOnTLE() throws Exception {
    final int[] input = {605, 454, 322, 218, 8, 19, 651, 2220, 175, 710, 2666, 350, 252, 2264,
        327, 1843};
    final long startTime = System.nanoTime();
    solution.canPartitionKSubsets(input, 4);
    final long endTime = System.nanoTime();
    System.out.println((endTime - startTime) / 1e6);
  }
}
