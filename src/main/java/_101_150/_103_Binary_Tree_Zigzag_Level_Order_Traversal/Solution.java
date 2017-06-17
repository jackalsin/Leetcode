package _101_150._103_Binary_Tree_Zigzag_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.TreeNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/16/2017.
 */
public class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    if (root == null) {
      return result;
    }
    queue.offer(root);
    List<Integer> curLevelNodes = new ArrayList<>();
    boolean isInorder = false;
    while (!queue.isEmpty()) {
      isInorder = !isInorder;
      int curLevelSize = queue.size();
      for (int i = 0; i < curLevelSize; i++) {
        TreeNode curNode = queue.poll();
        curLevelNodes.add(curNode.val);
        if (curNode.left != null) {
          queue.offer(curNode.left);
        }
        if (curNode.right != null) {
          queue.offer(curNode.right);
        }
      }
      if (!isInorder) {
        Collections.reverse(curLevelNodes);
      }
      result.add(new ArrayList<>(curLevelNodes));
      curLevelNodes.clear();
    }
    return result;
  }
}
