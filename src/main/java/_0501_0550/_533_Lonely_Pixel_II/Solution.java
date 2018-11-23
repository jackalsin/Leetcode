package _0501_0550._533_Lonely_Pixel_II;

import java.util.*;

public class Solution {
  public int findBlackPixel(char[][] picture, int N) {
    if (picture == null || picture.length == 0 || picture[0].length == 0) {
      return 0;
    }
    final int rows = picture.length, cols = picture[0].length;
    final int[] rowCounts = new int[rows], colCounts = new int[cols];
    List<Set<Integer>> rowsHavingSameBCol = new ArrayList<>();
    for (int i = 0; i < cols; i++) rowsHavingSameBCol.add(new HashSet<>());
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (picture[row][col] == 'B') {
          rowsHavingSameBCol.get(col).add(row);
          rowCounts[row]++;
          colCounts[col]++;
        }
      }
    }

    int count = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (rowCounts[row] == N && colCounts[col] == N) {
          Set<Integer> rowIndex = rowsHavingSameBCol.get(col);
          boolean isValid = true;
          for (int candidateRow : rowIndex) {
            if (!Arrays.equals(picture[candidateRow], picture[row])) {
              isValid = false;
            }
          }
          if (isValid) count++;
        }
      }
    }

    return count;
  }
}
