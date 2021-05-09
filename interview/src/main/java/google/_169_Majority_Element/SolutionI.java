package google._169_Majority_Element;

/**
 * @author jacka
 * @version 1.0 on 5/9/2021
 */
public final class SolutionI implements Solution {

  @Override
  public int majorityElement(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    final int len = nums.length;
    int cur = 0;
    for (int i = 0, count = 0; i < nums.length; ++i) {
      if (count == 0) {
        cur = nums[i];
        count++;
      } else if (nums[i] == cur) {
        count++;
      } else {
        count--;
      }
    }
    int curCount = 0;
    for (int n : nums) {
      if (n == cur) curCount++;
    }

    return curCount * 2 > len ? cur : -1;
  }
}
