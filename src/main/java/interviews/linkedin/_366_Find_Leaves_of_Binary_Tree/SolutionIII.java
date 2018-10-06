package interviews.linkedin._366_Find_Leaves_of_Binary_Tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionIII implements Solution {

  @Override
  public List<List<Integer>> findLeaves(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();
    dfs(result, root);
    return result;
  }

  private static int dfs(List<List<Integer>> result, TreeNode root) {
    if (root == null) {
      return -1;
    }
    int leftDepth = dfs(result, root.left), rightDepth = dfs(result, root.right), index = Math.max(leftDepth, rightDepth) + 1;
    if (result.size() <= index) {
      result.add(new ArrayList<>());
    }
    result.get(index).add(root.val);

    return index;
  }
}
