package interviews.uber._733_Flood_Fill;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
  private static final int[][] DIRS = {
      {0, 1},
      {1, 0},
      {0, -1},
      {-1, 0},
  };

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    final int rows = image.length, cols = image[0].length;
    final int originalColor = image[sr][sc];
    final Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{sr, sc});
    // add its neighbor
    while (!queue.isEmpty()) {
      final int[] toRemove = queue.remove();
      final int startRow = toRemove[0], startCol = toRemove[1];
      image[toRemove[0]][toRemove[1]] = newColor;
      for (final int[] dir : DIRS) {
        final int newRow = startRow + dir[0], newCol = startCol + dir[1];
        if (newRow < rows && newRow >= 0 && newCol >= 0 && newCol < cols
            && image[newRow][newCol] == originalColor && image[newRow][newCol] != newColor) {
          queue.add(new int[]{newRow, newCol});
        }
      }
    }
    return image;
  }
}
