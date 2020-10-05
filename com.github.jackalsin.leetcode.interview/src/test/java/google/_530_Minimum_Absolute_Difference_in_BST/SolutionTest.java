package google._530_Minimum_Absolute_Difference_in_BST;

import org.junit.Before;
import org.junit.Test;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/28/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, null, 3);
    root.right.left = new TreeNode(2);
    assertEquals(1, solution.getMinimumDifference(root));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(543, 384, 652, null, 445, null, 699);
    assertEquals(47, solution.getMinimumDifference(root));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final TreeNode root = new TreeNode(0);
    root.right = new TreeNode(2236);
    root.right.left = new TreeNode(1277);
    root.right.left.left = new TreeNode(519);
    root.right.right = new TreeNode(2776);
    assertEquals(519, solution.getMinimumDifference(root));
  }
}
