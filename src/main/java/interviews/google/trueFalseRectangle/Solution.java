package interviews.google.trueFalseRectangle;

/**
 * @author jacka
 * @version 1.0 on 1/28/2018.
 */
public class Solution {

  /**
   * 第二题是给一个2D T/F matrix，然后让判断其中是否存在一个四个角都是true
   * 的矩形，确认了一下是必须要四个点单行单列的不算，然后我因为当时脑袋宕机了一开始死活想不到最优解，就愣了近一分钟，然后小哥就主动问我有什么想法了，然后我就先给了一个O(n2m2)
   * 的暴力解，在讲的过程中又想到一个O（nm2)的优化，又说了，然后后来又想到一个可能能再优化一些但是也还是到不了O(nm)
   * 的，想着说了总比不说强吧，但那阵已经没什么时间了，下一个面试官也到了，小哥就一直在pack up他的东西，也不知道听进去了多少，不过小哥临走前还一直在祝福我希望他是没有打算挂我吧。。
   */
  public boolean existTrueRectangle(final boolean[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    if (rows < 2 || cols < 2) {
      return false;
    }
    final int[][] trueCounts = new int[rows][cols];
    for (int col = 0; col < cols; col++) {
      if (matrix[0][col]) {
        trueCounts[0][col] = 1;
      }
    }
    for (int row = 1; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        trueCounts[row][col] = matrix[row][col] ? (trueCounts[row - 1][col] + 1) : 0;
        if (col > 0 && trueCounts[row][col] >= 2 && trueCounts[row][col - 1] >= 2) {
          return true;
        }
      }
    }
    return false;
  }
}
