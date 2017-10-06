package _301_350._337_House_Robber_III;

import org.junit.Before;
import org.junit.Test;

import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/5/2017.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(3, 2, 3, null, 3, null, 1);
    assertEquals(7, solution.rob(root));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(3, 4, 5, 1, 3, null, 1);
    assertEquals(9, solution.rob(root));
  }
}
