package _0101_0150._111_Minimum_Depth_of_Binary_Tree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 6/21/2017.
 */
public class Solution {

  /**
   * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
   * @param root
   * @return
   */
  public int minDepth(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    if (root == null) return 0;
    queue.offer(root);
    int level = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode curNode = queue.poll();
        if (curNode.left == null && curNode.right == null) {
          return level;
        } else {
          if (curNode.left != null)
            queue.offer(curNode.left);
          if (curNode.right != null)
            queue.offer(curNode.right);
        }
      }
      level++;
    }
    throw new IllegalStateException("No leaf node found in " + root);
  }
}
