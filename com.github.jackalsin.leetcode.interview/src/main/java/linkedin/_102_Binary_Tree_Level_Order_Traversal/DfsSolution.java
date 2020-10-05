package linkedin._102_Binary_Tree_Level_Order_Traversal;

import utils.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 6/30/2019
 */
public final class DfsSolution implements Solution {
  @Override
  public List<List<Integer>> levelOrder(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();
    dfs(result, root, 0);
    return result;
  }

  private static void dfs(final List<List<Integer>> result, final TreeNode root, final int depth) {
    if (root == null) {
      return;
    }
    if (depth == result.size()) {
      result.add(new ArrayList<>());
    }
    result.get(depth).add(root.val);
    dfs(result, root.left, depth + 1);
    dfs(result, root.right, depth + 1);
  }
}
