package hulu._105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import definition.binaryTree.TreeNode;

import java.util.Arrays;

public final class SolutionI implements Solution {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
  }

  private static TreeNode buildTree(final int[] preorder, final int[] inorder, final int preorderIndex,
                                    final int inorderLeft, final int inorderRight) {
    if (inorderLeft > inorderRight) {
      return null;
    }
    final int rootVal = preorder[preorderIndex];
    final TreeNode root = new TreeNode(rootVal);
    final int rootValInorderIndex = getIndex(inorderLeft, inorderRight, rootVal, inorder);
    root.left = buildTree(preorder, inorder, preorderIndex + 1, inorderLeft, rootValInorderIndex - 1);
    root.right = buildTree(preorder, inorder, preorderIndex + (rootValInorderIndex - 1 - inorderLeft + 1) + 1,
        rootValInorderIndex + 1, inorderRight);
    return root;
  }

  private static int getIndex(final int start, final int end, final int val, final int[] inorder) {
    for (int i = start; i <= end; i++) {
      if (inorder[i] == val) return i;
    }
    throw new IllegalArgumentException("inorder = " + Arrays.toString(inorder) + " in [" + start + ", " + end + "] " +
        "val = " + val + " cannot be found. ");
  }
}
