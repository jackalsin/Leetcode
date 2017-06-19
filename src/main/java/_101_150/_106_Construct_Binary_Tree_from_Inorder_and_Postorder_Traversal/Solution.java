package _101_150._106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import java.util.Arrays;
import java.util.NoSuchElementException;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 6/16/2017.
 */
public class Solution {
  private int postIndex = 0;
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    postIndex = postorder.length - 1;
    return getTree(inorder, postorder, 0, postorder.length - 1);
  }

  private TreeNode getTree(int[] inorder, int[] postorder, int inStart, int inEnd) {
    if (inStart > inEnd) return null;
    int rootVal = postorder[postIndex--];
    TreeNode root = new TreeNode(rootVal);
    int rootIndex = indexOf(inorder, rootVal);
    root.right = getTree(inorder, postorder, rootIndex + 1, inEnd);
    root.left = getTree(inorder, postorder, inStart, rootIndex - 1);
    return root;
  }

  private static int indexOf(int[] array, int target) {
    assert array != null;
    for (int i = 0; i < array.length; i++) {
      if (target == array[i]) {
        return i;
      }
    }
    throw new NoSuchElementException("No " + target + " in array: " + Arrays.toString(array));
  }
}
