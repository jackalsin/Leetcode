package interviews.microsoft._235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.binaryTree.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


  @Test
  void testFailedCase1() {
    final TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    assertEquals(root, solution.lowestCommonAncestor(root, root, root.left));
  }
}