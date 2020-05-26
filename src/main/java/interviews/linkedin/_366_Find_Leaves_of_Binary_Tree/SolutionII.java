package interviews.linkedin._366_Find_Leaves_of_Binary_Tree;

import utils.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionII implements Solution {

  /**
   *
   * @param root
   * @return
   */
  public List<List<Integer>> findLeaves(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();
    findLeaves(root, result);
    return result;
  }

  /**
   * Return the height of the current root, null is the <tt>-1</tt>;
   *
   * @param root
   * @param result
   * @return
   */
  private static int findLeaves(TreeNode root, List<List<Integer>> result) {
    if (root == null) {
      return -1;
    }

    final int height = 1 + Math.max(findLeaves(root.left, result), findLeaves(root.right, result));
    if (result.size() <= height) {
      result.add(new ArrayList<>());
    }
    result.get(height).add(root.val);
    return height;
  }

}
