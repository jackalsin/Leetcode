package _0501_0550._501_Find_Mode_in_Binary_Search_Tree;

import org.junit.Before;
import org.junit.Test;
import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class NoMapSolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new NoMapSolution();
  }

  @Test
  public void testMorrisTraversal() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15);
    solution.findMode(root);
  }

  @Test
  public void testMorrisTraversal2() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, null, 3);
    root.right.left = new TreeNode(2);
    solution.findMode(root);
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, null, 2);
    root.right.left = new TreeNode(2);
    final int[] actual = solution.findMode(root);
    assertArrayEquals(new int[]{2}, actual);
  }

  @Test
  public void testFailedOnZeroConfig() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, null, 2);
    final int[] actual = solution.findMode(root);
    final List<Integer> actualList = Arrays.stream(actual).boxed().collect(Collectors.toList());

    final Set<Integer> expected = Set.of(1, 2);
    assertEquals(expected, new HashSet<>(actualList));
  }

  @Test
  public void testFailedOnEmpty() {
    final TreeNode root = null;
    assertArrayEquals(new int[]{}, solution.findMode(root));
  }
}