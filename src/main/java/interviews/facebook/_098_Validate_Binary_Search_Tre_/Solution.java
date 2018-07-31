package interviews.facebook._098_Validate_Binary_Search_Tre_;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

  public boolean isValidBST(TreeNode root) {
    TreeNode prevNode = null;
    final Deque<TreeNode> stack = new ArrayDeque<>();

    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        if (prevNode != null && prevNode.val >= root.val) {
          return false;
        }
        prevNode = root;
        root = root.right;
      }
    }
    return true;
  }

}
