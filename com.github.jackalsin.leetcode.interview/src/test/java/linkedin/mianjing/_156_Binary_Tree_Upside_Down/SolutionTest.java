package linkedin.mianjing._156_Binary_Tree_Upside_Down;

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
  void testOneElement() {
    TreeNode input = TreeNodes.getTreeLevelOrder(1);
    TreeNode expected = TreeNodes.getTreeLevelOrder(1);
    assertEquals(expected, solution.upsideDownBinaryTree(input));
  }

  @Test
  void testTwoElements() {
    TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, null);
    TreeNode expected = TreeNodes.getTreeLevelOrder(2, null, 1);
    assertEquals(expected, solution.upsideDownBinaryTree(input));
  }

  @Test
  void testTwoLevelsFull() {
    TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3);
    TreeNode expected = TreeNodes.getTreeLevelOrder(2, 3, 1);
    assertEquals(expected, solution.upsideDownBinaryTree(input));
  }

  @Test
  void testThreeLevels() {
    TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5, null, null);
    TreeNode expected = TreeNodes.getTreeLevelOrder(4, 5, 2, null, null, 3, 1);
    assertEquals(expected, solution.upsideDownBinaryTree(input));
  }

}