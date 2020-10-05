package microsoft._124_Binary_Tree_Maximum_Path_Sum;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void test3() {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3);
    assertEquals(6, solution.maxPathSum(root));
  }
}