package _1401_1450._1423_Maximum_Points_You_Can_Obtain_from_Cards;

public final class SolutionI implements Solution {
  @Override
  public int maxScore(int[] cardPoints, int k) {
    final int n = cardPoints.length;
    final int[] sum = new int[1 + n];
    for (int i = 0; i < n; ++i) {
      sum[i + 1] = sum[i] + cardPoints[i];
    }
    int max = 0;
    for (int left = 0; left <= k; left++) {
      final int leftSum = sum[left],
          rightSum = sum[n] - sum[n - (k - left)];
      max = Math.max(max, leftSum + rightSum);
    }
    return max;
  }
}
