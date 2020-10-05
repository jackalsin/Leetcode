package pinterest.binarySearchTreeRemoveOutRange;

import definition.binaryTree.TreeNode;

/**
 * 给定一个binary search tree，再给定int max，int  min，构成一个range [min, max]，把bst里面在range外的枝减掉，最后返回新的root。
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=321858&extra=page%3D1%26filter%3Dsortid%26sortid%3D192%26searchoption%5B3046%5D%5Bvalue%5D%3D33%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D192
 */
public class Solution {

  public TreeNode removeRange(final TreeNode root, final int min, final int max) {
    if (root == null) {
      return null;
    } else if (root.val == min) {
      root.left = null;
      return root;
    } else if (root.val < min) {
      return removeRange(root.right, min, max);
    } else if (root.val == max) {
      root.right = null;
      return root;
    } else if (root.val > max) {
      return removeRange(root.left, min, max);
    } else {
      root.left = removeRange(root.left, min, max);
      root.right = removeRange(root.right, min, max);
      return root;
    }
  }
}
