package _051_100._099_Recover_Binary_Search_Tree;

import org.junit.Before;
import org.junit.Test;

import utils.TreeNode;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/7/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test2Elements() throws Exception {
    final TreeNode input = new TreeNode(0);
    input.left = new TreeNode(1);
    solution.recoverTree(input);
    final TreeNode expected = new TreeNode(1);
    expected.left = new TreeNode(0);

    assertEquals(expected, input);
  }

  @Test
  public void test5Elements() throws Exception {
    final TreeNode input = new TreeNode(0);
    input.left = new TreeNode(1);
    solution.recoverTree(input);

    final TreeNode expected = new TreeNode(1);
    expected.left = new TreeNode(0);

    assertEquals(expected, input);
  }
}
