package _0501_0550._531_Lonely_Pixel_I;


public final class O1SpaceSolution implements Solution {
  @Override
  public int findLonelyPixel(char[][] picture) {
    if (picture == null || picture.length == 0 || picture[0].length == 0) {
      return 0;
    }
    int firstRowCount = 0;
    final int rows = picture.length, cols = picture[0].length;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (picture[row][col] == 'B') {
          if (picture[0][col] != 'W' - 1 && picture[0][col] != 'W' + 2) picture[0][col]++;
          if (row == 0) firstRowCount++;
          else {
            if (picture[row][0] != 'W' - 1 && picture[row][0] != 'W' + 2) picture[row][0]++;
          }
        }
      }
    }
//    TwoDimensionArray.display2DimensionArray(picture);
    int count = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if ((picture[row][col] == 'B' || picture[row][col] == 'C') && (picture[0][col] == 'C' || picture[0][col] == 'X')) {
          if (row == 0) count += firstRowCount == 1 ? 1 : 0;
          else {
            if (picture[row][0] == 'C' || picture[row][0] == 'X') {
              count++;
            }
          }
        }
      }
    }
    return count;
  }
}
