package _0651_0700._671_Second_Minimum_Node_In_a_Binary_Tree;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public class Solution {
  public int findSecondMinimumValue(TreeNode root) {
    if (root == null) {
      return -1;
    }
    int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      final int size = queue.size();
      for (int i = 0; i < size; ++i) {
        TreeNode curNode = queue.poll();
        if (curNode.val < first) {
          second = first;
          first = curNode.val;
        } else if (curNode.val > first && curNode.val < second) {
          second = curNode.val;
        }
        if (curNode.val > first) {
          continue;
        }
        if (curNode.left != null) {
          queue.add(curNode.left);
        }
        if (curNode.right != null) {
          queue.add(curNode.right);
        }
      }
    }

    return second == Integer.MAX_VALUE ? -1 : second;
  }
}
