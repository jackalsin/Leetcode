package _0751_0800._790_Domino_and_Tromino_Tiling;

public class Solution {
  private static final int BASE = (int) (1E9 + 7);

  /**
   * Time Complexity: O(N)
   *
   * <p>39 / 39 test cases passed.
   * Status: Accepted
   * Runtime: 5 ms
   *
   * @param N
   * @return
   */
  public int numTilings(int N) {
    final long[] dp = new long[Math.max(N, 3) + 1];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 5;
    for (int i = 4; i <= N; i++) {
      dp[i] = (dp[i - 3] + 2 * dp[i - 1]) % BASE;
    }
    return (int) dp[N];
  }
}
