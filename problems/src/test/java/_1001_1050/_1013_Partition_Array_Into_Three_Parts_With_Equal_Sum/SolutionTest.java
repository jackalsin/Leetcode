package _1001_1050._1013_Partition_Array_Into_Three_Parts_With_Equal_Sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[] input = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
    assertTrue(solution.canThreePartsEqualSum(input));
  }

  @Test
  void testOnlineCase2() {
    final int[] input = {0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};
    assertFalse(solution.canThreePartsEqualSum(input));
  }

  @Test
  void testOnlineCase3() {
    final int[] input = {3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
    assertTrue(solution.canThreePartsEqualSum(input));
  }

  @Test
  void testOnlineCase4() {
    final int[] input = {18, 12, -18, 18, -19, -1, 10, 10};
    assertTrue(solution.canThreePartsEqualSum(input));
  }
}