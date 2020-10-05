package facebook._221_Maximal_Square;

public class Solution {
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }

    final int rows = matrix.length, cols = matrix[0].length;
    int res = 0;
    final int[] prev = new int[cols];
    for (int i = 0; i < rows; i++) {
      final int[] cur = new int[cols];
      if (matrix[i][0] == '1') {
        cur[0] = Math.min(1, prev[0] + 1);
        res = Math.max(res, cur[0]);
      }
      for (int j = 1; j < cols; j++) {
        if (matrix[i][j] == '1') {
          cur[j] = Math.min(Math.min(prev[j - 1], cur[j - 1]), prev[j]) + 1;
          res = Math.max(res, cur[j]);
        } else {
          cur[j] = 0; //这个容易忘
        }
      }
      System.arraycopy(cur, 0, prev, 0, cur.length);
//      System.out.println(Arrays.toString(prev));
    }
    return res * res;
  }
}
