package _0101_0150._107_Binary_Tree_Level_Order_Traversal_II;

import utils.TreeNode;

import java.util.*;

/**
 * @author jacka
 * @version 1.0 on 6/16/2017.
 */
public class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();
    if (root == null) {
      return result;
    } else {
      queue.offer(root);
    }
    while (!queue.isEmpty()) {
      int curLevelSize = queue.size();
      List<Integer> curLevelNodes = new ArrayList<>();
      for (int i = 0; i < curLevelSize; i++) {
        TreeNode curNode = queue.poll();
        curLevelNodes.add(curNode.val);
        if (curNode.left != null) queue.offer(curNode.left);
        if (curNode.right != null) queue.offer(curNode.right);
      }
      result.add(curLevelNodes);
    }
    Collections.reverse(result);
    return result;
  }
}
