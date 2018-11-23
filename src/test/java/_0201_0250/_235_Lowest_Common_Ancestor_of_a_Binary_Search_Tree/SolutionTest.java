package _0201_0250._235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author jacka
 * @version 1.0 on 8/18/2017.
 */
class SolutionTest {
  private Solution solution;

  private TreeNode root = new TreeNode(6);

  @BeforeEach
  void setUp() {
    solution = new Solution();
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = new TreeNode(5);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);
  }

  @Test
  void testPEqualsQRoot() {
    assertEquals(root, solution.lowestCommonAncestor(root, root, root));
  }

  @Test
  void testPEqualsQNonRoot() {
    assertEquals(root.left, solution.lowestCommonAncestor(root, root.left, root.left));
  }

  @Test
  void testParent() {
    assertEquals(root.left.right, solution.lowestCommonAncestor(root, root.left.right,
        root.left.right.right));
  }

  @Test
  void testRegular() {
    assertEquals(root.left, solution.lowestCommonAncestor(root, root.left.left,
        root.left.right.right));
  }

}
