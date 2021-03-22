package _1501_1550._1514_Path_with_Maximum_Probability;

/**
 * @author jacka
 * @version 1.0 on 3/21/2021
 */
public final class NoPreCalculateMapSolution implements Solution {
  @Override
  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    final double[] prob = new double[n];
    prob[start] = 1d;
    for (int i = 0; i < n - 1; ++i) {
      boolean hasChanged = false;
      for (int j = 0; j < edges.length; ++j) {
        final int edge[] = edges[j], src = edge[0], dst = edge[1];

        if (prob[src] * succProb[j] > prob[dst]) {
          prob[dst] = prob[src] * succProb[j];
          hasChanged = true;
        }
        if (prob[dst] * succProb[j] > prob[src]) {
          prob[src] = prob[dst] * succProb[j];
          hasChanged = true;
        }
      }
      if (!hasChanged) break;
    }
    return prob[end];
  }
}
