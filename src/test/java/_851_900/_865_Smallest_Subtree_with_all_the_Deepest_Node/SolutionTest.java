package _851_900._865_Smallest_Subtree_with_all_the_Deepest_Node;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(
        3, 5, 1, 6, 2, 0, 8, null, null, 7, 4
    );
    final TreeNode expected = root.left.right;
    assertEquals(expected, solution.subtreeWithAllDeepest(root));
  }

  @Test
  void testOnlineCase2() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(
        3, 5, 1, 6, 2, 0, 8, null, null, 7, 4, 6
    );
    final TreeNode expected = root;
    assertEquals(expected, solution.subtreeWithAllDeepest(root));
  }

}