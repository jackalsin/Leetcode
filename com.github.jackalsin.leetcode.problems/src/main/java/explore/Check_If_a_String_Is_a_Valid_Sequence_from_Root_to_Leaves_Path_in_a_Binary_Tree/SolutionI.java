package explore.Check_If_a_String_Is_a_Valid_Sequence_from_Root_to_Leaves_Path_in_a_Binary_Tree;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 4/30/2020
 */
public final class SolutionI implements Solution {
  public boolean isValidSequence(TreeNode root, int[] arr) {
    if (arr == null || arr.length == 0) {
      return root == null;
    }
    return isValidSequence(root, arr, 0);
  }

  private static boolean isValidSequence(final TreeNode root, final int[] arr, final int i) {
    if (root == null) {
      return false;
    }
    if (root.val != arr[i]) {
      return false;
    }
    if (i == arr.length - 1) {
      return root.left == null && root.right == null;
    }
    return isValidSequence(root.left, arr, i + 1) || isValidSequence(root.right, arr, i + 1);
  }
}
