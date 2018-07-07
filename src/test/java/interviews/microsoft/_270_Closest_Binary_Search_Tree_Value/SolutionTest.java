package interviews.microsoft._270_Closest_Binary_Search_Tree_Value;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void test1() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1);
    assertEquals(1, solution.closestValue(root, 1));
    assertEquals(1, solution.closestValue(root, -1));
    assertEquals(1, solution.closestValue(root, Integer.MAX_VALUE));
    assertEquals(1, solution.closestValue(root, Integer.MIN_VALUE));
  }

  @Test
  void test2Levels() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 1, 3);
    assertEquals(1, solution.closestValue(root, 1));
    assertEquals(1, solution.closestValue(root, -1));
    assertEquals(3, solution.closestValue(root, Integer.MAX_VALUE));
    assertEquals(1, solution.closestValue(root, Integer.MIN_VALUE));
  }

  @Test
  void test2Incompleted() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, null, 2);
    assertEquals(1, solution.closestValue(root, 1));
    assertEquals(1, solution.closestValue(root, -1));
    assertEquals(2, solution.closestValue(root, Integer.MAX_VALUE));
    assertEquals(1, solution.closestValue(root, Integer.MIN_VALUE));
  }

  @Test
  void test3Incompleted() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(4, 2, 6, 1, 3, 5, 7);
    assertEquals(1, solution.closestValue(root, 1));
    assertEquals(1, solution.closestValue(root, -1));
    assertEquals(3, solution.closestValue(root, 3.2));
    assertEquals(5, solution.closestValue(root, 4.9));
  }

  @Test
  void testEnd() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(8, 1);
    assertEquals(8, solution.closestValue(root, 6.0));
  }


}