package utils._324_Wiggle_Sort_II;

/**
 * @author jacka
 * @version 1.0 on 12/1/2019
 */
public final class Validator {
  private Validator() {
  }

  public static boolean assertIsWiggle(int[] nums) {
    for (int i = 1; i < nums.length; i += 2) {
      if (nums[i] <= nums[i - 1] || (i + 1 < nums.length && nums[i] <= nums[i + 1])) {
//        System.out.println(Arrays.toString(nums));
        return false;
      }
    }
    return true;
  }
}
