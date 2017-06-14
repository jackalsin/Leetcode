package utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 5/31/2017.
 */
public class TreeNodesTest {
  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testGenerateTreePreorder() throws Exception {
    final int[] input = new int[] {4, 2, 1, 3, 6, 5 ,7};
    TreeNode expected = new TreeNode(4);
      expected.left = new TreeNode(2);
      expected.right = new TreeNode(6);
        expected.left.left = new TreeNode(1);
        expected.left.right = new TreeNode(3);
        expected.right.left = new TreeNode(5);
        expected.right.right = new TreeNode(7);
    assertEquals(expected, TreeNodes.getTreePreorder(input));
  }

  @Test
  public void testGenerateTreePreorderVarArgsIntegers() throws Exception {
    TreeNode expected = new TreeNode(4);
    expected.left = new TreeNode(2);
    expected.right = new TreeNode(6);
    expected.left.left = new TreeNode(1);
    expected.left.right = new TreeNode(3);
    expected.right.left = new TreeNode(5);
    expected.right.right = new TreeNode(7);
    assertEquals(expected, TreeNodes.getTreePreorder(4, 2, 1, 3, 6, 5 ,7));
  }

  @Test
  public void testGenerateTreePreorderVarArgsIntegersWithNull() throws Exception {
    TreeNode expected = new TreeNode(4);
    expected.left = new TreeNode(2);
    expected.right = new TreeNode(6);
    expected.right.left = new TreeNode(5);
    expected.right.right = new TreeNode(7);
    assertEquals(expected, TreeNodes.getTreePreorder(4, 2, null, null, 6, 5 ,7));
  }

  @Test
  public void testGenerateTreeLevelOrder() throws Exception {
    final int[] input = new int[] {4, 2, 6, 1, 3, 5, 7};
    TreeNode root = TreeNodes.getTreeLevelOrder(input);
    TreeNode expected = new TreeNode(4);
      expected.left = new TreeNode(2);
        expected.left.left = new TreeNode(1);
        expected.left.right = new TreeNode(3);
      expected.right = new TreeNode(6);
        expected.right.left = new TreeNode(5);
        expected.right.right = new TreeNode(7);
    assertEquals(expected, root);
  }

  @Test
  public void testGenerateTreeLevelOrderVarArgsIntegersWithNull() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(4, 2, 6, null, null, 5, 7);
    TreeNode expected = new TreeNode(4);
    expected.left = new TreeNode(2);
    expected.right = new TreeNode(6);
    expected.right.left = new TreeNode(5);
    expected.right.right = new TreeNode(7);
    assertEquals(expected, root);
  }

}
