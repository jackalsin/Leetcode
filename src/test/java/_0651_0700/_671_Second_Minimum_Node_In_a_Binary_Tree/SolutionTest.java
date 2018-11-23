package _0651_0700._671_Second_Minimum_Node_In_a_Binary_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 2, 5, null, null, 5, 7);
    assertEquals(5, solution.findSecondMinimumValue(root));
  }

  @Test
  void testOnlineCase2() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 2, 2);
    assertEquals(-1, solution.findSecondMinimumValue(root));
  }

  @Test
  void testPositiveOneElement() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1);
    assertEquals(-1, solution.findSecondMinimumValue(root));
  }

  @Test
  void testLeftChildBigger() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(5, 8, 5);
    assertEquals(8, solution.findSecondMinimumValue(root));
  }

  @Test
  void testFailedTestCase() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 1, 3, 8, 4,
        8, 3, 3, 1, 6, 2, 1);
    assertEquals(2, solution.findSecondMinimumValue(root));
  }
}
