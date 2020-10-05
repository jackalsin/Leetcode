package linkedin._366_Find_Leaves_of_Binary_Tree;

import definition.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionI implements Solution {
  public List<List<Integer>> findLeaves(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();
    helper(root, result);
    return result;
  }

  private int helper(TreeNode root, List<List<Integer>> result) {
    if (root == null) {
      return -1;
    } else {
      int height = 1 + Math.max(helper(root.left, result), helper(root.right, result));
      if (result.size() <= height) {
        result.add(new ArrayList<>());
      }
      result.get(height).add(root.val);
      return height;
    }
  }
}
