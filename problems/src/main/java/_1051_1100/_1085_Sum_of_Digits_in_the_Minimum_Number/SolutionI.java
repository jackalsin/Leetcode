package _1051_1100._1085_Sum_of_Digits_in_the_Minimum_Number;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 6/27/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int sumOfDigits(int[] nums) {
    assert nums.length >= 1;
    final int min = Arrays.stream(nums).min().getAsInt();
    return sum(min) % 2 == 0 ? 1 : 0;
  }

  private static int sum(int val) {
    int sum = 0;
    while (val != 0) {
      sum += val % 10;
      val /= 10;
    }
    return sum;
  }
}
