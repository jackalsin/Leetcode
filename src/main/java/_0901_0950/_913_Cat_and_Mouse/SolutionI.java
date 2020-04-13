package _0901_0950._913_Cat_and_Mouse;

import java.util.ArrayDeque;
import java.util.Queue;

public final class SolutionI implements Solution {
  /*
   https://leetcode.com/problems/cat-and-mouse/discuss/176177/Most-of-the-DFS-solutions-are-WRONG-check-this-case
  */
  private static final int DRAW = 0, MOUSE_WIN = 1, CAT_WIN = 2;
  private static final int MOUSE = 0, CAT = 1;
  //                          cat, mouse, turn (mouse turn = 0)
  private final int[][][] color = new int[50][50][2],
      outDegree = new int[50][50][2];

  public int catMouseGame(int[][] graph) {
    final int N = graph.length;
    // outdegree
    for (int cat = 0; cat < N; ++cat) {
      for (int mouse = 0; mouse < N; ++mouse) {
        outDegree[cat][mouse][0] = graph[mouse].length;
        outDegree[cat][mouse][1] = graph[cat].length;
        for (int p : graph[cat]) {
          if (p == 0) {
            outDegree[cat][mouse][1]--;
          }
        }
      }
    } // end of out degree loop

    final Queue<int[]> q = new ArrayDeque<>();
    for (int i = 1; i < N; ++i) {
      // [0][0] 不可能发生，老鼠和猫同时再洞里
      for (int t = 0; t < 2; t++) {
        color[i][i][t] = CAT_WIN;
        q.add(new int[]{i, i, t, CAT_WIN});
        color[i][0][t] = MOUSE_WIN;
        q.add(new int[]{i, 0, t, MOUSE_WIN});
      }
    }
    while (!q.isEmpty()) {
      final int[] toRemove = q.remove();
      final int cat = toRemove[0], mouse = toRemove[1], turn = toRemove[2], result = toRemove[3];
      if (cat == 2 && mouse == 1 && turn == MOUSE) {
        return result;
      }
      final int prevTurn = 1 - turn;
      for (final int prev : graph[prevTurn == CAT ? cat : mouse]) {
        final int prevCat = prevTurn == CAT ? prev : cat,
            prevMouse = prevTurn == CAT ? mouse : prev;
        if (prevCat == 0) continue;
        if (color[prevCat][prevMouse][prevTurn] > 0) continue;
        if (--outDegree[prevCat][prevMouse][prevTurn] == 0
            || prevTurn == MOUSE && result == MOUSE_WIN
            || prevTurn == CAT && result == CAT_WIN) {
          color[prevCat][prevMouse][prevTurn] = result;
          q.add(new int[]{prevCat, prevMouse, prevTurn, result});
        }
      }
    } // end of while loop
//    System.out.println(Arrays.deepToString(color));
    return color[2][1][0];
  }
}
