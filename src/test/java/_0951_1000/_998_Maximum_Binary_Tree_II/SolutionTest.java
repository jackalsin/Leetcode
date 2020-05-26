package _0951_1000._998_Maximum_Binary_Tree_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/23/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(4, 1, 3, null, null, 2);
    final TreeNode expected = new TreeNode(5);
    expected.left = TreeNodes.getTreeLevelOrder(4, 1, 3, null, null, 2);
    assertEquals(expected, solution.insertIntoMaxTree(root, 5));
  }

  @Test
  void testOnlineCase2() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(5, 2, 4, null, 1);
    final TreeNode expected = TreeNodes.getTreeLevelOrder(5, 2, 4, null, 1);
    expected.right.right = new TreeNode(3);
    assertEquals(expected, solution.insertIntoMaxTree(root, 3));
  }

  @Test
  void testOnlineCase3() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(5, 2, 3, null, 1);
    final TreeNode expected = TreeNodes.getTreeLevelOrder(5, 2, 4, null, 1, 3);
    assertEquals(expected, solution.insertIntoMaxTree(root, 4));
  }
}