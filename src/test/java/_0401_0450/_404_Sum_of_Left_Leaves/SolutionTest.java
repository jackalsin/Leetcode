package _0401_0450._404_Sum_of_Left_Leaves;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(3, 9, 20, 1, 2, 15, 7, 3, 5, 4);
    assertEquals(22, solution.sumOfLeftLeaves(root));
  }

  @Test
  void testOnlineCase2() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(3, 9, 20, null, null, 15, 7);
    assertEquals(24, solution.sumOfLeftLeaves(root));
  }
}