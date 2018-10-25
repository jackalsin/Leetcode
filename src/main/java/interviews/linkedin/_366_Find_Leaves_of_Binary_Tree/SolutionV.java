package interviews.linkedin._366_Find_Leaves_of_Binary_Tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SolutionV implements Solution {
  @Override
  public List<List<Integer>> findLeaves(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();
    findLeaves(result, root);
    return result;
  }

  private static int findLeaves(final List<List<Integer>> result, TreeNode root) {
    if (root == null) {
      return -1;
    }
    final int left = findLeaves(result, root.left), right = findLeaves(result, root.right), depth = Math.max(left,
        right) + 1;
    if (depth == result.size()) {
      result.add(new ArrayList<>());
    }
    result.get(depth).add(root.val);
    return depth;
  }
}
