package microsoft._651_4_Keys_Keyboard;

public class Solution {
  public int maxA(int N) {
    if (N <= 6) {
      return N;
    }

    final int[] dp = new int[N + 1];
    for (int i = 1; i <= 6; i++) {
      dp[i] = i;
    }
    for (int i = 7; i <= N; i++) {
      for (int j = 1; j <= i - 3; j++) {
        dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
      }
//      System.out.println(Arrays.toString(dp));
    }

    return dp[N];
  }
}
