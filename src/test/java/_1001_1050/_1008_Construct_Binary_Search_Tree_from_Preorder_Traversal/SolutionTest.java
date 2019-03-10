package _1001_1050._1008_Construct_Binary_Search_Tree_from_Preorder_Traversal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/9/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[] input = {8, 5, 1, 7, 10, 12};
    final TreeNode expected = TreeNodes.getTreeLevelOrder(8, 5, 10, 1, 7, null, 12),
        actual = solution.bstFromPreorder(input);
    assertEquals(expected, actual);
  }
}