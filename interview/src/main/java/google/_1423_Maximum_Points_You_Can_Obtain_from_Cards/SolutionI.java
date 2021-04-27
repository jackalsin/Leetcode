package google._1423_Maximum_Points_You_Can_Obtain_from_Cards;

/**
 * @author jacka
 * @version 1.0 on 4/26/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int maxScore(int[] cardPoints, int k) {
    if (cardPoints == null || cardPoints.length == 0) {
      return 0;
    }
    int sum = 0;
    for (int left = 0; left < k; ++left) {
      sum += cardPoints[left];
    }
    final int n = cardPoints.length;
    int max = sum;
    for (int left = k - 1, right = n - 1; left >= 0; left--, right--) {
      sum += -cardPoints[left] + cardPoints[right];
      max = Math.max(max, sum);
    }
    return max;
  }
}
