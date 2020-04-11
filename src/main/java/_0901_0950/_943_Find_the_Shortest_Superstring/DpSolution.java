package _0901_0950._943_Find_the_Shortest_Superstring;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 4/10/2020
 */
public final class DpSolution implements Solution {
  @Override
  public String shortestSuperstring(String[] A) {
    /*
    这其实跟其他solution没有太多区别，只是比较省空间
    Time Complexity: O(n^2 * 2^n)
    Space Complexity: O(n^2)
     */
    final int[][] graph = getGraph(A);
    final int N = A.length;
    final int[][] distances = new int[1 << N][N],
        parent = new int[1 << N][N];

    for (int i = 0; i < (1 << N); ++i) {
      Arrays.fill(distances[i], Integer.MAX_VALUE);
      for (int j = 0; j < N; ++j) {
        if ((i & (1 << j)) > 0) {
          final int prev = i - (1 << j);
          if (prev == 0) {
            distances[i][j] = A[j].length();
          } else {
            for (int k = 0; k < N; ++k) {
              if (distances[prev][k] != Integer.MAX_VALUE && distances[prev][k] + graph[k][j] < distances[i][j]) {
                distances[i][j] = distances[prev][k] + graph[k][j];
                parent[i][j] = k;
              }
            }
          }
        }
      }
    }

    int minIndex = -1, minDistance = Integer.MAX_VALUE;
    for (int i = 0; i < N; ++i) {
      if (distances[(1 << N) - 1][i] < minDistance) {
        minIndex = i;
        minDistance = distances[(1 << N) - 1][i];
      }
    }
    final Deque<Integer> path = new ArrayDeque<>();
    int visited = (1 << N) - 1;
    while (visited != 0) {
      path.push(minIndex);
      final int prevVisit = visited;
      visited -= (1 << minIndex);
      minIndex = parent[prevVisit][minIndex];
    }
    final StringBuilder sb = new StringBuilder();
    int prev = -1;
    while (!path.isEmpty()) {
      final int cur = path.pop();
      if (sb.length() == 0) {
        sb.append(A[cur]);
      } else {
        sb.append(A[cur].substring(A[cur].length() - graph[prev][cur]));
      }
      prev = cur;
    }
    return sb.toString();
  }

  private int[][] getGraph(String[] strs) {
    final int N = strs.length;
    final int[][] res = new int[N][N];
    for (int i = 0; i < strs.length; ++i) {
      for (int j = 0; j < strs.length; ++j) {
        res[i][j] = distance(strs[i], strs[j]);
      }
    }
    return res;
  }

  private int distance(final String str1, final String str2) {
    final int len1 = str1.length(), len2 = str2.length();
    for (int overlap = str2.length(); overlap >= 0; overlap--) {
      if (str1.endsWith(str2.substring(0, overlap))) {
        return len2 - overlap;
      }
    }
    return str2.length();
  }

}
