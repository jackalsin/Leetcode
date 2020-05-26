package interviews.microsoft._106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import utils.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    final Map<Integer, Integer> valToIndex = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      valToIndex.put(inorder[i], i);
    }

    return buildTree(valToIndex, inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
  }

  private TreeNode buildTree(final Map<Integer, Integer> valToIndex, final int[] inorder, final int is, final int ie,
                             int[] postorder, int ps, int pe) {
    if (is > ie || ps > pe) {
      return null;
    }

    final int rootIndex = valToIndex.get(postorder[pe]);
    // pe 这一行满足 pe - ps = rootIndex - 1 - is,
    final TreeNode left = buildTree(valToIndex, inorder, is, rootIndex - 1, postorder, ps, rootIndex - 1 - is + ps);
    final TreeNode right = buildTree(valToIndex, inorder, rootIndex + 1, ie, postorder, rootIndex - is + ps, pe - 1);

    final TreeNode root = new TreeNode(postorder[pe]);
    root.left = left;
    root.right = right;

    return root;
  }
}
