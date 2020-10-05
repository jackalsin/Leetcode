package _0101_0150._105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import definition.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 6/16/2017.
 */
public final class ONSolution implements Solution {
  private final Map<Integer, Integer> inorderReverseMap = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < inorder.length; ++i) {
      inorderReverseMap.put(inorder[i], i);
    }
    return buildTree(preorder, inorder, 0, 0, preorder.length - 1);
  }

  private TreeNode buildTree(final int[] preorder, final int[] inorder, final int preIndex,
                             final int inStart, final int inEnd) {
    if (inEnd < inStart) return null;
    final int rootVal = preorder[preIndex], inorderIndex = inorderReverseMap.get(rootVal);
    final TreeNode root = new TreeNode(rootVal);
    root.left = buildTree(preorder, inorder, preIndex + 1, inStart, inorderIndex - 1);
    root.right = buildTree(preorder, inorder, preIndex + (inorderIndex - 1 - inStart + 1) + 1, inorderIndex + 1, inEnd);
    return root;
  }
}
