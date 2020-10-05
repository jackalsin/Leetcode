package linkedin._103_Binary_Tree_Zigzag_Level_Order_Traversal;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 10/20/2017.
 */
public final class SolutionII implements Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    boolean isInOrder = false;

    while (!queue.isEmpty()) {
      final int size = queue.size();
      final List<Integer> curLine = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        final TreeNode toRemove = queue.remove();
        curLine.add(toRemove.val);
        if (toRemove.left != null) {
          queue.add(toRemove.left);
        }
        if (toRemove.right != null) {
          queue.add(toRemove.right);
        }
      }

      if (isInOrder) {
        Collections.reverse(curLine);
      }
      isInOrder = !isInOrder;
      result.add(curLine);
    }
    return result;
  }
}
