package airbnb._136_Single_Number;

/**
 * @author zhixi
 * @version 1.0 on 8/18/2021
 */
public final class SolutionII implements Solution {
  @Override
  public int singleNumber(int[] nums) {
    int res = 0;
    if (nums == null || nums.length == 0) return res;
    for (int num : nums) {
      res ^= num;
    }
    return res;
  }
}
