package _0751_0800._754_Reach_a_Number;

/**
 * @author jacka
 * @version 1.0 on 5/29/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int reachNumber(int target) {
    if (target < 0) {
      return reachNumber(-target);
    }
    int step = 0, sum = 0;
    while (sum < target) {
      step++;
      sum += step;
    }

    while ((sum - target) % 2 != 0) {
      step++;
      sum += step;
    }
    return step;
  }
}
