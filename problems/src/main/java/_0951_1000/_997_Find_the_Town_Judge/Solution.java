package _0951_1000._997_Find_the_Town_Judge;

/**
 * @author jacka
 * @version 1.0 on 2/23/2019.
 */
public final class Solution {
  public int findJudge(int N, int[][] trust) {
    final int[] trustCount = new int[N + 1];
    for (int[] t : trust) {
      // trust count indegree - outdegree
      trustCount[t[0]]--;
      trustCount[t[1]]++;
    }
    for (int i = 1; i <= N; i++) {
      if (trustCount[i] == N - 1) {
        return i;
      }
    }
    return -1;
  }
}
