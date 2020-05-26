package interviews.microsoft._094_Binary_Tree_Inorder_Traversal;

import utils.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public final class MorrisTraversalSolution implements Solution {

  public List<Integer> inorderTraversal(TreeNode root) {
    final List<Integer> result = new ArrayList<>();
    TreeNode curNode = root;

    while (curNode != null) {

      if (curNode.left == null) {
        result.add(curNode.val);
        curNode = curNode.right;
      } else {
        TreeNode rightMostNode = curNode.left;
        while (rightMostNode.right != null && rightMostNode.right != curNode) {
          rightMostNode = rightMostNode.right;
        }
        if (rightMostNode.right == null) {
          rightMostNode.right = curNode;
          curNode = curNode.left;
        } else { // 这是退回来的时候
          rightMostNode.right = null;
          result.add(curNode.val);
          curNode = curNode.right;
        }
      }

    }
    return result;
  }

}
