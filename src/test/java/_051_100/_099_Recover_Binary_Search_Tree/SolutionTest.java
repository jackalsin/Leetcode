package _051_100._099_Recover_Binary_Search_Tree;

import org.junit.Before;
import org.junit.Test;

import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertEquals;

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
  public void test3Elements() throws Exception {
    final TreeNode input = TreeNodes.getTreeLevelOrder(new int[] {2, 3, 1});
    final TreeNode expected = TreeNodes.getTreeLevelOrder(new int[] {2, 1, 3});
    solution.recoverTree(input);
    assertEquals(expected, input);
  }
}
