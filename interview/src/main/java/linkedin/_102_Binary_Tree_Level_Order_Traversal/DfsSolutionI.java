package linkedin._102_Binary_Tree_Level_Order_Traversal;

import definition.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/25/2019
 */
public final class DfsSolutionI implements Solution {
  @Override
  public List<List<Integer>> levelOrder(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();
    dfs(result, root, 0);
    return result;
  }

  private static void dfs(final List<List<Integer>> result, final TreeNode root, final int i) {
    if (root == null) {
      return;
    }
    if (i == result.size()) {
      result.add(new ArrayList<>());
    }
    result.get(i).add(root.val);
    dfs(result, root.left, i + 1);
    dfs(result, root.right, i + 1);
  }
}
