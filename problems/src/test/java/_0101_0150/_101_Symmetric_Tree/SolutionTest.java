package _0101_0150._101_Symmetric_Tree;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
