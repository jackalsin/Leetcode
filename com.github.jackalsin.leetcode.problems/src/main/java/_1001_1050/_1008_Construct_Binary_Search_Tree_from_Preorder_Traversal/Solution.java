package _1001_1050._1008_Construct_Binary_Search_Tree_from_Preorder_Traversal;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 3/9/2019.
 */
public class Solution {
  private int i = 0;

  public TreeNode bstFromPreorder(int[] preorder) {
    return bstFromPreorder(preorder, Integer.MAX_VALUE);
  }

  private TreeNode bstFromPreorder(final int[] preorder, final int boundary) {
    if (i == preorder.length || preorder[i] > boundary) {
      return null;
    }
    final int rootVal = preorder[i++];
    TreeNode root = new TreeNode(rootVal);
    root.left = bstFromPreorder(preorder, rootVal);
    root.right = bstFromPreorder(preorder, boundary);
    return root;
  }
}
