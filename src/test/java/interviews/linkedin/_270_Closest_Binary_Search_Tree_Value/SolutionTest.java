package interviews.linkedin._270_Closest_Binary_Search_Tree_Value;

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
    final TreeNode root = TreeNodes.getTreeLevelOrder(new int[]{4, 2, 5, 1, 3});
    final double target = 3.714286;
    assertEquals(4, solution.closestValue(root, target));
  }

  @Test
  void testOnlineCase2() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(new int[]{0});
    final double target = Integer.MAX_VALUE;
    assertEquals(0, solution.closestValue(root, target));
  }
}