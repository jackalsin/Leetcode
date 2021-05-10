package google._308_Range_Sum_Query_2D_Mutable;

/**
 * @author jacka
 * @version 1.0 on 5/9/2021
 */
public final class NumMatrixII implements NumMatrix {
  private final int[][] matrix;
  private final Node root;
  private final int rows, cols;

  public NumMatrixII(final int[][] matrix) {
    if (matrix == null) throw new NullPointerException();
    this.matrix = matrix;
    if (matrix.length == 0) {
      root = null;
      rows = 0;
      cols = 0;
    } else {
      rows = matrix.length;
      cols = matrix[0].length;
      root = buildTree(0, rows - 1, 0, cols - 1);
    }
  }

  public void update(int row, int col, int val) {
    update(root, row, col, val - matrix[row][col]);
    matrix[row][col] = val;
  }

  private void update(final Node root, final int row, final int col, final int diff) {
    if (root == null || row < root.row1 || row > root.row2 || col < root.col1 || col > root.col2) return;
    root.sum += diff;
    update(root.topLeft, row, col, diff);
    update(root.topRight, row, col, diff);
    update(root.bottomLeft, row, col, diff);
    update(root.bottomRight, row, col, diff);
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
    root.sum = (root.topLeft == null ? 0 : root.topLeft.sum)
        + (root.topRight == null ? 0 : root.topRight.sum)
        + (root.bottomLeft == null ? 0 : root.bottomLeft.sum)
        + (root.bottomRight == null ? 0 : root.bottomRight.sum);
    return root;
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return sumRegion(root, row1, col1, row2, col2);
  }

  private int sumRegion(final Node root, final int startRow, final int startCol, final int endRow, final int endCol) {
    if (root == null) return 0;
    if (startRow <= root.row1 && root.row2 <= endRow && startCol <= root.col1 && root.col2 <= endCol) return root.sum;
    return sumRegion(root.topLeft, startRow, startCol, endRow, endCol)
        + sumRegion(root.topRight, startRow, startCol, endRow, endCol)
        + sumRegion(root.bottomLeft, startRow, startCol, endRow, endCol)
        + sumRegion(root.bottomRight, startRow, startCol, endRow, endCol);
  }

  private static final class Node {
    private int sum = 0;
    private final int row1, row2, col1, col2;
    private Node topLeft, topRight, bottomLeft, bottomRight;

    private Node(int row1, int row2, int col1, int col2) {
      this.row1 = row1;
      this.row2 = row2;
      this.col1 = col1;
      this.col2 = col2;
    }
  }
}
