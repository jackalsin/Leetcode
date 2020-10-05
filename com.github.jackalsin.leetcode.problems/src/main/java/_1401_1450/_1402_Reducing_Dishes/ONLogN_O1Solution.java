package _1401_1450._1402_Reducing_Dishes;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 4/23/2020
 */
public final class ONLogN_O1Solution implements Solution {
  @Override
  public int maxSatisfaction(int[] satisfaction) {
    Arrays.sort(satisfaction);
    final int n = satisfaction.length;
    int total = 0, res = 0;
    for (int i = n - 1; i >= 0 && satisfaction[i] + total >= 0; --i) {
      total += satisfaction[i];
      res += total;
    }
    return res;
  }
}
