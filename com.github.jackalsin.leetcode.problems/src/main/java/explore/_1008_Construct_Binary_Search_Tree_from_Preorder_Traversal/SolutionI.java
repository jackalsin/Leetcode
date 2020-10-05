package explore._1008_Construct_Binary_Search_Tree_from_Preorder_Traversal;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 4/20/2020
 */
public final class SolutionI implements Solution {
  private int i = 0;

  public TreeNode bstFromPreorder(int[] preorder) {
    return bstFromPreorder(preorder, Integer.MAX_VALUE);
  }

  private TreeNode bstFromPreorder(final int[] preorder, final int maxValue) {
    if (i >= preorder.length) {
      return null;
    }
    final int rootVal = preorder[i];
    if (rootVal > maxValue) {
      return null;
    }
    i++;
    final TreeNode root = new TreeNode(rootVal);
    root.left = bstFromPreorder(preorder, rootVal);
    root.right = bstFromPreorder(preorder, maxValue);
    return root;
  }
}
