package _0051_0100._098_Validate_Binary_Search_Tree;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 6/6/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test213() throws Exception {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    assertTrue(solution.isValidBST(root));
  }

  @Test
  public void test123() throws Exception {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    assertFalse(solution.isValidBST(root));
  }

  @Test
  public void testFailedCase1() throws Exception {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(14);
    root.left.left = new TreeNode(1);
    assertFalse(solution.isValidBST(root));
  }
}