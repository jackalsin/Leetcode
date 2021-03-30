package byteDance._113_Path_Sum_II;

import definition.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/29/2021
 */
public final class SolutionI implements Solution {
  private final List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    final List<Integer> curPath = new ArrayList<>();
    pathSum(root, targetSum, curPath);
    return result;
  }

  private void pathSum(final TreeNode root, final int targetSum, final List<Integer> curPath) {
    if (root == null) {
      return;
    }

    curPath.add(root.val);
    if (root.left == null && root.right == null) {
      if (targetSum == root.val) {
        result.add(new ArrayList<>(curPath));
        curPath.remove(curPath.size() - 1);
        return;
      }
    }

    if (root.left != null) {
      pathSum(root.left, targetSum - root.val, curPath);
    }
    if (root.right != null) {
      pathSum(root.right, targetSum - root.val, curPath);
    }

    curPath.remove(curPath.size() - 1);
  }
}
