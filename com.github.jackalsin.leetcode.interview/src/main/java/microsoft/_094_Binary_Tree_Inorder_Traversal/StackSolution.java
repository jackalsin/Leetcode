package microsoft._094_Binary_Tree_Inorder_Traversal;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public final class StackSolution implements Solution {

  public List<Integer> inorderTraversal(TreeNode root) {
    final List<Integer> result = new ArrayList<>();
    final Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        result.add(root.val);
        root = root.right;
      }
    }
    return result;
  }

}
