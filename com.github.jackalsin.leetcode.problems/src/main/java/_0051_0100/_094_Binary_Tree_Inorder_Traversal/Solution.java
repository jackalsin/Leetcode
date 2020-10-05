package _0051_0100._094_Binary_Tree_Inorder_Traversal;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 5/31/2017.
 */
public class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
//    return recursive(root);
    return iterative(root);
  }

  private List<Integer> iterative(TreeNode root) {
    Deque<TreeNode> parentStack = new ArrayDeque<>();
    List<Integer> result = new ArrayList<>();
    while (!parentStack.isEmpty() || root != null) {
      if (root != null) {
        parentStack.addLast(root);
        root = root.left;
      } else {
        root = parentStack.removeLast();
        result.add(root.val);
        root = root.right;
      }
    }
    return result;
  }

  /**
   * Recursively traverse root.
   *
   * @param root
   * @return
   */
  private List<Integer> recursive(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    recursive(result, root);
    return result;
  }

  private void recursive(List<Integer> result, TreeNode root) {
    if (root.left != null) recursive(result, root.left);
    result.add(root.val);
    if (root.right != null) recursive(result, root.right);
  }
}
