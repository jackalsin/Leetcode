package _0801_0850._829_Consecutive_Numbers_Sum;

public final class Solution {
  public int consecutiveNumbersSum(int N) {
    int res = 0;
    for (int n = 1; ; n++) {
      int na = N - (n - 1) * n / 2;
      if (na <= 0) {
        break;
      } else if (na % n == 0) {
        res++;
      }
    }
    return res;
  }

}
