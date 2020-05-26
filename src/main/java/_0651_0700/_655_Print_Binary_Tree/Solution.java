package _0651_0700._655_Print_Binary_Tree;

import utils.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<String>> printTree(TreeNode root) {
    final int depth = getDepth(root), cols = (1 << depth) - 1;
    final List<List<String>> res = new ArrayList<>();
    for (int row = 0; row < depth; row++) {
      final List<String> curRow = new ArrayList<>();
      res.add(curRow);
      for (int col = 0; col < cols; col++) {
        curRow.add("");
      }
    }
    printTree(res, root, 0, cols / 2, 1 << (depth - 2));
    return res;
  }

  private static void printTree(final List<List<String>> res, final TreeNode root, final int row, final int col,
                                final int diff) {
    if (root == null) {
      return;
    }
    res.get(row).set(col, String.valueOf(root.val));
    printTree(res, root.left, row + 1, col - diff, diff / 2);
    printTree(res, root.right, row + 1, col + diff, diff / 2);
  }

  private static int getDepth(final TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(getDepth(root.right), getDepth(root.left));
  }
}
