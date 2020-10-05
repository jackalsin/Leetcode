package google._818_Race_Car;

/**
 * @author jacka
 * @version 1.0 on 4/8/2020
 */
public final class DpSolution implements Solution {
  private final int[] dp = new int[10_001];

  public int racecar(int target) {
    if (target == 0) {
      return 0;
    }
    if (dp[target] > 0) {
      return dp[target];
    }
    final int[] resultToExceedOrReachTarget = getMaxStep(target); // to reach or exceed target
//    System.out.println("Target = " + target + ", " + Arrays.toString(resultToExceedOrReachTarget));
    final int maxStep = resultToExceedOrReachTarget[0],
        maxDistance = resultToExceedOrReachTarget[1],
        maxSpeed = resultToExceedOrReachTarget[2];
    if ((1 << maxStep) - 1 == target) {
      dp[target] = maxStep;
      return maxStep;
    }
    // exceed and return
    int minSteps = maxStep + 1 + racecar(maxDistance - target);
    // most close point and return and A m times;
    for (int m = 0; m < maxStep - 1; ++m) {
      final int remainTarget = target - (maxDistance - maxSpeed / 2 - ((1 << m) - 1));
      final int remainStep = (maxStep - 1) + 1 + m + 1 + racecar(remainTarget);
      minSteps = Math.min(remainStep, minSteps);
    }
    dp[target] = minSteps;
    return minSteps;
  }

  private static int[] getMaxStep(final int target) {
    int steps = 0, pos = 0, speed = 1;
    for (; pos < target; speed *= 2) {
      pos += speed;
      steps++;
    }
    return new int[]{steps, pos, speed};
  }
}
