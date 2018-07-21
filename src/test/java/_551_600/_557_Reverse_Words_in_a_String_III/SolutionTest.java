package _551_600._557_Reverse_Words_in_a_String_III;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final TreeNode s = TreeNodes.getTreeLevelOrder(3, 4, 5, 1, 2),
        t = TreeNodes.getTreeLevelOrder(4, 1, 2);

    assertTrue(solution.isSubtree(s, t));
  }

  @Test
  void testOnlineCase2() {
    final TreeNode s = TreeNodes.getTreeLevelOrder(3, 4, 5, 1, 2),
        t = TreeNodes.getTreeLevelOrder(4, 1, 2);
    s.left.right.left = new TreeNode(0);
    assertFalse(solution.isSubtree(s, t));
  }

  @Test
  void testOnlineCase3() {
    final TreeNode s = new TreeNode(1);
    s.right = new TreeNode(1);
    s.right.right = new TreeNode(1);
    s.right.right.right = new TreeNode(1);
    s.right.right.right.right = new TreeNode(1);
    s.right.right.right.right.right = new TreeNode(1);
    s.right.right.right.right.right.right = new TreeNode(1);
    s.right.right.right.right.right.right.right = new TreeNode(1);
    s.right.right.right.right.right.right.right.right = new TreeNode(1);
    s.right.right.right.right.right.right.right.right.right = new TreeNode(1);
    s.right.right.right.right.right.right.right.right.right.right = new TreeNode(1);
    s.right.right.right.right.right.right.right.right.right.right.right = new TreeNode(1);
    s.right.right.right.right.right.right.right.right.right.right.right.right = new TreeNode(1);
    s.right.right.right.right.right.right.right.right.right.right.right.right.left = new TreeNode(2);
    final TreeNode t = new TreeNode(1);
    t.right = new TreeNode(1);
    t.right.right = new TreeNode(1);
    t.right.right.right = new TreeNode(1);
    t.right.right.right.right = new TreeNode(1);
    t.right.right.right.right.right = new TreeNode(1);
    t.right.right.right.right.right.right = new TreeNode(1);
    t.right.right.right.right.right.right.left = new TreeNode(2);
    assertTrue(solution.isSubtree(s, t));
  }

}