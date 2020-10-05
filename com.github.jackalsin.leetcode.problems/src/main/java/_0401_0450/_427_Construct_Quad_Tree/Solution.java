package _0401_0450._427_Construct_Quad_Tree;

import definition._427_Construct_Quad_Tree.Node;

public final class Solution {

  public Node construct(int[][] grid) {
    final int n = grid.length;
    return construct(grid, n / 2, (n - 1), (n - 1));
  }

  private static Node construct(final int[][] grid, final int size, final int row, final int col) {
    if (size == 0) {
      return new Node(grid[row][col] == 1, true,
          null, null, null, null);
    }
    final Node topLeft = construct(grid, size / 2, row - size, col - size),
        topRight = construct(grid, size / 2, row - size, col),
        bottomLeft = construct(grid, size / 2, row, col - size),
        bottomRight = construct(grid, size / 2, row, col);
    final boolean val = topLeft.val && topRight.val && bottomLeft.val && bottomRight.val,
        isLeaf = (topLeft.val == topRight.val) && (topLeft.val == bottomLeft.val) && (topLeft.val == bottomRight.val)
            && topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf;
    return new Node(val, isLeaf,
        isLeaf ? null : topLeft,
        isLeaf ? null : topRight,
        isLeaf ? null : bottomLeft,
        isLeaf ? null : bottomRight);
  }

}
