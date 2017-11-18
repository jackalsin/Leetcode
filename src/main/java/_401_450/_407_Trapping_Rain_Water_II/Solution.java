package _401_450._407_Trapping_Rain_Water_II;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 */
public class Solution {
  private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  public int trapRainWater(int[][] heightMap) {
    if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) {
      return 0;
    }
    final int rows = heightMap.length, cols = heightMap[0].length;
    final boolean[][] visited = new boolean[rows][cols];
    final Queue<Cell> queue = new PriorityQueue<>(new Comparator<Cell>() {
      @Override
      public int compare(Cell o1, Cell o2) {
        return Integer.compare(o1.height, o2.height);
      }
    });

    // add all boundary to the boundary to the pq,
    for (int row = 0; row < rows; row++) {
      visited[row][0] = visited[row][cols - 1] = true;
      queue.add(new Cell(row, 0, heightMap[row][0]));
      queue.add(new Cell(row, cols - 1, heightMap[row][cols - 1]));
    }
    for (int col = 0; col < cols; col++) {
      visited[0][col] = visited[rows - 1][col] = true;
      queue.add(new Cell(0, col, heightMap[0][col]));
      queue.add(new Cell(rows - 1, col, heightMap[rows - 1][col]));
    }

    int result = 0;

    while (!queue.isEmpty()) {
      final Cell curCell = queue.remove();
      final int row = curCell.row, col = curCell.col, height = curCell.height;
      for (int[] dir : DIRS) {
        int nextRow = row + dir[0], nextCol = col + dir[1];
        if (nextRow >= 0 && nextCol >=0 && nextRow < rows && nextCol < cols && !visited[nextRow][nextCol]) {
          visited[nextRow][nextCol] = true;
          result += Math.max(0, height - heightMap[nextRow][nextCol]);
          queue.add(new Cell(nextRow, nextCol, Math.max(height, heightMap[nextRow][nextCol])));
        }
      }
    }

    return result;
  }


  private static class Cell {
    private final int row, col, height;

    private Cell(int row, int col, int height) {
      this.row = row;
      this.col = col;
      this.height = height;
    }
  }
}
