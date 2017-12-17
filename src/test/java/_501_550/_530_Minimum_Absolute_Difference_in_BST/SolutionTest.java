package _501_550._530_Minimum_Absolute_Difference_in_BST;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertEquals;

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
}