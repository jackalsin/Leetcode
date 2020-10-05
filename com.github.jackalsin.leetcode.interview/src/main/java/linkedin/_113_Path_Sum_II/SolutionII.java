package linkedin._113_Path_Sum_II;

import utils.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/25/2019
 */
public final class SolutionII implements Solution {
  @Override
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    final List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    pathSum(result, new ArrayList<>(), root, sum);
    return result;
  }

  private static void pathSum(final List<List<Integer>> result,
                              final List<Integer> curPath, final TreeNode root,
                              final int sum) {
    if (root == null) {
      return;
    }
    curPath.add(root.val);
    if (root.left == null && root.right == null) {
      if (sum == root.val) {
        result.add(new ArrayList<>(curPath));
      }
    }
    pathSum(result, curPath, root.left, sum - root.val);
    pathSum(result, curPath, root.right, sum - root.val);
    curPath.remove(curPath.size() - 1);
  }
}
