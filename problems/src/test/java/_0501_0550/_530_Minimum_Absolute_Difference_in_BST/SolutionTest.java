package _0501_0550._530_Minimum_Absolute_Difference_in_BST;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, null, 3);
    root.right.left = new TreeNode(2);
    assertEquals(1, solution.getMinimumDifference(root));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(543, 384, 652, null, 445, null, 699);
    assertEquals(47, solution.getMinimumDifference(root));
  }
}