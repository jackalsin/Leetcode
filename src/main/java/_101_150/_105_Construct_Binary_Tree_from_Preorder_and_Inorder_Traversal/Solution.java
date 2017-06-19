package _101_150._105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import java.util.Arrays;
import java.util.NoSuchElementException;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 6/16/2017.
 */
public class Solution {
  private int preIndex = 0;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTree(preorder,inorder, 0, preorder.length - 1);
  }

  private TreeNode buildTree(int[] preorder, int[] inorder, int inStart, int inEnd) {
    if (inEnd < inStart) return null;
    int rootVal = preorder[preIndex++];
    TreeNode root = new TreeNode(rootVal);
    int rootIndex = indexOf(inorder, rootVal);
    root.left = buildTree(preorder, inorder, inStart, rootIndex - 1);
    root.right = buildTree(preorder, inorder, rootIndex + 1, inEnd);
    return root;
  }

  /**
   * Get target's index from array
   * @param array
   * @param target
   * @return
   */
  private static int indexOf(int[] array, int target) {
    assert array != null;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == target) {
        return i;
      }
    }
    throw new NoSuchElementException("No " + target + " in array: " + Arrays.toString(array));
  }
}
