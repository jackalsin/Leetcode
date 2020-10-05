package linkedin.mianjing._272_Closest_Binary_Search_Tree_Value_II;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NLogKSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new NLogKSolution();
  }

  @Test
  void testEmpty() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(4, 2, 6, 1, 3, 5, 7);
    assertEquals(new ArrayList<>(), solution.closestKValues(root, 8, 0));
  }

  @Test
  void testBalanced() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(4, 2, 6, 1, 3, 5, 7);
    final List<Integer> expected = Arrays.asList(3, 4, 2, 5, 1);
    assertEquals(expected, solution.closestKValues(root, 3.4, 5));
  }

  @Test
  void testFailedCase1() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(3, 1, 4, null, 2);
    final List<Integer> expected = Arrays.asList(2);
    assertEquals(expected, solution.closestKValues(root, 2.00000, 1));
  }

  @Test
  void testFailedCase2() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(5, 3, 6, 2, 4, null, null, 1);
    final List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
    assertEquals(expected, solution.closestKValues(root, 0.857143, 5));
  }
}