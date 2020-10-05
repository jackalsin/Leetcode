package _0301_0350._333_Largest_BST_Subtree;

import org.junit.Before;
import org.junit.Test;
import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/2/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(10, 5, 15, 1, 8, null, 7);
    assertEquals(3, solution.largestBSTSubtree(root));
  }

  @Test
  public void testFailed1() throws Exception {
    final TreeNode root = new TreeNode(2);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(1);
    assertEquals(2, solution.largestBSTSubtree(root));
  }

  @Test
  public void testFailed2() throws Exception {
    final TreeNode root = new TreeNode(4);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(2);
    root.left.left.left = new TreeNode(3);
    assertEquals(1, solution.largestBSTSubtree(root));
  }
}
