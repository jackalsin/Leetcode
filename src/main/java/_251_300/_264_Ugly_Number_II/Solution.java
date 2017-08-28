package _251_300._264_Ugly_Number_II;

/**
 * @author jacka
 * @version 1.0 on 8/28/2017.
 */
public class Solution {
  public int nthUglyNumber(int n) {
    if (n == 1) {
      return 1;
    } else {
      int result2 = 2, result3 = 3, result5 = 5;
      int index2 = 1, index5 = 1, index3 = 1;
      int[] ugly = new int[n + 1];
      ugly[1] = 1;
      for (int i = 2; i <= n; ++i) {
        int min = getMin(result2, result3, result5);
        ugly[i] = min;
        if (min == result2) {
          result2 = 2 * ugly[++index2];
        }
        if (min == result3) {
          result3 = 3 * ugly[++index3];
        }
        if (min == result5) {
          result5 = 5 * ugly[++index5];
        }
      }
      return ugly[n];
    }
  }

  private static int getMin(int result2, int result3, int result5) {
    return Math.min(result2, Math.min(result3, result5));
  }
}
