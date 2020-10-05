package _0551_0600._553_Optimal_Division;

/**
 * @author jacka
 * @version 1.0 on 2/1/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String optimalDivision(int[] nums) {
    final StringBuilder sb = new StringBuilder();
    if (nums == null || nums.length == 0) {
      return "";
    }
    if (nums.length == 1) {
      return String.valueOf(nums[0]);
    }
    if (nums.length == 2) {
      return nums[0] + "/" + nums[1];
    }
    sb.append("/").append(nums[0]).append("/(");
    for (int i = 1; i < nums.length; ++i) {
      if (i == 1) {
        sb.append(nums[i]);
      } else {
        sb.append("/").append(nums[i]);
      }
    }
    sb.append(")");
    return sb.substring(1);
  }

}
