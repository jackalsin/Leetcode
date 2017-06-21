package _101_150._110_Balanced_Binary_Tree;

import org.junit.Before;
import org.junit.Test;

import utils.TreeNode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 6/20/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test1Level() throws Exception {
    TreeNode root = new TreeNode(1);
    assertTrue(solution.isBalanced(root));
  }

  @Test
  public void test0Level() throws Exception {
    assertTrue(solution.isBalanced(null));
  }

  @Test
  public void test2LevelsBalanced() throws Exception {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    assertTrue(solution.isBalanced(root));
  }

  @Test
  public void test2LevelsBalanced1Diff() throws Exception {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(3);
    assertTrue(solution.isBalanced(root));
  }

  @Test
  public void test3LevelsBalanced1Diff() throws Exception {
    TreeNode root = new TreeNode(4);
      root.left = new TreeNode(3);
      root.right = new TreeNode(5);
      root.left.left = new TreeNode(2);
      assertTrue(solution.isBalanced(root));
  }

  @Test
  public void testNotBalanced() throws Exception {
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