package interviews.pinterest.binarySearchTreeRemoveOutRange;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(7, 4, 11, 2, 5, 9, 13, 1, 3, 4, 6, 8, 10, 12, 14);
    final int min = 2, max = 15;
    final TreeNode actual = solution.removeRange(root, min, max);
    assertTrue(isValidBinaryTree(actual, min, max));
  }

  @Test
  void testOnlineCase2() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(7, 4, 11, 2, 5, 9, 13, 1, 3, 4, 6, 8, 10, 12, 14);
    final int min = 3, max = 15;
    final TreeNode actual = solution.removeRange(root, min, max);
    assertTrue(isValidBinaryTree(actual, min, max));
  }

  @Test
  void testOnlineCase3() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(7, 4, 11, 2, 5, 9, 13, 1, 3, 4, 6, 8, 10, 12, 14);
    final int min = 4, max = 15;
    final TreeNode actual = solution.removeRange(root, min, max);
    assertTrue(isValidBinaryTree(actual, min, max));
  }

  @Test
  void testOnlineCase4() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(7, 4, 11, 2, 5, 9, 13, 1, 3, 4, 6, 8, 10, 12, 14);
    final int min = 5, max = 15;
    final TreeNode actual = solution.removeRange(root, min, max);
    assertTrue(isValidBinaryTree(actual, min, max));
  }

  private boolean isValidBinaryTree(TreeNode root, int min, int max) {
    if (root == null) {
      return true;
    } else {
      if (root.val < min || root.val > max) {
        return false;
      }

      if (root.left != null && root.left.val >= root.val) {
        return false;
      }
      if (root.right != null && root.right.val <= root.val) {
        return false;
      }
      return isValidBinaryTree(root.left, min, max) && isValidBinaryTree(root.right, min, max);
    }
  }
}