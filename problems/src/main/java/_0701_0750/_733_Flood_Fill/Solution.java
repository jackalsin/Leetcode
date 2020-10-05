package _0701_0750._733_Flood_Fill;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 2/5/2018.
 */
public class Solution {
  private static final int[][] DIRS = {
      {1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    final int replacedColor = image[sr][sc];
    final Queue<int[]> queue = new ArrayDeque<>();
    final int rows = image.length, cols = image[0].length;
    if (image[sr][sc] == newColor) {
      return image;
    }
    queue.add(new int[] {sr, sc});
    while (!queue.isEmpty()) {
      final int[] curPos = queue.remove();
      image[curPos[0]][curPos[1]] = newColor;
      for (final int[] dir : DIRS) {
        final int newRow = dir[0] + curPos[0], newCol = dir[1] + curPos[1];
        if (newRow < rows && newRow >= 0 && newCol < cols && newCol >= 0 && image[newRow][newCol]
            == replacedColor) {
          queue.add(new int[] {newRow, newCol});
        }
      }
    }
    return image;
  }
}
