package _0801_0850._818_Race_Car;

public final class Solution {

  public int racecar(int target) { // todo:
    assert 1 <= target && target <= 10000;
    final int[][] dp = new int[target * 2 + 1][2 * target + 1];
    return racecar(dp, target, 1);
  }

  private static int racecar(final int[][] dp, final int target, final int speed) {
    assert target >= 0;
    if (target == 0) {
      return 0;
    } else if (dp[target][speed] != 0) {
      return dp[target][speed];
    }
    int minSteps = Integer.MAX_VALUE;
    if (target >= speed) {
      minSteps = Math.min(minSteps, 1 + racecar(dp, target - speed, speed * 2));
      minSteps = Math.min(minSteps, 3 + racecar(dp, target - speed, 1));
    } else {
      minSteps = Math.min(minSteps, 2 + racecar(dp, speed - target, 1));
    }
    dp[target][speed] = minSteps;
    return minSteps;
  }

}
