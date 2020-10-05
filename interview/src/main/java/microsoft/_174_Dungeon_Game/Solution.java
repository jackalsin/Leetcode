package microsoft._174_Dungeon_Game;

import java.util.Arrays;

public class Solution {
  public int calculateMinimumHP(int[][] dungeon) {
    if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
      return 1;
    }
    final int rows = dungeon.length, cols = dungeon[0].length;
    final int[][] minHp = new int[rows + 1][cols + 1];

    // fill with Max int
    for (final int[] row : minHp) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }

    minHp[rows - 1][cols] = 1;
    minHp[rows][cols - 1] = 1;

    // for loop
    for (int row = rows - 1; row >= 0; row--) {
      for (int col = cols - 1; col >= 0; col--) {
        int res = Math.min(minHp[row + 1][col], minHp[row][col + 1]) - dungeon[row][col];
        minHp[row][col] = Math.max(1, res);
      }
    }
    return minHp[0][0];
  }
}
