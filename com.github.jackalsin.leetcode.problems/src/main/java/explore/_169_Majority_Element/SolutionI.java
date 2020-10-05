package explore._169_Majority_Element;

/**
 * @author jacka
 * @version 1.0 on 5/6/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int majorityElement(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int candidate = nums[0], count = 1;
    for (int i = 1; i < nums.length; ++i) {
      if (candidate == nums[i]) {
        count++;
      } else if (count == 0) {
        candidate = nums[i];
        count = 1;
      } else {
        count--;
      }
    }
    return candidate;
  }
}
