package _501_550._531_Lonely_Pixel_I;

/**
 * The space is O(M+N);
 */
public class OMNSpaceSolution implements Solution {
  public int findLonelyPixel(char[][] picture) {
    if (picture == null || picture.length == 0 || picture[0].length == 0) {
      return 0;
    }
    final int rows = picture.length, cols = picture[0].length;
    final int[] rowCount = new int[rows], colCounts = new int[cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (picture[row][col] == 'B') {
          rowCount[row]++;
          colCounts[col]++;
        }
      }
    }

    int count = 0;
    for (int row = 0; row < rows; row++) {
      if (rowCount[row] != 1) continue;
      for (int col = 0; col < cols; col++) {
        if (colCounts[col] != 1) continue;
        if (picture[row][col] == 'B') {
          count++;
        }
      }
    }
    return count;
  }
}
