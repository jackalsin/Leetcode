package _0551_0600._573_Squirrel_Simulation;

/**
 * @author jacka
 * @version 1.0 on 3/1/2020
 */
public final class TwoPassSolution implements Solution {
  @Override
  public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
    int total = 0;
    for (int i = 0; i < nuts.length; ++i) {
      final int[] nut = nuts[i];
      final int cur = getDistance(nut, tree);
      total += cur * 2;
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < nuts.length; ++i) {
      final int cur = total - getDistance(nuts[i], tree) + getDistance(squirrel, nuts[i]);
      min = Math.min(cur, min);
    }
    return min;
  }

  private static Integer getDistance(final int[] nut, final int[] tree) {
    return Math.abs(nut[0] - tree[0]) + Math.abs(nut[1] - tree[1]);
  }
}
