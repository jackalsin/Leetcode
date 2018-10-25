package interviews.linkedin._671_Second_Minimum_Node_In_a_Binary_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/24/2017.
 */
class SolutionIITest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SolutionIII();
  }

  @Test
  void testOnlineCase() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 2, 5, null, null, 5, 7);
    assertEquals(5, solution.findSecondMinimumValue(root));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 2, 2);
    assertEquals(-1, solution.findSecondMinimumValue(root));
  }
}
