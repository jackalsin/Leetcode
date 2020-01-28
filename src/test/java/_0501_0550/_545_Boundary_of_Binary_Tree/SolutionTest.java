package _0501_0550._545_Boundary_of_Binary_Tree;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final TreeNode root = new TreeNode(1);
    root.right = TreeNodes.getTreeLevelOrder(2, 3, 4);
    final List<Integer> expected = List.of(1, 3, 4, 2);
    assertEquals(expected, solution.boundaryOfBinaryTree(root));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5, 6);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(8);
    root.right.left.left = new TreeNode(9);
    root.right.left.right = new TreeNode(10);

    final List<Integer> expected = List.of(1, 2, 4, 7, 8, 9, 10, 6, 3);
    assertEquals(expected, solution.boundaryOfBinaryTree(root));
  }

  @Test
  public void testEmpty() throws Exception {
    assertEquals(new ArrayList<>(), solution.boundaryOfBinaryTree(null));
  }

  @Test
  public void test1() throws Exception {
    assertEquals(List.of(1), solution.boundaryOfBinaryTree(new TreeNode(1)));
  }
}