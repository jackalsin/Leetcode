package pinterest._437_Path_Sum_III;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
//    solution = new SampleSolution();
//    solution = new MySolution();
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1);
    assertEquals(3, solution.pathSum(root, 8));
  }

  @Test
  void testFailedCase1() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1);
    assertEquals(0, solution.pathSum(root, 0));
  }

  @Test
  void testZeroInMidPath() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 0, 2, 3, 4, 2);
    assertEquals(1, solution.pathSum(root, 0));
  }

  @Test
  void testZeroInMidPath2() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 0, 2, 3, 4, 2);
    // [1 -> 0 -> 3], [0 -> 4], [2 -> 2], [4]
    assertEquals(4, solution.pathSum(root, 4));
  }
}