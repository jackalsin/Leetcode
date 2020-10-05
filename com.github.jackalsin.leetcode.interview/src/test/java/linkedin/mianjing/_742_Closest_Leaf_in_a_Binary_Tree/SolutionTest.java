package linkedin.mianjing._742_Closest_Leaf_in_a_Binary_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/4/18
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3);
    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(5);
    root.left.left.left.left = new TreeNode(6);
    final int actual = solution.findClosestLeaf(root, 2);
    assertEquals(3, actual);
  }

  @Test
  void testOnlineCase2() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 3, 2);
    final int actual = solution.findClosestLeaf(root, 1);
    assertTrue(Set.of(2, 3).contains(actual));
  }

  @Test
  void testOnlineCase3() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1);
    final int actual = solution.findClosestLeaf(root, 1);
    assertTrue(Objects.equals(1, actual));
  }

}