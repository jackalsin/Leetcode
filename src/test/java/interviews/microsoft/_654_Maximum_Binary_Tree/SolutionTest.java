package interviews.microsoft._654_Maximum_Binary_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new SolutionI();
  }

  /**
   * For the ONSolution, when we deal 5, the thing is stack is [6, 0]
   */
  @Test
  public void testOnlineCase() throws Exception {
    final int[] input = {3, 2, 1, 6, 0, 5};
    TreeNode root = TreeNodes.getTreeLevelOrder(6, 3, 5, null, 2, 0);
    assert root != null;
    root.left.right.right = new TreeNode(1);
    assertEquals(root, solution.constructMaximumBinaryTree(input));
  }

  @Test
  public void testNull() throws Exception {
    assertEquals(null, solution.constructMaximumBinaryTree(new int[]{}));
  }
}