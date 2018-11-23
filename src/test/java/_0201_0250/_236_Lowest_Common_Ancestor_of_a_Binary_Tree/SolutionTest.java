package _0201_0250._236_Lowest_Common_Ancestor_of_a_Binary_Tree;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/19/2017.
 */
class SolutionTest {
  private Solution solution;

  private TreeNode root = new TreeNode(3);

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
    root.right = new TreeNode(1);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);
  }

  @Test
  void testPEqualsQRoot() throws Exception {
    assertEquals(root, solution.lowestCommonAncestor(root, root, root));
  }

  @Test
  void testPEqualsQNonRoot() throws Exception {
    assertEquals(root.left, solution.lowestCommonAncestor(root, root.left, root.left));
  }

  @Test
  void testParent() throws Exception {
    assertEquals(root.left.right, solution.lowestCommonAncestor(root, root.left.right,
        root.left.right.right));
  }

  @Test
  void testRegular() throws Exception {
    assertEquals(root.left, solution.lowestCommonAncestor(root, root.left.left,
        root.left.right.right));
  }

}
