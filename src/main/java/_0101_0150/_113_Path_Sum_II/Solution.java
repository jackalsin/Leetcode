package _0101_0150._113_Path_Sum_II;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 6/22/2017.
 */
public class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    if (root == null) return new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    pathSum(root, sum, new ArrayList<>(), result);
    return result;
  }

  private static void pathSum(TreeNode root, int remainingSum, List<Integer> curPath,
                              List<List<Integer>> result) {
    if (root == null) return;
    if (root.left == null && root.right == null) {
      if (remainingSum == root.val) {
        curPath.add(root.val);
        result.add(new ArrayList<>(curPath));
        curPath.remove(curPath.size() - 1);
      }
    } else {
      curPath.add(root.val);
      pathSum(root.left, remainingSum - root.val, curPath, result);
      pathSum(root.right, remainingSum - root.val, curPath, result);
      curPath.remove(curPath.size() - 1);
    }
  }
}
