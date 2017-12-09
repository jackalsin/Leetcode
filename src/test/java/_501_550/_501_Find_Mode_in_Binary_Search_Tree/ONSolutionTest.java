package _501_550._501_Find_Mode_in_Binary_Search_Tree;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertArrayEquals;

public class ONSolutionTest {
  private Solution solution;

  @Before
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