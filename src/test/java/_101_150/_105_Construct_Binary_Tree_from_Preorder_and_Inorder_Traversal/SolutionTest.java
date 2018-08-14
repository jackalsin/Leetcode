package _101_150._105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 6/18/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    assertEquals(null, solution.buildTree(new int[]{}, new int[]{}));
  }

  @Test
  public void test3Levels() throws Exception {
    final int[] preOrder = new int[]{1, 2, 4, 5, 3, 6, 7};
    final int[] levelOrder = new int[]{1, 2, 3, 4, 5, 6, 7};
    final int[] inOrder = new int[]{4, 2, 5, 1, 6, 3, 7};
    final TreeNode root = TreeNodes.getTreeLevelOrder(levelOrder);
    assertEquals(root, solution.buildTree(preOrder, inOrder));
  }


}