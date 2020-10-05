package microsoft.noodleEssence._230_Kth_Smallest_Element_in_a_BST;

import utils.binaryTree.TreeNode;

public class Solution {
  public int kthSmallest(TreeNode root, int k) {
    int leftCount = count(root.left);
    if (k == leftCount + 1) {
      return root.val;
    } else if (k < leftCount + 1) {
      return kthSmallest(root.left, k);
    } else {
      return kthSmallest(root.right, k - leftCount - 1);
    }
  }

  private static int count(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + count(root.left) + count(root.right);
  }
}
