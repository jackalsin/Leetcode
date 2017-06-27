package _101_150._124_Binary_Tree_Maximum_Path_Sum;

import org.junit.Before;
import org.junit.Test;

import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/26/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test3() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3);
    assertEquals(6,solution.maxPathSum(root));
  }

}
