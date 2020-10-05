package microsoft._106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

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
  void test3Levels() {
    final int[] inorder = new int[]{1, 2, 3, 4, 5, 6, 7};
    final int[] levelOrder = new int[]{4, 2, 6, 1, 3, 5, 7};
    final int[] postOrder = new int[]{1, 3, 2, 5, 7, 6, 4};
    final TreeNode root = TreeNodes.getTreeLevelOrder(levelOrder);
    assertEquals(root, solution.buildTree(inorder, postOrder));
  }
}