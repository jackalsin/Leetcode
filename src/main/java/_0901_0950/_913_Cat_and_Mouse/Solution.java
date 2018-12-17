package _0901_0950._913_Cat_and_Mouse;

public final class Solution {
  //Mouse starts at node 1 and goes first, Cat starts at node 2 and goes second, and there is a Hole at node 0.
  private static final int UNVISITED = 0, DRAW = -1, MOUSE_WIN = 1, CAT_WIN = 2;

  // mouse should choose MOUSE_WIN > DRAW > CAT_WIN
  // cat should choose MOUSE_WIN < DRAW < CAT_WIN

  public int catMouseGame(int[][] graph) {
    final int N = graph.length;
    // dp[i][j] indicates the status when mouse is in i, and cat is in j
    final int[][] dp = new int[N][N];
    for (int i = 0; i < N; i++) {
      dp[i][i] = CAT_WIN;
      dp[0][i] = MOUSE_WIN; // dp[0][0] will be overwritten
    }
    final int res = dfs(dp, graph, 1, 2);

//    display(dp);
    return res == DRAW ? 0 : res;
  }

  private static int dfs(final int[][] dp, final int[][] graph, final int mouse, final int cat) {
    if (dp[mouse][cat] != UNVISITED) return dp[mouse][cat];

    dp[mouse][cat] = DRAW; // it at least will be a draw ...
    final int[] catNeighbors = graph[cat], mouseNeighbors = graph[mouse];

    int mouseState = CAT_WIN;

    for (int mouseNeighbor : mouseNeighbors) {
      int catState = MOUSE_WIN;
      if (mouseNeighbor == cat) continue;

      for (int catNeighbor : catNeighbors) {
        if (catNeighbor == 0) continue; // cannot go to the hole
        int nextState = dfs(dp, graph, mouseNeighbor, catNeighbor);
        if (nextState == CAT_WIN) {
          catState = CAT_WIN;
          break;
        } else if (catState == MOUSE_WIN && nextState == DRAW) {
          catState = DRAW;
        }
      }
      if (catState == MOUSE_WIN) {
        mouseState = MOUSE_WIN;
        break;
      }
      if (catState == DRAW) {
        mouseState = DRAW;
      }
    } // end of for loop

    dp[mouse][cat] = mouseState;
    return dp[mouse][cat];
  }
}
