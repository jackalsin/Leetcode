package _0401_0450._416_Partition_Equal_Subset_Sum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
//    solution = new SpaceONSquareDpSolution();
    solution = new SpaceLinearDpSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {1, 5, 11, 5};
    assertTrue(solution.canPartition(nums));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] nums = {1, 2, 3, 5};
    assertFalse(solution.canPartition(nums));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[] nums = {1, 2, 5};
    assertFalse(solution.canPartition(nums));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final int[] nums = {3, 3, 3, 4, 5};
    assertTrue(solution.canPartition(nums));
  }
}