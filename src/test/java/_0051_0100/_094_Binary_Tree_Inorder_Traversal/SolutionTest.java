package _0051_0100._094_Binary_Tree_Inorder_Traversal;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 5/31/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testBalancedTree() throws Exception {
    final TreeNode root = new TreeNode(1);
    root.left = null;
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);

    assertEquals(Arrays.asList(1, 3, 2), solution.inorderTraversal(root));
  }


}
