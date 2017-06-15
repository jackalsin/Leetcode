package _101_150._102_Binary_Tree_Level_Order_Traversal;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import utils.ListNode;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 6/14/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test3Levels() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(new int[]{4, 2, 6, 1, 3, 5, 7});
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Collections.singletonList(4));
    expected.add(Arrays.asList(2, 6));
    expected.add(Arrays.asList(1, 3, 5, 7));
    assertEquals(expected, solution.levelOrder(root));
  }

  @Test
  public void test2Levels() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(new int[]{4, 2, 6});
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Collections.singletonList(4));
    expected.add(Arrays.asList(2, 6));
    assertEquals(expected, solution.levelOrder(root));
  }
  @Test
  public void test1Level() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(new int[]{4});
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Collections.singletonList(4));
    assertEquals(expected, solution.levelOrder(root));
  }

  @Test
  public void testEmpty() throws Exception {
<<<<<<< HEAD
    TreeNode root = TreeNodes.getTreeBFS(new int[]{});
=======
    TreeNode root = TreeNodes.getTreeLevelOrder(new int[]{});
>>>>>>> 1804f41... Fix Refactor
    List<List<Integer>> expected = new ArrayList<>();
    assertEquals(expected, solution.levelOrder(root));
  }
}