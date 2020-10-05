package _0101_0150._102_Binary_Tree_Level_Order_Traversal;

import definition.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 6/14/2017.
 */
public class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    queue.offer(root);
    queue.offer(null);
    List<Integer> curLevelNodes = new ArrayList<>();
    while (true) {
      TreeNode curNode = queue.poll();
      if (curNode == null) {
        result.add(new ArrayList<>(curLevelNodes));
        curLevelNodes.clear();
        if (queue.isEmpty()) break;
        else queue.offer(null);
      } else {
        curLevelNodes.add(curNode.val);
        if (curNode.left != null) {
          queue.offer(curNode.left);
        }
        if (curNode.right != null) {
          queue.offer(curNode.right);
        }
      }
    }
    return result;
  }
}
