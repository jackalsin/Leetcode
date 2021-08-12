package _0501_0550._501_Find_Mode_in_Binary_Search_Tree;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class ONSolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new ONSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, null, 2);
    root.right.left = new TreeNode(2);
    final int[] expected = {2};
    assertArrayEquals(expected, solution.findMode(root));
  }
}