package uber._655_Print_Binary_Tree;

import definition.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<String>> printTree(TreeNode root) {
    final int depth = getDepth(root), width = (1 << depth) - 1;
    final List<List<String>> result = new ArrayList<>();
    for (int row = 0; row < depth; row++) {
      final List<String> curRow = new ArrayList<>();
      for (int col = 0; col < width; col++) {
        curRow.add("");
      }
      result.add(curRow);
    }

    dfs(result, root, 0, width - 1, 0);
    return result;
  }

  private static void dfs(final List<List<String>> result, TreeNode root, int left, int right, int depth) {
    if (root == null) {
      return;
    }
    final List<String> row = result.get(depth);
    final int mid = left + (right - left) / 2;
    row.set(mid, String.valueOf(root.val));
    dfs(result, root.left, left, mid - 1, depth + 1);
    dfs(result, root.right, mid + 1, right, depth + 1);
  }

  private static int getDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(getDepth(root.left), getDepth(root.right));
  }
}
