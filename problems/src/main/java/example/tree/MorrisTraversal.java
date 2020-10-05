package example.tree;

import definition.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public final class MorrisTraversal implements Traversal {

  @Override
  public List<Integer> traverse(TreeNode root) {
    final List<Integer> result = new ArrayList<>();
    TreeNode cur = root;
    while (cur != null) {
      if (cur.left == null) {
        result.add(cur.val);
        cur = cur.right;
      } else {
        TreeNode rightMostNode = cur.left;
        while (rightMostNode.right != null && rightMostNode.right != cur) {
          rightMostNode = rightMostNode.right;
        }
        if (rightMostNode.right == cur) {
          result.add(cur.val);
          rightMostNode.right = null;
          cur = cur.right;
        } else {
          rightMostNode.right = cur;
          cur = cur.left;
        }
      }
    }
    return result;
  }
}
