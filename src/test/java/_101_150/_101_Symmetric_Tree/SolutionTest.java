package _101_150._101_Symmetric_Tree;

import org.junit.Before;
import org.junit.Test;

import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/13/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testSymmetric() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(new int[] {6, 3, 3, 6, 4, 4, 6});
    assertTrue(solution.isSymmetric(root));
  }

  @Test
  public void testNotSymmetric() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(new int[] {6, 3, 3, 6, 5, 4, 6});
    assertFalse(solution.isSymmetric(root));
  }
}
