package interviews.hulu._230_Kth_Smallest_Element_in_a_BST;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 12/17/2019
 */
public final class NonCacheVersion implements Solution {
  @Override
  public int kthSmallest(TreeNode root, int k) {
    if (root == null) {
      return 0;
    }
    final int leftCount = getCount(root.left);
    if (leftCount + 1 == k) {
      return root.val;
    } else if (leftCount + 1 < k) {
      return kthSmallest(root.right, k - leftCount - 1);
    } else {
      return kthSmallest(root.left, k);
    }
  }

  private int getCount(final TreeNode root) {
    if (root == null) {
      return 0;
    }
    final int left = getCount(root.left), right = getCount(root.right);
    return 1 + left + right;
  }
}
