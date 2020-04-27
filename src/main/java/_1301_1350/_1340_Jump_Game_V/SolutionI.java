package _1301_1350._1340_Jump_Game_V;

/**
 * @author jacka
 * @version 1.0 on 4/26/2020
 */
public final class SolutionI implements Solution {
  private final Integer[] cache = new Integer[1001];

  /**
   * Time complexity: O(Nd)
   * Space Complexity: O(N)
   */
  public int maxJumps(int[] arr, int d) {
    int res = 0;
    for (int i = 0; i < arr.length; ++i) {
      res = Math.max(res, 1 + dfs(arr, d, i));
    }
    return res;
  }

  private int dfs(final int[] arr, final int d, final int i) {
    if (cache[i] != null) {
      return cache[i];
    }
    int max = 0;
    for (int j = i + 1; j < arr.length && j <= i + d && arr[j] < arr[i]; j++) {
      final int cur = 1 + dfs(arr, d, j);
      max = Math.max(cur, max);
    }
    for (int j = i - 1; j >= 0 && j >= i - d && arr[j] < arr[i]; --j) {
      final int cur = 1 + dfs(arr, d, j);
      max = Math.max(cur, max);
    }
    cache[i] = max;
    return max;
  }
}
