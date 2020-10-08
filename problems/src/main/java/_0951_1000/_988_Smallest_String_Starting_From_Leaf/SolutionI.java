package _0951_1000._988_Smallest_String_Starting_From_Leaf;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/7/2020
 */
public final class SolutionI implements Solution {
  private String minStr = null;

  public String smallestFromLeaf(TreeNode root) {
    smallestFromLeaf(root, new StringBuilder());
    return minStr;
  }

  private void smallestFromLeaf(final TreeNode root, final StringBuilder sb) {
    if (root == null) {
      return;
    }
    final int len = sb.length();
    sb.append((char) (root.val + 'a'));
    if (root.left == null && root.right == null) {
      final String reverse = new StringBuilder(sb).reverse().toString();
//      System.out.println(reverse);
      if (minStr == null || reverse.compareTo(minStr) < 0) {
        minStr = reverse;
      }
      // end of leaf
    }
    smallestFromLeaf(root.left, sb);
    sb.setLength(len + 1);
    smallestFromLeaf(root.right, sb);
    sb.setLength(len);
  }
}
