package _0901_0950._920_Number_of_Music_Playlists;

public class Solution {
  private static final int MOD = (int) 1E9 + 7;

  /**
   *
   * @param N total song number
   * @param L total length
   * @param K
   * @return
   */
  public int numMusicPlaylists(int N, int L, int K) {
    // list has L songs, N is unique
    final long[][] dp = new long[L + 1][N + 1];
    dp[0][0] = 1;
    for (int i = 0; i < L; i++) {
      for (int j = 0; j < N; j++) {
        // i = 2, j = 1
        dp[i + 1][j + 1] = dp[i][j] * (N - j) + dp[i][j + 1] * Math.max(0, j + 1 - K);
        dp[i + 1][j + 1] %= MOD;
      }
    }
    return (int) dp[L][N];
  }
}
