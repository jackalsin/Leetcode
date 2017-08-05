package _151_200._199_Binary_Tree_Right_Side_View;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import utils.TreeNode;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/4/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    List<Integer> result = Arrays.asList(1, 3, 4);
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(4);
    assertEquals(result, solution.rightSideView(root));
  }

  @Test
  public void testPenetrateTestCase() throws Exception {
    List<Integer> result = Arrays.asList(1, 3, 5);
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    assertEquals(result, solution.rightSideView(root));
  }
}
