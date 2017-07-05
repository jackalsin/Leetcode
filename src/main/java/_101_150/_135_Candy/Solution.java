package _101_150._135_Candy;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  public int candy(int[] ratings) {
    if (ratings == null || ratings.length == 0) {
      return 0;
    } else {
      long[] bias = new long[ratings.length];
      long sum = 0;
      for (int i = 1; i < ratings.length; i++) {
        if (ratings[i - 1] < ratings[i]) {
          bias[i] = bias[i - 1] - 1;
        } else if (ratings[i - 1] > ratings[i]) {
          bias[i] = bias[i - 1] + 1;
        } else {
          bias[i] = bias[i - 1];
        }
        sum += bias[i];
      }
      return (int) (ratings.length * ratings[0] + sum);
    }
  }
}
