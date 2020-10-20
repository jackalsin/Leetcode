package _1001_1050._1014_Best_Sightseeing_Pair;

public class Solution {
  public int maxScoreSightseeingPair(int[] A) {
    int score = -1;
    for (int j = 1, maxAi = A[0]; j < A.length; j++) {
      score = Math.max(score, A[j] - j + maxAi);
      maxAi = Math.max(maxAi, A[j] + j);
    }
    return score;
  }
}
