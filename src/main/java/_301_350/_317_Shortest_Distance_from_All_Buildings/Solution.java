package _301_350._317_Shortest_Distance_from_All_Buildings;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/21/2017.
 */
public class Solution {
  private static final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  /**
   * You want to build a house on an empty land which reaches all buildings in the shortest amount
   * of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1
   * or 2, where:
   * Each 0 marks an empty land which you can pass by freely.
   * Each 1 marks a building which you cannot pass through.
   * Each 2 marks an obstacle which you cannot pass through.
   * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
   * 1 - 0 - 2 - 0 - 1
   * |   |   |   |   |
   * 0 - 0 - 0 - 0 - 0
   * |   |   |   |   |
   * 0 - 0 - 1 - 0 - 0
   * The point (1,2) is an ideal empty land to build a house, as the total travel distance of
   * 3+3+1=7 is minimal. So return 7.
   *
   * Note:
   * There will be at least one building. If it is not possible to build such house according to
   * the above rules, return -1.
   * @param grid
   * @return
   */
  public int shortestDistance(int[][] grid) {
    int rows = grid.length;
    if (rows == 0) return 0;
    int cols = grid[0].length;

    final int[][] distance = new int[rows][cols];

    int totalBuildings = 0;
    final int[][] reachedBuildings = new int[rows][cols];
    Queue<int[]> queue = new ArrayDeque<>();
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (grid[row][col] == 1) {
          queue.add(new int[]{row, col});
          final boolean[][] visited = new boolean[rows][cols];
          int level = 0;
          ++totalBuildings;
          while (!queue.isEmpty()) {
            int size = queue.size();
            ++level;
            for (int i = 0; i < size; ++i) {
              int[] curCoordinate = queue.remove();
              for (int[] dir : DIR) {
                int nextRow = curCoordinate[0]+ dir[0];
                int nextCol = curCoordinate[1]+ dir[1];

                if (isValid(visited, grid, nextRow, nextCol)) {
                  ++reachedBuildings[nextRow][nextCol];
                  distance[nextRow][nextCol] += level;
                  visited[nextRow][nextCol] = true;
                  queue.add(new int[]{nextRow, nextCol});
                }
              } // end of for loop dir

            }
          } // end of while loop

        }
      }
    }

    // --- go to find the min distance
    int minDistance = Integer.MAX_VALUE;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (reachedBuildings[row][col] == totalBuildings && minDistance > distance[row][col]) {
          minDistance = distance[row][col];
        }
      }
    }
    return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
  }

  private static boolean isValid(final boolean[][] visited, final int[][] grid,
                                 final int row, final int col) {
    return row >= 0 && row < visited.length && col >= 0 && col < visited[0].length &&
        !visited[row][col] && grid[row][col] == 0;

  }
}
