package uber._230_Kth_Smallest_Element_in_a_BST;

import utils.binaryTree.TreeNode;

public class Solution {

  public int kthSmallest(TreeNode root, int k) {
    assert root != null;
    final int leftCount = getCount(root.left);
    if (leftCount == k - 1) {
      return root.val;
    } else if (leftCount < k - 1) {
      return kthSmallest(root.right, k - leftCount - 1);
    } else {
      return kthSmallest(root.left, k);
    }
  }

  private static int getCount(final TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + getCount(root.left) + getCount(root.right);
  }
}
