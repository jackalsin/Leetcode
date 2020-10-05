package _0201_0250._250_Count_Univalue_Subtrees;

import org.junit.Before;
import org.junit.Test;
import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/23/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOne() throws Exception {
    assertEquals(1, solution.countUnivalSubtrees(TreeNodes.getTreeLevelOrder(1)));
  }

  @Test
  public void testOnline() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(5, 1, 5, 5, 5, null, 5);
    assertEquals(4, solution.countUnivalSubtrees(root));
  }

  @Test
  public void testMisunderstanding() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(5,5,5,5,5,null,5);
    assertEquals(6, solution.countUnivalSubtrees(root));
  }
}
