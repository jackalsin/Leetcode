package linkedin._103_Binary_Tree_Zigzag_Level_Order_Traversal;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 10/20/2017.
 */
public final class SolutionI implements Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    boolean isInOrder = false;
    while (!queue.isEmpty()) {
      isInOrder = !isInOrder;
      final int size = queue.size();
      List<Integer> curLine = new ArrayList<>();
      for (int i = 0; i < size; ++i) {
        TreeNode curNode = queue.poll();
        curLine.add(curNode.val);
        if (curNode.left != null) {
          queue.add(curNode.left);
        }
        if (curNode.right != null) {
          queue.add(curNode.right);
        }
      }
      if (!isInOrder) {
        Collections.reverse(curLine);
      }
      result.add(curLine);
    }
    return result;
  }
}
