package interviews.linkedin._101_Symmetric_Tree;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/19/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new SolutionII();
  }

  @Test
  public void testOnlineCase() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 2, 3, 4, 4, 3);
    assertTrue(solution.isSymmetric(root));
  }

  @Test
  public void testThreeLevelTree() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 2, 3, 4, 4, 3, 5, 6, 7, 8, 8, 7, 6, 5);
    assertTrue(solution.isSymmetric(root));
  }

  @Test
  public void testFailed1() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 2, null, 3, null, 3);
    assertFalse(solution.isSymmetric(root));
  }

}
