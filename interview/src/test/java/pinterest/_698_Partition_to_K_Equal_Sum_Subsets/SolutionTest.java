package pinterest._698_Partition_to_K_Equal_Sum_Subsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new BruteForceSolution();
  }

  @Test
  void testOnlineCase() {
    final int[] input = {4, 3, 2, 3, 5, 2, 1};
    assertTrue(solution.canPartitionKSubsets(input, 4));
  }

  @Test
  void testFailedCase1() {
    final int[] input = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    System.out.println(input.length);
    assertTrue(solution.canPartitionKSubsets(input, 1));
  }

  @Test
  void testFailedCase2() {
    // (15,1), (4, 1, 1, 10), (3, 11, 1, 1)
    final int[] input = {4, 15, 1, 1, 1, 1, 3, 11, 1, 10};
    assertTrue(solution.canPartitionKSubsets(input, 3));
  }

  @Test
  void testFailedCase3() {
    final int[] input = {1, 1, 2, 4};
    assertFalse(solution.canPartitionKSubsets(input, 4));
  }

  @Test
  void testFailedCase4() {
    final int[] input = {5, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3};
    assertTrue(solution.canPartitionKSubsets(input, 15));
  }

  @Test
  void testFailedCase5() {
    final int[] input = {2, 2, 10, 5, 2, 7, 2, 2, 13};
    assertTrue(solution.canPartitionKSubsets(input, 3));
  }

}