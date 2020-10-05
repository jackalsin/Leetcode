package microsoft._333_Largest_BST_Subtree;

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
  void testOnlineCase() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(10, 5, 15, 1, 8, null, 7);
    assertEquals(3, solution.largestBSTSubtree(root));
  }

  @Test
  void testFailed1() {
    final TreeNode root = new TreeNode(2);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(1);
    assertEquals(2, solution.largestBSTSubtree(root));
  }

  @Test
  void testFailed2() {
    final TreeNode root = new TreeNode(4);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(2);
    root.left.left.left = new TreeNode(3);
    assertEquals(1, solution.largestBSTSubtree(root));
  }

  @Test
  void testNull() {
    assertEquals(0, solution.largestBSTSubtree(null));
  }
}