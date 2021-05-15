package uber._427_Construct_Quad_Tree;

import definition._427_Construct_Quad_Tree.Node;

/**
 * @author jacka
 * @version 1.0 on 5/15/2021
 */
public final class SolutionII implements Solution {
  @Override
  public Node construct(int[][] grid) {
    if (grid == null || grid.length == 0) return null;
    final int rows = grid.length, cols = grid[0].length;
    return construct(grid, 0, rows - 1, 0, cols - 1);
  }

  private Node construct(final int[][] grid, final int startRow, final int endRow,
                         final int startCol, final int endCol) {
    final Node root = new Node();
    if (startRow == endRow && startCol == endCol) {
      root.isLeaf = true;
      root.val = grid[startRow][startCol] == 1;
      return root;
    }
    final int midRow = startRow + (endRow - startRow) / 2,
        midCol = startCol + (endCol - startCol) / 2;
    root.topLeft = construct(grid, startRow, midRow, startCol, midCol);
    root.topRight = construct(grid, startRow, midRow, midCol + 1, endCol);
    root.bottomLeft = construct(grid, midRow + 1, endRow, startCol, midCol);
    root.bottomRight = construct(grid, midRow + 1, endRow, midCol + 1, endCol);
    root.isLeaf = root.topLeft.isLeaf && root.topRight.isLeaf && root.bottomLeft.isLeaf && root.bottomRight.isLeaf
        && equals(root.topLeft.val, root.topRight.val, root.bottomLeft.val, root.bottomRight.val);
    if (root.isLeaf) {
      root.val = root.topLeft.val;
      root.topLeft = root.topRight = root.bottomLeft = root.bottomRight = null;
    }
    return root;
  }

  private boolean equals(final boolean a, final boolean... b) {
    for (boolean c : b) {
      if (a != c) return false;
    }
    return true;
  }
}
