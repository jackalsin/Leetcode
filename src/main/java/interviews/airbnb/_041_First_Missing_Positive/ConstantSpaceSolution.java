package interviews.airbnb._041_First_Missing_Positive;

/**
 * @author jacka
 * @version 1.0 on 1/22/2019.
 */
public final class ConstantSpaceSolution implements Solution {
  /**
   * Time Complexity: O(N)
   * Space Complexity: O(1)
   *
   * @param nums
   * @return
   */
  public int firstMissingPositive(int[] nums) {
    if (nums == null) {
      return 1;
    }
    final int n = nums.length;
    for (int i = 0; i < n; i++) {
      // 5 要在 nums[4]
      while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
        // swap 之后，value of <value>nums[i] - i</value>会被swap到<tt>i</tt> position
        swap(nums, i, nums[i] - 1);
      }
    }

    for (int i = 0; i < n; i++) {
      if (nums[i] != i + 1) return i + 1;
    }
    return n + 1;
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
