package interviews.microsoft._098_Validate_Binary_Search_Tree;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

  public boolean isValidBST(TreeNode root) {
    final Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode prev = null;
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        if (prev != null && prev.val >= root.val) {
          return false;
        }
        prev = root;
        root = root.right;
      }
    }
    return true;
  }

}
