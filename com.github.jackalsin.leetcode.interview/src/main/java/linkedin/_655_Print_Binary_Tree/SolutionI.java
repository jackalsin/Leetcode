package linkedin._655_Print_Binary_Tree;

import definition.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/25/2019
 */
public final class SolutionI implements Solution {
  public List<List<String>> printTree(TreeNode root) {
    final List<List<String>> result = new ArrayList<>();
    if (root == null) {
      return null;
    }
    final int depth = getDepth(root);

    // init the list
    for (int d = 0; d < depth; d++) {
      final List<String> curLine = new ArrayList<>();
      for (int i = 0; i < (1 << depth) - 1; i++) {
        curLine.add("");
      }
      result.add(curLine);
    }
    bfs(result, root, 0, (1 << depth) - 2, 0);
    return result;
  }

  private static void bfs(final List<List<String>> result, final TreeNode root, final int left, int right, int depth) {
    if (root == null) {
      return;
    }
    assert left <= right;
    final List<String> curLine = result.get(depth);
    final int mid = left + (right - left) / 2;
    curLine.set(mid, String.valueOf(root.val));
    bfs(result, root.left, left, mid - 1, depth + 1);
    bfs(result, root.right, mid + 1, right, depth + 1);
  }

  private static int getDepth(final TreeNode root) {
    if (root == null) {
      return 0;
    }
    final int left = getDepth(root.left), right = getDepth(root.right);
    return Math.max(left, right) + 1;
  }
}
