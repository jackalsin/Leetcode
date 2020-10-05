package microsoft._094_Binary_Tree_Inorder_Traversal;

import definition.binaryTree.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
//    solution = new StackSolution();
    solution = new MorrisTraversalSolution();
  }

  @Test
  void testBalancedTree() {
    final TreeNode root = new TreeNode(1);
    root.left = null;
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);

    assertEquals(Arrays.asList(1, 3, 2), solution.inorderTraversal(root));
  }
}