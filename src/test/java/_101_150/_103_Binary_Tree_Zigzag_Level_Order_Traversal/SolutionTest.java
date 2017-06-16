package _101_150._103_Binary_Tree_Zigzag_Level_Order_Traversal;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/16/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test1Level() throws Exception {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1);
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Collections.singletonList(1));
    assertEquals(expected, solution.zigzagLevelOrder(input));
  }

  @Test
  public void test2Levels() throws Exception {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3);
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Collections.singletonList(1));
    expected.add(Arrays.asList(3, 2));
    assertEquals(expected, solution.zigzagLevelOrder(input));
  }

  @Test
  public void test3Levels() throws Exception {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5, 6, 7);
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Collections.singletonList(1));
    expected.add(Arrays.asList(3, 2));
    expected.add(Arrays.asList(4, 5, 6, 7));
    assertEquals(expected, solution.zigzagLevelOrder(input));
  }
}
