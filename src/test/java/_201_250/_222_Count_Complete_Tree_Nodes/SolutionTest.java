package _201_250._222_Count_Complete_Tree_Nodes;

import org.junit.Before;
import org.junit.Test;

import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/15/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOneElement() throws Exception {
    assertEquals(1, solution.countNodes(new TreeNode(1)));
  }

  @Test
  public void test4Levels() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
    assertEquals(13, solution.countNodes(root));
  }

}
