package _0301_0350._302_Smallest_Rectangle_Enclosing_Black_Pixels;

/**
 * @author jacka
 * @version 1.0 on 9/11/2017.
 */
public class Solution {
  private int left = 0, right = 0, top = 0, bottom = 0;
  private boolean[][] visited;

  public int minArea(char[][] image, int x, int y) {
    visited = new boolean[image.length][image[0].length];
    if (image[x][y] == '0') return 0;
    left = y; right = y; top = x; bottom = x;
    update(image, x, y);
    return (right - left + 1) * (bottom - top + 1);
  }

  private void update(char[][] image, int row, int col) {
    if (image[row][col] == '1') {
      left = Math.min(col, left);
      right = Math.max(col, right);
      top = Math.min(row, top);
      bottom = Math.max(row, bottom);
      visited[row][col] = true;
      if (isValid(image, row + 1, col)) {
        update(image, row + 1, col);
      }
      if (isValid(image, row - 1, col)) {
        update(image, row - 1, col);
      }
      if (isValid(image, row, col + 1)) {
        update(image, row, col + 1);
      }
      if (isValid(image, row, col - 1)) {
        update(image, row, col - 1);
      }
    }
  }

  private boolean isValid(char[][] image, int row, int col) {
    return row >= 0 && row < image.length && col >= 0 && col < image[0].length &&
        !visited[row][col] && image[row][col] == '1';
  }

}
