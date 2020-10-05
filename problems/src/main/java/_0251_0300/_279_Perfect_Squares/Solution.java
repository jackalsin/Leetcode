package _0251_0300._279_Perfect_Squares;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/2/2017.
 */
public class Solution {
  public int numSquares(int n) {
//    return bfs(n);
    return dp(n);
  }

  /**
   * 49 ms;
   * O (N * sqrt(N))
   *
   * @param n
   * @return
   */
  private int dp(int n) {
    int[] perfectSquareCount = new int[n + 1];
    Arrays.fill(perfectSquareCount, Integer.MAX_VALUE);
    perfectSquareCount[0] = 0;
    for (int i = 1; i <= n; ++i) {

      // perfectSquareCount[i] = perfectSquareCount[??] + perfectSquare;
      for (int j = 1; j * j <= i; ++j) {
        perfectSquareCount[i] = Math.min(perfectSquareCount[i], perfectSquareCount[i - j * j] + 1);
      }
    }
    return perfectSquareCount[n];
  }

  private int bfs(int n) {
    if (n <= 0) return 0;
    final List<Integer> perfectSquares = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    for (int i = 1; i * i <= n; ++i) {
      perfectSquares.add(i * i);
      visited.add(i * i);
    }
    if (perfectSquares.get(perfectSquares.size() - 1) == n) return 1;
    Queue<Integer> queue = new ArrayDeque<>();
    queue.addAll(perfectSquares);
    int curCount = 1;
    while (!queue.isEmpty()) {
      curCount++;
      int size = queue.size();
      for (int i = 0; i < size; ++i) {
        int tmp = queue.peek();
        for (int perfectSquare : perfectSquares) {
          if (tmp + perfectSquare == n) {
            return curCount;
          } else if (tmp + perfectSquare > n) {
            break;
          } else {
            if (!visited.contains(tmp + perfectSquare)) {
              visited.add(tmp + perfectSquare);
              queue.add(tmp + perfectSquare);
            }
          }
        }
        queue.remove();
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i < 10; ++i) {
      queue.add(i);
    }
    System.out.println(queue.peek());
    while (!queue.isEmpty()) {
      System.out.println(queue.remove());
    }
  }
}
