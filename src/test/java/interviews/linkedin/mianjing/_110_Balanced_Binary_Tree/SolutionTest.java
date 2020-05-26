package interviews.linkedin.mianjing._110_Balanced_Binary_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.binaryTree.TreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void test1Level() {
    TreeNode root = new TreeNode(1);
    assertTrue(solution.isBalanced(root));
  }

  @Test
  void test0Level() {
    assertTrue(solution.isBalanced(null));
  }

  @Test
  void test2LevelsBalanced() {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    assertTrue(solution.isBalanced(root));
  }

  @Test
  void test2LevelsBalanced1Diff() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(3);
    assertTrue(solution.isBalanced(root));
  }

  @Test
  void test3LevelsBalanced1Diff() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(3);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(2);
    assertTrue(solution.isBalanced(root));
  }

  @Test
  void testNotBalanced() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(4);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);
    root.right.right.right = new TreeNode(4);
    assertFalse(solution.isBalanced(root));
  }


}