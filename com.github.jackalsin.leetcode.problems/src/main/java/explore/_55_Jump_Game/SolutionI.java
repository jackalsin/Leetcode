package explore._55_Jump_Game;

/**
 * @author jacka
 * @version 1.0 on 4/25/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean canJump(int[] nums) {
    final int n = nums.length;
    int maxReach = 0;
    for (int i = 0; i < n; ++i) {
      if (maxReach < i) {
        continue;
      }
      maxReach = Math.max(maxReach, i + nums[i]);
      if (maxReach >= n - 1) {
        return true;
      }
    }
    return false;
  }
}
