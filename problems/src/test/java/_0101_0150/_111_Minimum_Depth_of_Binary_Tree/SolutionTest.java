package _0101_0150._111_Minimum_Depth_of_Binary_Tree;

import definition.binaryTree.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 6/21/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testMinLevel2() throws Exception {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(4);
    assertEquals(2, solution.minDepth(root));
  }

  @Test
  public void testMinLevel2Balanced() throws Exception {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(4);
    root.right = new TreeNode(4);
    assertEquals(2, solution.minDepth(root));
  }

  @Test
  public void testMinLevel2Inbalanced() throws Exception {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(4);
    root.right = new TreeNode(4);
    root.left.left = new TreeNode(4);
    assertEquals(2, solution.minDepth(root));
  }
}