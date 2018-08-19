package interviews.microsoft.noodleEssence._099_Recover_Binary_Search_Tree;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public void recoverTree(TreeNode root) {
    TreeNode prev = null;
    final Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode first = null, second = null;
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        if (prev != null) {
          if (prev.val > root.val) {
            if (first == null) {
              first = prev;
            }
            // second needs to be the last
            second = root;
          }
        } // end if prev != null
        prev = root;
        root = root.right;
      }
    }
    assert first != null && second != null;
    int tmp = first.val;
    first.val = second.val;
    second.val = tmp;
  }
}
