package _101_150._135_Candy;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  public int candy(int[] ratings) {
    if (ratings == null || ratings.length == 0) {
      return 0;
    } else {
      final int n = ratings.length;
      final int[] candies = new int[n];
      Arrays.fill(candies, 1);
      for (int i = 1; i < candies.length; i++) {
        if (ratings[i] > ratings[i - 1]) {
          candies[i] = candies[i - 1] + 1;
        }
      }
      int result = candies[n - 1];
      for (int i = candies.length - 1; i > 0; i--) {
        if (ratings[i - 1] > ratings[i]) {
          candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
        }
        result += candies[i - 1];
      }
      return result;
    }
  }
}
