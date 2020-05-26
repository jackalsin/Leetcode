package interviews.byteDance._094_Binary_Tree_Inorder_Traversal;

import utils.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhixi
 * @version 1.0 on 5/7/2020
 */
public final class MorrisTraversalSolution implements Solution {
  @Override
  public List<Integer> inorderTraversal(TreeNode root) {
    final List<Integer> result = new ArrayList<>();
    while (root != null) {
      if (root.left != null) {
        TreeNode rightMostNode = root.left;
        while (rightMostNode.right != root && rightMostNode.right != null) {
          rightMostNode = rightMostNode.right;
        }
        if (rightMostNode.right == root) {
          result.add(root.val);
          rightMostNode.right = null;
          root = root.right;
        } else {
          rightMostNode.right = root;
          root = root.left;
        }
      } else {
        result.add(root.val);
        root = root.right;
      }
    }
    return result;
  }
}
