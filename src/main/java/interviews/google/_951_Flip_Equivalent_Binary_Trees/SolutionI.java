package interviews.google._951_Flip_Equivalent_Binary_Trees;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 3/26/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    } else if (root1 == null || root2 == null) {
      return false;
    }
    if (root1.val != root2.val) {
      return false;
    }
    return (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))
        || (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right));
  }
}
