package _0651_0700._654_Maximum_Binary_Tree;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/31/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
//    solution = new ONSquareSolution();
    solution = new ONSolution();
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
