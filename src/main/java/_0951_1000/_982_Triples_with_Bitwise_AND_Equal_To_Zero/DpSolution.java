package _0951_1000._982_Triples_with_Bitwise_AND_Equal_To_Zero;

public final class DpSolution implements Solution {
  public int countTriplets(int[] A) {
    final int[][] dp = new int[3][1 << 16];
    for (int a : A) {
      dp[0][a]++;
    }

    for (int i = 1; i < 3; i++) {
      for (int a : A) {
        for (int b = 0; b < (1 << 16); b++) {
          dp[i][a & b] += dp[i - 1][b];
        }
      }
    }
    return dp[2][0];
  }

}
