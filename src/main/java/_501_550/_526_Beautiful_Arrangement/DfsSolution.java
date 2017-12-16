package _501_550._526_Beautiful_Arrangement;

public class DfsSolution implements Solution {

  public int countArrangement(int N) {
    final boolean[] visited = new boolean[N];
    return dfs(visited, 0);
  }

  private int dfs(boolean[] visited, int index) {
    if (index == visited.length) {
      return 1;
    } else {
      int count = 0;
      for (int i = 0; i < visited.length; i++) {
        if (!visited[i] && ((i + 1) % (index + 1) == 0 || (index + 1) % (1 + i) == 0)) {
          visited[i] = true;
          count += dfs(visited, index + 1);
          visited[i] = false;
        }
      }
      return count;
    }
  }
}
