package _201_250._235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import org.junit.Before;
import org.junit.Test;

import utils.TreeNode;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/18/2017.
 */
public class SolutionTest {
  private Solution solution;

  private TreeNode root = new TreeNode(6);

  @Before
  public void setUp() throws Exception {
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
  public void testPEqualsQRoot() throws Exception {
    assertEquals(root, solution.lowestCommonAncestor(root, root, root));
  }

  @Test
  public void testPEqualsQNonRoot() throws Exception {
    assertEquals(root.left, solution.lowestCommonAncestor(root, root.left, root.left));
  }

  @Test
  public void testParent() throws Exception {
    assertEquals(root.left.right, solution.lowestCommonAncestor(root, root.left.right,
        root.left.right.right));
  }

  @Test
  public void testRegular() throws Exception {
    assertEquals(root.left, solution.lowestCommonAncestor(root, root.left.left,
        root.left.right.right));
  }

}
