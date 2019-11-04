package interviews.oracle._167_Two_Sum_II_Input_array_is_sorted;

/**
 * @author jacka
 * @version 1.0 on 11/4/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int[] twoSum(int[] nums, int target) {
    assert nums.length >= 2;
    for (int left = 0, right = nums.length - 1; left < right; ) {
      final long sum = (long) nums[left] + nums[right];
      if (sum > target) {
        right--;
      } else if (sum == target) {
        return new int[]{left + 1, right + 1};
      } else {
        left++;
      }
    }
    throw new IllegalArgumentException();
  }
}
