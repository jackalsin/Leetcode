package linkedin._515_Find_Largest_Value_in_Each_Tree_Row;

import utils.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/15/2019
 */
public final class SolutionII implements Solution {
  @Override
  public List<Integer> largestValues(TreeNode root) {
    final List<Integer> result = new ArrayList<>();
    dfs(result, 0, root);
    return result;
  }

  private static void dfs(final List<Integer> result, final int depth, final TreeNode root) {
    if (root == null) {
      return;
    }
    if (depth == result.size()) {
      result.add(root.val);
    }
    result.set(depth, Math.max(result.get(depth), root.val));
    dfs(result, depth + 1, root.left);
    dfs(result, depth + 1, root.right);
  }
}
