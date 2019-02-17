package interviews.airbnb._829_Consecutive_Numbers_Sum;

/**
 * @author jacka
 * @version 1.0 on 2/16/2019.
 */
public final class Solution {
  public int consecutiveNumbersSum(int N) {
    int count = 0;
    for (int i = 1; i <= N; i++) {
      // a0 = (2 * N - i (i - 1)) / (2 * i)
      long sum = 2L * N - (long) i * (i - 1);
      long possibleA0 = sum / 2 / i;
      if (possibleA0 > 0) {
        if ((sum / 2) % i == 0) {
          count++;
        }
      } else {
        break;
      }
    }
    return count;
  }
}
