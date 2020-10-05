package explore._997_Find_the_Town_Judge;

/**
 * @author jacka
 * @version 1.0 on 5/10/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int findJudge(int N, int[][] trust) {
    final int[] indegree = new int[N + 1];
    for (final int[] t : trust) {
      indegree[t[0]]--;
      indegree[t[1]]++;
    }
    for (int i = 1; i <= N; ++i) {
      if (indegree[i] == N - 1) return i;
    }
    return -1;
  }
}
