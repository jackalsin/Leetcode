package _101_150._107_Binary_Tree_Level_Order_Traversal_II;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 6/18/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test1Level() throws Exception {
    List<List<Integer>> expected = new ArrayList<>();
      expected.add(Arrays.asList(1));
    TreeNode input = TreeNodes.getTreeLevelOrder(1);
    assertEquals(expected, solution.levelOrderBottom(input));
  }

  @Test
  public void test2Level() throws Exception {
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(2, 3));
    expected.add(Arrays.asList(1));
    TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3);
    assertEquals(expected, solution.levelOrderBottom(input));
  }

  @Test
  public void test3Level() throws Exception {
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(4, 5, 6, 7));
    expected.add(Arrays.asList(2, 3));
    expected.add(Arrays.asList(1));
    TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5, 6, 7);
    assertEquals(expected, solution.levelOrderBottom(input));
  }

  @Test
  public void testNull() throws Exception {
    List<List<Integer>> expected = new ArrayList<>();
    TreeNode input = null;
    assertEquals(expected, solution.levelOrderBottom(input));
  }
}