package oracle._230_Kth_Smallest_Element_in_a_BST;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 11/9/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int kthSmallest(TreeNode root, int k) {
    final Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        if (k == 1) {
          return root.val;
        }
        k--;
        root = root.right;
      }
    }
    throw new IllegalStateException();
  }
}
