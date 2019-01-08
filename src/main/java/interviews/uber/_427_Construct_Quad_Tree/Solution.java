package interviews.uber._427_Construct_Quad_Tree;

import utils._427_Construct_Quad_Tree.Node;

public class Solution {
  public Node construct(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return null;
    }

    return construct(grid, 0, grid.length - 1, 0, grid.length - 1);
  }

  private Node construct(int[][] grid, int startRow, int endRow, int startCol, int endCol) {
    final Node root = new Node();
    if (startRow == endRow && startCol == endCol) {
      root.val = grid[startRow][startCol] == 1;
      root.isLeaf = true;
      return root;
    }
    final int midRow = startRow + (endRow - startRow) / 2, midCol = startCol + (endCol - startCol) / 2;
    final Node leftTop = construct(grid, startRow, midRow, startCol, midCol),
        rightTop = construct(grid, startRow, midRow, midCol + 1, endCol),
        leftBottom = construct(grid, midRow + 1, endRow, startCol, midCol),
        rightBottom = construct(grid, midRow + 1, endRow, midCol + 1, endCol);
    root.isLeaf = leftTop.isLeaf && rightTop.isLeaf && leftBottom.isLeaf && rightBottom.isLeaf
        && (leftTop.val == rightTop.val && rightTop.val == leftBottom.val && leftBottom.val == rightBottom.val);
    root.val = root.isLeaf && leftTop.val;
    if (!root.isLeaf) {
      root.topLeft = leftTop;
      root.topRight = rightTop;
      root.bottomLeft = leftBottom;
      root.bottomRight = rightBottom;
    }
    return root;
  }
}
