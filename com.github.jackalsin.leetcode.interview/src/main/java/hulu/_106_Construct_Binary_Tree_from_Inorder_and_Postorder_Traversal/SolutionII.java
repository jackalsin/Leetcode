package hulu._106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import utils.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/25/2020
 */
public final class SolutionII implements Solution {
  private final Map<Integer, Integer> reverseIndex = new HashMap<>();

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    for (int i = 0; i < inorder.length; ++i) {
      reverseIndex.put(inorder[i], i);
    }
    return buildTree(postorder, postorder.length - 1, 0, inorder.length - 1);
  }

  private TreeNode buildTree(final int[] postorder, final int postRootIndex,
                             final int inorderLeft, final int inorderRight) {
//    System.out.println("rootIndexPostorder = " + postRootIndex + ",  inorderLeft = " + inorderLeft +
//        ", inorderRight = " + inorderRight);
    if (inorderLeft > inorderRight) {
      return null;
    }
    final int rootVal = postorder[postRootIndex];
    final TreeNode root = new TreeNode(rootVal);
    if (inorderLeft == inorderRight) {
      return root;
    }
    final int rootIndexInOrder = reverseIndex.get(postorder[postRootIndex]);
    root.left = buildTree(postorder, postRootIndex - 1 + rootIndexInOrder - inorderRight, inorderLeft,
        rootIndexInOrder - 1);
    root.right = buildTree(postorder, postRootIndex - 1, rootIndexInOrder + 1, inorderRight);
    return root;
  }
}
