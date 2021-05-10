package google._308_Range_Sum_Query_2D_Mutable;

/**
 * @author jacka
 * @version 1.0 on 5/9/2021
 */
public final class NumMatrixIII implements NumMatrix {
  private final int[][] matrix;
  private final int rows, cols;
  private final Node root;

  public NumMatrixIII(int[][] matrix) {
    this.matrix = matrix;
    if (matrix == null || matrix.length == 0) {
      this.rows = 0;
      this.cols = 0;
    } else {
      this.rows = matrix.length;
      this.cols = matrix[0].length;
    }
    this.root = buildTree(0, rows - 1, 0, cols - 1);
  }

  private Node buildTree(final int startRow, final int endRow, final int startCol, final int endCol) {
    if (startRow > endRow || startCol > endCol) return null;
    final Node root = new Node(startRow, endRow, startCol, endCol);
    if (startRow == endRow && startCol == endCol) {
      root.sum = matrix[startRow][startCol];
      return root;
    }
    final int midRow = startRow + (endRow - startRow) / 2,
        midCol = startCol + (endCol - startCol) / 2;
    root.topLeft = buildTree(startRow, midRow, startCol, midCol);
    root.topRight = buildTree(startRow, midRow, midCol + 1, endCol);
    root.bottomLeft = buildTree(midRow + 1, endRow, startCol, midCol);
    root.bottomRight = buildTree(midRow + 1, endRow, midCol + 1, endCol);
    root.sum =
        (root.topRight == null ? 0 : root.topRight.sum)
            + (root.topLeft == null ? 0 : root.topLeft.sum)
            + (root.bottomRight == null ? 0 : root.bottomRight.sum)
            + (root.bottomLeft == null ? 0 : root.bottomLeft.sum);
    return root;
  }

  public void update(int row, int col, int val) {
    update(root, row, col, val - matrix[row][col]);
    matrix[row][col] = val;
  }

  private void update(final Node root, int row, int col, int diff) {
    if (root == null || row < root.row1 || root.row2 < row || col < root.col1 || root.col2 < col) return;
    root.sum += diff;
    update(root.topLeft, row, col, diff);
    update(root.topRight, row, col, diff);
    update(root.bottomLeft, row, col, diff);
    update(root.bottomRight, row, col, diff);
  }


  public int sumRegion(int row1, int col1, int row2, int col2) {
    return sumRegion(root, row1, col1, row2, col2);
  }

  private int sumRegion(final Node root, final int row1, final int col1, final int row2, final int col2) {
    if (root == null || row2 < root.row1 || row1 > root.row2 || col2 < root.col1 || col1 > root.col2) return 0;
    if (row1 <= root.row1 && root.row2 <= row2 && col1 <= root.col1 && root.col2 <= col2) return root.sum;
    return sumRegion(root.topLeft, row1, col1, row2, col2)
        + sumRegion(root.topRight, row1, col1, row2, col2)
        + sumRegion(root.bottomLeft, row1, col1, row2, col2)
        + sumRegion(root.bottomRight, row1, col1, row2, col2);
  }

  private static final class Node {
    private final int row1, row2, col1, col2;
    private Node topLeft, topRight, bottomLeft, bottomRight;

    private int sum = 0;

    private Node(int row1, int row2, int col1, int col2) {
      this.row1 = row1;
      this.row2 = row2;
      this.col1 = col1;
      this.col2 = col2;
    }
  }
}
