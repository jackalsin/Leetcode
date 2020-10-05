package microsoft._101_Symmetric_Tree;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testSymmetric() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(new int[]{6, 3, 3, 6, 4, 4, 6});
    assertTrue(solution.isSymmetric(root));
  }

  @Test
  void testNotSymmetric() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(new int[]{6, 3, 3, 6, 5, 4, 6});
    assertFalse(solution.isSymmetric(root));
  }
}