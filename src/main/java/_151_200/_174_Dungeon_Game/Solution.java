package _151_200._174_Dungeon_Game;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/31/2017.
 */
public class Solution {

  public int calculateMinimumHP(int[][] dungeon) {
    if (dungeon == null || dungeon.length == 0) return 0;
    int rows = dungeon.length;
    int cols = dungeon[0].length;
    int[] healths = new int[cols];
    for (int col = 0; col < cols; col++) {
      if (col == 0) {
        healths[col] = dungeon[0][col];
      } else {
        healths[col] = healths[col - 1] + dungeon[0][col];
      }
    }

    for (int row = 1; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (col == 0) {
          healths[col] += dungeon[row][col];
        } else {
          healths[col] = Math.max(healths[col - 1], healths[col]) + dungeon[row][col];
        }
      }
    }
    return Math.max(0, -healths[cols - 1]);
  }

}
