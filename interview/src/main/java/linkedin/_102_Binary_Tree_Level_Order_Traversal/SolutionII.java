package linkedin._102_Binary_Tree_Level_Order_Traversal;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 10/19/2017.
 */
public final class SolutionII implements Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();
    final Queue<TreeNode> queue = new ArrayDeque<>();
    if (root == null) {
      return result;
    }
    queue.add(root);

    while (!queue.isEmpty()) {
      final int size = queue.size();
      final List<Integer> curLine = new ArrayList<>();
      result.add(curLine);

      for (int i = 0; i < size; i++) {
        final TreeNode toRemove = queue.remove();
        curLine.add(toRemove.val);
        if (toRemove.left != null) {
          queue.add(toRemove.left);
        }
        if (toRemove.right != null) {
          queue.add(toRemove.right);
        }
      } // end of for loop
    }
    return result;
  }
}
