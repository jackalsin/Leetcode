package _0301_0350._314_Binary_Tree_Vertical_Order_Traversal;

import org.junit.Before;
import org.junit.Test;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/18/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testExample1() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(3, 9, 20, null, null, 15, 7);
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(9));
    expected.add(Arrays.asList(3, 15));
    expected.add(Arrays.asList(20));
    expected.add(Arrays.asList(7));
    assertEquals(expected, solution.verticalOrder(root));
  }

  @Test
  public void testExample2() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(3, 9, 8, 4, 0, 1, 7);
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(4));
    expected.add(Arrays.asList(9));
    expected.add(Arrays.asList(3, 0, 1));
    expected.add(Arrays.asList(8));
    expected.add(Arrays.asList(7));
    assertEquals(expected, solution.verticalOrder(root));
  }

  @Test
  public void testExample3() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(3, 9, 8, 4, 0, 1, 7, null, null, null, 2, 5);
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(4));
    expected.add(Arrays.asList(9, 5));
    expected.add(Arrays.asList(3, 0, 1));
    expected.add(Arrays.asList(8, 2));
    expected.add(Arrays.asList(7));
    assertEquals(expected, solution.verticalOrder(root));
  }

  @Test
  public void testNull() throws Exception {
    assertEquals(new ArrayList<>(), solution.verticalOrder(null));
  }
}
