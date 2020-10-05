package definition._280_Wiggle_Sort;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 12/1/2019
 */
public final class Validator {
  public static void assertIsWiggle(final int[] nums) {
    for (int i = 1; i < nums.length; i += 2) {
      assertTrue(nums[i] >= nums[i - 1]);
      if (i + 1 < nums.length) {
        assertTrue(nums[i] >= nums[i + 1]);
      }
    }
  }
}
