package apple._106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import definition.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/20/2021
 */
public final class SolutionI implements Solution {
  private final Map<Integer, Integer> map = new HashMap<>();

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    for (int i = 0; i < inorder.length; ++i) {
      map.put(inorder[i], i);
    }
    return buildTree(postorder, 0, inorder.length - 1, postorder.length - 1);
  }

  private TreeNode buildTree(final int[] postorder, final int inorderStart,
                             final int inorderEnd, final int rootIndexInPostOrder) {
    if (inorderStart > inorderEnd) {
      return null;
    }
    final int rootVal = postorder[rootIndexInPostOrder];
    final TreeNode root = new TreeNode(rootVal);
    final int rootIndexInorder = map.get(rootVal);
    root.right = buildTree(postorder, rootIndexInorder + 1, inorderEnd, rootIndexInPostOrder - 1);

    root.left = buildTree(postorder, inorderStart, rootIndexInorder - 1,
        rootIndexInPostOrder + rootIndexInorder - inorderEnd - 1);
    return root;
  }
}
