package uber.codeSignal.goodArray;

/**
 * @author jacka
 * @version 1.0 on 4/18/2021
 */
public class SolutionI implements Solution {
  @Override
  public int goodSubarray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final int n = nums.length;
    int max = 1;
    for (int i = 1, cur = 1; i < n; ++i) {
      if ((nums[i] % 2 + nums[i - 1] % 2 == 1)) {
        cur++;
        max += cur;
      } else {
        cur = 1;
      }
    }
    return max;
  }
}
