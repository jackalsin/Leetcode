package microsoft.noodleEssence._105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import utils.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    final Map<Integer, Integer> valToIndex = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      valToIndex.put(inorder[i], i);
    }

    return buildTree(valToIndex, preorder, inorder, 0, 0, inorder.length - 1);
  }

  private static TreeNode buildTree(final Map<Integer, Integer> valToIndex, final int[] preorder, final int[] inorder,
                                    final int preIndex, final int inStart, final int inEnd) {
    if (inStart > inEnd) {
      return null;
    } else if (inStart == inEnd) {
      return new TreeNode(inorder[inStart]);
    }
    final TreeNode root = new TreeNode(preorder[preIndex]);
    final int rootIndex = valToIndex.get(preorder[preIndex]);
    root.left = buildTree(valToIndex, preorder, inorder, preIndex + 1, inStart, rootIndex - 1);
    root.right = buildTree(valToIndex, preorder, inorder, preIndex + rootIndex - inStart + 1, rootIndex + 1, inEnd);
    return root;
  }
}
