package interviews.microsoft._098_Validate_Binary_Search_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void test213() {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    assertTrue(solution.isValidBST(root));
  }

  @Test
  void test123() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    assertFalse(solution.isValidBST(root));
  }

  @Test
  void testFailedCase1() {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(14);
    root.left.left = new TreeNode(1);
    assertFalse(solution.isValidBST(root));
  }

  @Test
  void testFailedCase2() {
    TreeNode root = TreeNodes.getTreeLevelOrder(5, 1, 4, null, null, 3, 6);
    assertFalse(solution.isValidBST(root));
  }

}