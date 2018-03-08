package _751_800._788_Rotated_Digits;

/**
 * @author jacka
 * @version 1.0 on 3/7/2018.
 */
public final class NSolution implements Solution {
  private static final int INVALID_ROTATE = 0, VALID_SAME = 1, VALID_DIFF = 2;

  @Override
  public int rotatedDigits(int N) {
    final int[] dp = new int[N + 1];
    int count = 0;
    for (int i = 0; i <= N; i++) {
      if (i < 10) {
        if (i == 0 || i == 1 || i == 8) {
          dp[i] = VALID_SAME;
        } else if (i == 2 || i == 5 || i == 6 || i == 9) {
          dp[i] = VALID_DIFF;
          count++;
        }
      } else {
        final int a = dp[i / 10], b = dp[i % 10];
        if (a != INVALID_ROTATE && b != INVALID_ROTATE) {
          if (a == VALID_SAME && b == VALID_SAME) {
            dp[i] = VALID_SAME;
          } else if (a == VALID_DIFF || b == VALID_DIFF) {
            dp[i] = VALID_DIFF;
            count++;
          }
        }
      }
    }
    return count;
  }
}
