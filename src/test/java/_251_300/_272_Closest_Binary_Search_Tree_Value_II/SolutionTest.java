package _251_300._272_Closest_Binary_Search_Tree_Value_II;

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
 * @version 1.0 on 9/1/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(4, 2, 6, 1, 3, 5, 7);
    assertEquals(new ArrayList<>(), solution.closestKValues(root, 8, 0));
  }

  @Test
  public void testBalanced() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(4, 2, 6, 1, 3, 5, 7);
    final List<Integer> expected = Arrays.asList(3, 4, 2, 5, 1);
    assertEquals(expected, solution.closestKValues(root, 3.4, 5));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(3, 1, 4, null, 2);
    final List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
    assertEquals(expected, solution.closestKValues(root, 2.00000, 1));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(5, 3, 6, 2, 4, null, null, 1);
    final List<Integer> expected = Arrays.asList(2);
    assertEquals(expected, solution.closestKValues(root, 0.857143, 5));
  }

}
