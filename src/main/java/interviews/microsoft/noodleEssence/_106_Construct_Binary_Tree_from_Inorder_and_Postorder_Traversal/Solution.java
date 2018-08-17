package interviews.microsoft.noodleEssence._106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    final Map<Integer, Integer> valToIndex = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      valToIndex.put(inorder[i], i);
    }
    return buildTree(valToIndex, inorder, postorder, 0, postorder.length - 1, postorder.length - 1);
  }

  private static TreeNode buildTree(final Map<Integer, Integer> valToIndex, final int[] inorder,
                                    final int[] postorder, final int inStart, final int inEnd, final int postIndex) {
    if (inStart > inEnd) {
      return null;
    }
    if (inStart == inEnd) {
      return new TreeNode(inorder[inStart]);
    }
    final TreeNode root = new TreeNode(postorder[postIndex]);
    int rootIndex = valToIndex.get(postorder[postIndex]);
    root.left = buildTree(valToIndex, inorder, postorder, inStart, rootIndex - 1, postIndex - inEnd + rootIndex - 1);
    root.right = buildTree(valToIndex, inorder, postorder, rootIndex + 1, inEnd, postIndex - 1);
    return root;
  }

}
