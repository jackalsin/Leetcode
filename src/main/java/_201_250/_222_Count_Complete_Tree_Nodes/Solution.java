package _201_250._222_Count_Complete_Tree_Nodes;

import java.util.ArrayDeque;
import java.util.Queue;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/15/2017.
 */
public class Solution {
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    int count = 0;
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      count += size;
      for (int i = 0; i < size; ++i) {
        TreeNode cur = queue.poll();
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
    }
    return count;
  }
}
