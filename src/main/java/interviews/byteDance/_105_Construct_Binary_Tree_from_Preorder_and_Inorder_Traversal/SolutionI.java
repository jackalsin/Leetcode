package interviews.byteDance._105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import utils.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhixi
 * @version 1.0 on 5/7/2020
 */
public final class SolutionI implements Solution {
  private final Map<Integer, Integer> valToIndex = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < inorder.length; ++i) {
      valToIndex.put(inorder[i], i);
    }
    return buildTree(preorder, inorder, 0, inorder.length - 1, 0);
  }

  private TreeNode buildTree(final int[] preorder, final int[] inorder, final int left, final int right,
                             final int preorderRootIndex) {
    if (left > right) {
      return null;
    }
    final int rootVal = preorder[preorderRootIndex];
    final int inorderRootIndex = valToIndex.get(rootVal);
    final TreeNode root = new TreeNode(rootVal);
    root.left = buildTree(preorder, inorder, left, inorderRootIndex - 1, preorderRootIndex + 1);
    final int leftLength = inorderRootIndex - left + 1;
    root.right = buildTree(preorder, inorder, inorderRootIndex + 1, right, preorderRootIndex + leftLength);
    return root;
  }
}
