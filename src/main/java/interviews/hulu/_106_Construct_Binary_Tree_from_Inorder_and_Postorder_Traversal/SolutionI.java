package interviews.hulu._106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import utils.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/10/2020
 */
public final class SolutionI implements Solution {
  private final Map<Integer, Integer> inorderReverseIndex = new HashMap<>();

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    for (int i = 0; i < postorder.length; ++i) {
      inorderReverseIndex.put(inorder[i], i);
    }
    return buildTree(postorder, postorder.length - 1, 0, postorder.length - 1);
  }

  private TreeNode buildTree(final int[] postorder, final int rootIndexPostOrder,
                             final int inorderLeft, int inorderRight) {
//    System.out.println("rootIndexPostorder = " + rootIndexPostOrder + ",  inorderLeft = " + inorderLeft +
//        ", inorderRight = " + inorderRight);
    if (inorderLeft > inorderRight) {
      return null;
    }
    if (inorderLeft == inorderRight) {
      return new TreeNode(postorder[rootIndexPostOrder]);
    }
    final TreeNode root = new TreeNode(postorder[rootIndexPostOrder]);
    final int rootIndexInorder = inorderReverseIndex.get(postorder[rootIndexPostOrder]);
//    System.out.println(rootIndexInorder);
    root.left = buildTree(postorder, rootIndexPostOrder - (inorderRight - rootIndexInorder + 1),
        inorderLeft, rootIndexInorder - 1);
    root.right = buildTree(postorder, rootIndexPostOrder - 1,
        rootIndexInorder + 1, inorderRight);
    return root;
  }
}
