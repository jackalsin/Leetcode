package interviews.uber._698_Partition_to_K_Equal_Sum_Subsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int input[] = {
        4, 3, 2, 3, 5, 2, 1
    }, k = 4;

    assertTrue(solution.canPartitionKSubsets(input, k));
  }
}