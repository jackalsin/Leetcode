package _0501_0550._513_Find_Bottom_Left_Tree_Value;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 10/29/2017.
 */
public class Solution {
  public int findBottomLeftValue(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    int result = 0;
    while (!queue.isEmpty()) {
      final int size = queue.size();
      result = queue.peek().val;
      for (int i = 0; i < size; i++) {
        final TreeNode curNode = queue.remove();
        if (curNode.left != null) {
          queue.add(curNode.left);
        }
        if (curNode.right != null) {
          queue.add(curNode.right);
        }
      }
    }
    return result;
  }

}
