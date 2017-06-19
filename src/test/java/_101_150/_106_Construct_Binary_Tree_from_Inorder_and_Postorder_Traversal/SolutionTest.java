package _101_150._106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import org.junit.Before;
import org.junit.Test;

import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.*;

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
  public void test3Levels() throws Exception {
    final int[] inorder = new int[] {1, 2, 3, 4, 5, 6, 7};
    final int[] levelOrder = new int[] {4, 2, 6, 1, 3, 5, 7};
    final int[] postOrder  = new int[] {1, 3, 2, 5, 7, 6, 4};
    final TreeNode root = TreeNodes.getTreeLevelOrder(levelOrder);
    assertEquals(root, solution.buildTree(inorder, postOrder));
  }

}
