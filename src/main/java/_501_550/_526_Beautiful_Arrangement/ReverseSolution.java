package _501_550._526_Beautiful_Arrangement;

/**
 * Reverse checking can save a lot of time
 * <p>
 * 15 / 15 test cases passed.
 * Status: Accepted
 * Runtime: 10 ms
 */
public class ReverseSolution implements Solution {
  public int countArrangement(int N) {
    final boolean[] visited = new boolean[N];
    return dfs(visited, N - 1);
  }

  private int dfs(boolean[] visited, int index) {
    if (index == 0) {
      return 1;
    } else {
      int count = 0;
      for (int i = visited.length - 1; i >= 0; i--) {
        if (!visited[i] && ((i + 1) % (index + 1) == 0 || (index + 1) % (1 + i) == 0)) {
          visited[i] = true;
          count += dfs(visited, index - 1);
          visited[i] = false;
        }
      }
      return count;
    }
  }
}
