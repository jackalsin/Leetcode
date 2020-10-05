package microsoft._285_Inorder_Successor_in_BST;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOne() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1);
    assertNull(solution.inorderSuccessor(root, root));
  }

  @Test
  void testThree() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 1, 3);
    assertEquals(root, solution.inorderSuccessor(root, root.left));
  }

}