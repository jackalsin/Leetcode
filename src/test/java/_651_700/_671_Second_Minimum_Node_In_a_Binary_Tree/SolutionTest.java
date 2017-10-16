package _651_700._671_Second_Minimum_Node_In_a_Binary_Tree;

import org.junit.Before;
import org.junit.Test;

import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 2, 5, null, null, 5, 7);
    assertEquals(5, solution.findSecondMinimumValue(root));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 2, 2);
    assertEquals(-1, solution.findSecondMinimumValue(root));
  }

  @Test
  public void testPositiveOneElement() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1);
    assertEquals(-1, solution.findSecondMinimumValue(root));
  }

  @Test
  public void testLeftChildBigger() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(5, 8, 5);
    assertEquals(8, solution.findSecondMinimumValue(root));
  }

  @Test
  public void testFailedTestCase() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 1, 3, 8, 4,
        8, 3, 3, 1, 6, 2, 1);
    assertEquals(2, solution.findSecondMinimumValue(root));
  }
}
