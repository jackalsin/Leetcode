package _0251_0300._285_Inorder_Successor_in_BST;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/4/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOne() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1);
    assertEquals(null, solution.inorderSuccessor(root, root));
  }

}
