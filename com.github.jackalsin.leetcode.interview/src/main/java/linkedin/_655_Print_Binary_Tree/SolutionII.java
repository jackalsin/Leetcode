package linkedin._655_Print_Binary_Tree;

import utils.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/12/2019
 */
public final class SolutionII implements Solution {
  @Override
  public List<List<String>> printTree(TreeNode root) {
    final List<List<String>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    final int depth = getDepth(root), size = (1 << depth) - 1;
    for (int i = 0; i < depth; ++i) {
      final List<String> curLine = new ArrayList<>();
      result.add(curLine);
      for (int j = 0; j < size; ++j) {
        curLine.add("");
      }
    }
    bfs(result, root, 0, 0, size - 1);
    return result;
  }

  private static void bfs(final List<List<String>> result, final TreeNode root,
                          final int depth, final int left, final int right) {
    if (root == null) {
      return;
    }
    final List<String> curLine = result.get(depth);
    final int mid = left + (right - left) / 2;
    curLine.set(mid, String.valueOf(root.val));
    bfs(result, root.left, depth + 1, left, mid - 1);
    bfs(result, root.right, depth + 1, mid + 1, right);
  }

  private static int getDepth(final TreeNode root) {
    if (root == null) {
      return 0;
    }
    final int left = getDepth(root.left), right = getDepth(root.right);
    return 1 + Math.max(left, right);
  }
}
