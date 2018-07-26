package _851_900._865_Smallest_Subtree_with_all_the_Deepest_Node;

import utils.TreeNode;

public class Solution {

  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    return depth(root, 0).root;
  }

  private Node depth(final TreeNode root, final int depth) {
    if (root == null) {
      return new Node(null, depth);
    }

    final Node leftNode = depth(root.left, depth + 1),
        rightNode = depth(root.right, depth + 1);
    if (leftNode.depth == rightNode.depth) {
      return new Node(root, leftNode.depth + 1);
    } else if (leftNode.depth > rightNode.depth) {
      return new Node(leftNode.root, leftNode.depth + 1);
    } else {
      return new Node(rightNode.root, rightNode.depth + 1);
    }

  }

  private static final class Node {
    private final TreeNode root;
    private final int depth;

    public Node(TreeNode root, int depth) {
      this.root = root;
      this.depth = depth;
    }
  }
}
