package linkedin.mianjing._235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import definition.binaryTree.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  private TreeNode root = new TreeNode(6);

  @BeforeEach
  void setUp() throws Exception {
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