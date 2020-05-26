package _0251_0300._270_Closest_Binary_Search_Tree_Value;

import org.junit.Before;
import org.junit.Test;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/30/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test1() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1);
    assertEquals(1, solution.closestValue(root, 1));
    assertEquals(1, solution.closestValue(root, -1));
    assertEquals(1, solution.closestValue(root, Integer.MAX_VALUE));
    assertEquals(1, solution.closestValue(root, Integer.MIN_VALUE));
  }

  @Test
  public void test2Levels() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 1, 3);
    assertEquals(1, solution.closestValue(root, 1));
    assertEquals(1, solution.closestValue(root, -1));
    assertEquals(3, solution.closestValue(root, Integer.MAX_VALUE));
    assertEquals(1, solution.closestValue(root, Integer.MIN_VALUE));
  }

  @Test
  public void test2Incompleted() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, null, 2);
    assertEquals(1, solution.closestValue(root, 1));
    assertEquals(1, solution.closestValue(root, -1));
    assertEquals(2, solution.closestValue(root, Integer.MAX_VALUE));
    assertEquals(1, solution.closestValue(root, Integer.MIN_VALUE));
  }

  @Test
  public void test3Incompleted() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(4, 2, 6, 1, 3, 5, 7);
    assertEquals(1, solution.closestValue(root, 1));
    assertEquals(1, solution.closestValue(root, -1));
    assertEquals(3, solution.closestValue(root, 3.2));
    assertEquals(5, solution.closestValue(root, 4.9));
  }

  @Test
  public void testEnd() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(8, 1);
    assertEquals(8, solution.closestValue(root, 6.0));
  }

}
