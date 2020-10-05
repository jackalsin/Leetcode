package google.similar_tree;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 1/27/2018.
 */
public final class ONSquareSolution implements Solution {
  public boolean isSimilarTree(final TreeNode root1, final TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    } else if (root1 == null) { // root2 != null
      return false;
    } else if (root2 == null) {
      return false;
    } else {
      if (root1.val != root2.val) {
        return false;
      }
      return (isSimilarTree(root1.left, root2.left) && isSimilarTree(root1.right, root2.right)) ||
          (isSimilarTree(root1.left, root2.right) && isSimilarTree(root1.right, root2.left));
    }
  }


}
