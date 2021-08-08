package _1401_1450._1413_Minimum_Value_to_Get_Positive_Step_by_Step_Sum;

/**
 * @author jacka
 * @version 1.0 on 8/7/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int minStartValue(int[] nums) {
    int sum = 0, min = 0;
    for (final int n : nums) {
      sum += n;
      min = Math.min(min, sum);
    }
    return Math.max(-min + 1, 1);
  }
}
