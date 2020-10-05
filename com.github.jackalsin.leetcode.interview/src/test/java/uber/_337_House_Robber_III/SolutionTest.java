package uber._337_House_Robber_III;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
//    solution = new MapSolution();
    solution = new IntSolution();
  }

  @Test
  void testOnlineCase() {
    TreeNode root = TreeNodes.getTreeLevelOrder(3, 2, 3, null, 3, null, 1);
    assertEquals(7, solution.rob(root));
  }

  @Test
  void testOnlineCase2() {
    TreeNode root = TreeNodes.getTreeLevelOrder(3, 4, 5, 1, 3, null, 1);
    assertEquals(9, solution.rob(root));
  }
}