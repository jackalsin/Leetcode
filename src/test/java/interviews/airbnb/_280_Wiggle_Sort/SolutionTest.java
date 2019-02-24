package interviews.airbnb._280_Wiggle_Sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/24/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[] input = {3, 5, 2, 1, 6, 4};
    solution.wiggleSort(input);
    assertIsWiggle(input);
  }

  private static void assertIsWiggle(final int[] nums) {
    for (int i = 1; i < nums.length; i += 2) {
      assertTrue(nums[i] >= nums[i - 1]);
      if (i + 1 < nums.length) {
        assertTrue(nums[i] >= nums[i + 1]);
      }
    }
  }
}