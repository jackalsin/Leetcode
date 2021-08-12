package _0101_0150._102_Binary_Tree_Level_Order_Traversal;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 6/14/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
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
    TreeNode root = TreeNodes.getTreeLevelOrder(new int[]{});
    List<List<Integer>> expected = new ArrayList<>();
    assertEquals(expected, solution.levelOrder(root));
  }
}