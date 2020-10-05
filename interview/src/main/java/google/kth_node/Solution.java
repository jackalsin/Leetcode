package google.kth_node;

/**
 * @author jacka
 * @version 1.0 on 1/22/2018.
 */
public class Solution {

  public int kthNode(TreeNode root, int k) {
    assert k - 1 <= root.count;
    return traverse(root, k);
  }

  private int traverse(TreeNode root, int k) {
    assert root != null;
    if (root.left == null && root.right == null) {
      if (k == 1) {
        return root.val;
      } else {
        throw new IllegalStateException("Not enough node for k = " + k + "in Node = " + root);
      }
    } else {
      int leftCount = root.left == null ? 0 : root.left.count + 1;
      if (leftCount > k - 1) {
        return traverse(root.left, k);
      } else if (leftCount == k - 1) {
        return root.val;
      } else {
        return traverse(root.right, k - 1 - leftCount);
      }
    }
  }

  public static final class TreeNode {
    public final int val;
    TreeNode left, right;
    int count = 0;

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, int count) {
      this.val = val;
      this.count = count;
    }

    @Override
    public String toString() {
      return "TreeNode{" +
          "val=" + val +
          ", left.val=" + (left == null ? null : left.val) +
          ", right.val=" + (right == null ? null : right.val) +
          ", count=" + count +
          '}';
    }
  }
}
