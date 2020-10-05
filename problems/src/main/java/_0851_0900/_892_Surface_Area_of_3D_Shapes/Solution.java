package _0851_0900._892_Surface_Area_of_3D_Shapes;

public class Solution {

  public int surfaceArea(int[][] grid) {
    final int rows = grid.length, cols = grid[0].length;
    int side = 0, roof = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] > 0) {
          roof += 2;
        }
        side += 4 * grid[i][j];
        if (i > 0) {
          side -= 2 * Math.min(grid[i - 1][j], grid[i][j]);
        }
        if (j > 0) {
          side -= 2 * Math.min(grid[i][j - 1], grid[i][j]);
        }
        System.out.println(side);
      }
    }

    return roof + side;
  }
}
