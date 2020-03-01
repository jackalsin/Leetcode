package _0551_0600._573_Squirrel_Simulation;

/**
 * @author jacka
 * @version 1.0 on 3/1/2020
 */
public class OnePassSolution implements Solution {
  @Override
  public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
    int sum = 0, maxDiff = Integer.MIN_VALUE;
    for (final int[] nut : nuts) {
      final int distanceToTree = getDistance(nut, tree);
      sum += 2 * distanceToTree;
      maxDiff = Math.max(maxDiff, distanceToTree - getDistance(nut, squirrel));
    }
    return sum - maxDiff;
  }

  private static int getDistance(final int[] a, final int[] b) {
    return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
  }
}
