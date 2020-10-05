package linkedin._366_Find_Leaves_of_Binary_Tree;

import utils.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/20/2019
 */
public final class SolutionVI implements Solution {

  public List<List<Integer>> findLeaves(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();
    findLeaves(root, result);
    return result;
  }

  private static int findLeaves(final TreeNode root, final List<List<Integer>> result) {
    if (root == null) {
      return -1;
    }

    final int leftDepth = findLeaves(root.left, result),
        rightDepth = findLeaves(root.right, result),
        depth = Math.max(leftDepth, rightDepth) + 1;
    if (depth == result.size()) {
      result.add(new ArrayList<>());
    }
    result.get(depth).add(root.val);
    return depth;
  }
}
