package _0101_0150._108_Convert_Sorted_Array_to_Binary_Search_Tree;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/19/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test3Nodes() throws Exception {
    final int[] input = new int[]{1, 2, 3};
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 1, 3);
    assertEquals(root, solution.sortedArrayToBST(input));
  }

  @Test
  public void test2Nodes() throws Exception {
    final int[] input = new int[]{1, 2};
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 1);
    assertEquals(root, solution.sortedArrayToBST(input));
  }
}
