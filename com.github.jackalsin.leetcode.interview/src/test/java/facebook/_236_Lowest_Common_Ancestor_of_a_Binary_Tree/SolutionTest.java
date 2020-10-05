package facebook._236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import definition.binaryTree.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  private TreeNode root = new TreeNode(3);

  @BeforeEach
  void setUp() {
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