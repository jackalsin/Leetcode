package utils;

import java.util.Objects;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 5/31/2017.
 */
public final class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    val = x;
  }

  @Deprecated
  public TreeNode(TreeNode root) {
    val = root.val;
    if (root.left != null) {
      left = new TreeNode(root.left);
    }
    if (root.right != null) {
      right = new TreeNode(root.right);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TreeNode)) {
      return false;
    }

    TreeNode treeNode = (TreeNode) o;

    return val == treeNode.val && (Objects.equals(left, treeNode.left)) && (Objects.equals(right, treeNode.right));
  }

  @Override
  public int hashCode() {
    int result = val;
    result = 31 * result + (left != null ? left.hashCode() : 0);
    result = 31 * result + (right != null ? right.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "TreeNode{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        '}';
  }
}
