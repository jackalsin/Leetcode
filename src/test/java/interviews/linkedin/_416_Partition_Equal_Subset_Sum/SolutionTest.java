package interviews.linkedin._416_Partition_Equal_Subset_Sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/15/18
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }


  @Test
  void testOnlineCase1() {
    final int[] nums = {1, 5, 11, 5};
    assertTrue(solution.canPartition(nums));
  }

  @Test
  void testOnlineCase2() {
    final int[] nums = {1, 2, 3, 5};
    assertFalse(solution.canPartition(nums));
  }

  @Test
  void testFailedCase1() {
    final int[] nums = {1, 2, 5};
    assertFalse(solution.canPartition(nums));
  }

  @Test
  void testFailedCase2() {
    final int[] nums = {3, 3, 3, 4, 5};
    assertTrue(solution.canPartition(nums));
  }
}