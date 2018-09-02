package _851_900._897_Increasing_Order_Search_Tree;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public TreeNode increasingBST(TreeNode root) {
    final TreeNode dummy = new TreeNode(1);
    TreeNode cur = dummy;
    final Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        cur.right = new TreeNode(root.val);
        cur = cur.right;
        root = root.right;
      }
    }
    return dummy.right;
  }
}
