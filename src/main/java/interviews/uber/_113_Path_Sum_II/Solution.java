package interviews.uber._113_Path_Sum_II;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    final List<List<Integer>> result = new ArrayList<>();
    pathSum(result, root, new ArrayList<>(), sum);
    return result;
  }

  private void pathSum(List<List<Integer>> result, TreeNode root, List<Integer> curPath, int sum) {
    if (root == null) {
      return;
    }
    curPath.add(root.val);
    if (root.left == null && root.right == null) {
      if (root.val == sum) {
        result.add(new ArrayList<>(curPath));
      }
    } else {
      pathSum(result, root.left, curPath, sum - root.val);
      pathSum(result, root.right, curPath, sum - root.val);
    }
    curPath.remove(curPath.size() - 1);
  }
}
