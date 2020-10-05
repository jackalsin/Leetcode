package _0501_0550._508_Most_Frequent_Subtree_Sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(5, 2, -3);
    final int[] actual = solution.findFrequentTreeSum(root);
    assertEquals(Set.of(2, -3, 4), Arrays.stream(actual).boxed().collect(Collectors.toSet()));
  }

  @Test
  void testOnlineCase2() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(5, 2, -5);
    final int[] actual = solution.findFrequentTreeSum(root);
    assertEquals(Set.of(2), Arrays.stream(actual).boxed().collect(Collectors.toSet()));
  }

}