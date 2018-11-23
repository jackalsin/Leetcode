package _0101_0150._104_Maximum_Depth_of_Binary_Tree;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/16/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test1Level() throws Exception {
    TreeNode input = TreeNodes.getTreeLevelOrder(1);
    assertEquals(1, solution.maxDepth(input));
  }

  @Test
  public void test2Levels() throws Exception {
    TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3);
    assertEquals(2, solution.maxDepth(input));
  }

  @Test
  public void test3LevelsIncomplit() throws Exception {
    TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3, 4);
    assertEquals(3, solution.maxDepth(input));
  }
}
