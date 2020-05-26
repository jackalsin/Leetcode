package interviews.linkedin._113_Path_Sum_II;

import utils.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 6/30/2019
 */
public final class SolutionI implements Solution {
  @Override
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    final List<List<Integer>> result = new ArrayList<>();
    pathSum(result, root, sum, new ArrayList<>());
    return result;
  }

  private static void pathSum(final List<List<Integer>> result, final TreeNode root, final int remain, final List<Integer> curPath) {
    if (root == null) {
      return;
    }
    curPath.add(root.val);
    if (root.left == null && root.right == null && remain - root.val == 0) {
      result.add(new ArrayList<>(curPath));
    }
    if (root.left != null) {
      pathSum(result, root.left, remain - root.val, curPath);
    }

    if (root.right != null) {
      pathSum(result, root.right, remain - root.val, curPath);
    }
    curPath.remove(curPath.size() - 1);
  }
}
