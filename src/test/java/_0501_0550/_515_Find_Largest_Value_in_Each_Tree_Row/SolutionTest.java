package _0501_0550._515_Find_Largest_Value_in_Each_Tree_Row;

import org.junit.Before;
import org.junit.Test;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 3, 2, 5, 3, 9);
    assertEquals(List.of(1, 3, 9), solution.largestValues(root));
  }

}
