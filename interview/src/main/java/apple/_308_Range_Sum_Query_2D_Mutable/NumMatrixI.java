package apple._308_Range_Sum_Query_2D_Mutable;

/**
 * @author jacka
 * @version 1.0 on 3/4/2021
 */
public final class NumMatrixI implements NumMatrix {
  private final int[][] matrix;
  private final SegmentTreeNode root;
  private final int rows, cols;

  public NumMatrixI(final int[][] matrix) {
    this.matrix = matrix;
    if (matrix == null || matrix.length == 0) {
      root = null;
      rows = 0;
      cols = 0;
    } else {
      rows = matrix.length;
      cols = matrix[0].length;
      root = buildTree(matrix, 0, rows - 1, 0, cols - 1);
    }
  }

  private boolean isRowInRange(final int start, final int row, final int end) {
    return start <= row && row <= end;
  }

  private SegmentTreeNode buildTree(int[][] matrix, int row1, int row2, int col1, int col2) {
    if (row2 < row1 || col2 < col1 || !isRowInRange(0, row1, rows - 1) || !isRowInRange(0, row2, rows - 1) ||
        !isRowInRange(0, col1, cols - 1) || !isRowInRange(0, col2, cols - 1)) {
      return null;
    }
//    System.out.println("row1 = " + row1 + ", row2 = " + row2 + ", col1 = " + col1 + ", col2 = " + col2);
    final SegmentTreeNode root = new SegmentTreeNode(row1, row2, col1, col2);
    if (row1 == row2 && col1 == col2) {
      root.sum = matrix[row1][col1];
      return root;
    }
    final int midRow = row1 + (row2 - row1) / 2,
        midCol = col1 + (col2 - col1) / 2;
    root.leftTop = buildTree(matrix, row1, midRow, col1, midCol);
    root.rightTop = buildTree(matrix, row1, midRow, midCol + 1, col2);
    root.leftBottom = buildTree(matrix, midRow + 1, row2, col1, midCol);
    root.rightBottom = buildTree(matrix, midRow + 1, row2, midCol + 1, col2);
    root.sum += root.leftTop == null ? 0 : root.leftTop.sum;
    root.sum += root.rightTop == null ? 0 : root.rightTop.sum;
    root.sum += root.leftBottom == null ? 0 : root.leftBottom.sum;
    root.sum += root.rightBottom == null ? 0 : root.rightBottom.sum;
    return root;
  }

  public void update(int row, int col, int val) {
    update(root, row, col, val - matrix[row][col]);
    matrix[row][col] = val;
  }

  private void update(SegmentTreeNode root, int row, int col, int diff) {
    if (root == null || row < root.row1 || row > root.row2 || col < root.col1 || col > root.col2) {
      return;
    }
    root.sum += diff;
    if (root.row1 == row && row == root.row2 && col == root.col1 && col == root.col2) {
      return;
    }
    update(root.leftTop, row, col, diff);
    update(root.rightTop, row, col, diff);
    update(root.leftBottom, row, col, diff);
    update(root.rightBottom, row, col, diff);
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return sumRegion(root, row1, col1, row2, col2);
  }

  private int sumRegion(SegmentTreeNode root, int row1, int col1, int row2, int col2) {
    if (root == null) {
      return 0;
    }
    if (row1 <= root.row1 && root.row2 <= row2 && col1 <= root.col1 && root.col2 <= col2) {
      return root.sum;
    }
    return sumRegion(root.leftTop, row1, col1, row2, col2)
        + sumRegion(root.leftBottom, row1, col1, row2, col2)
        + sumRegion(root.rightTop, row1, col1, row2, col2)
        + sumRegion(root.rightBottom, row1, col1, row2, col2);
  }

  private static final class SegmentTreeNode {
    private SegmentTreeNode leftTop, rightTop, leftBottom, rightBottom;
    private final int row1, row2, col1, col2;
    private int sum = 0;

    private SegmentTreeNode(int row1, int row2, int col1, int col2) {
      this.row1 = row1;
      this.row2 = row2;
      this.col1 = col1;
      this.col2 = col2;
    }
  }
}
