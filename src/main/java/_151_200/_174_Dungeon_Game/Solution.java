package _151_200._174_Dungeon_Game;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/31/2017.
 */
public class Solution {

  private static final int MIN_HEALTH = 1;

  public int calculateMinimumHP(int[][] dungeon) {
    if (dungeon == null || dungeon.length == 0) return 0;
    int rows = dungeon.length;
    int cols = dungeon[0].length;
    int[] healths = new int[cols];
    for (int col = cols - 1; col >= 0; col--) {
      if (col == cols - 1) {
        healths[col] = Math.max(MIN_HEALTH, MIN_HEALTH - dungeon[rows - 1][col]);
      } else {
        healths[col] = Math.max(MIN_HEALTH, healths[col + 1] - dungeon[rows - 1][col]);
      }
    }

    for (int row = rows - 2; row >= 0; --row) {
      for (int col = cols - 1; col >= 0; --col) {
        if (col == cols - 1) {
          healths[col] = Math.max(MIN_HEALTH, healths[col] - dungeon[row][col]);
        } else {
          int fromDown = healths[col] - dungeon[row][col];
          int fromRight = healths[col + 1] - dungeon[row][col];
          healths[col] = Math.max(MIN_HEALTH, Math.min(fromDown, fromRight));
        }
      }
    }
    return healths[0];
  }

}
