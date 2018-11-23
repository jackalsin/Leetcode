package _0501_0550._549_Binary_Tree_Longest_Consecutive_Sequence_II;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testFullTree() {
    //      4
    //   2      6
    // 1   3  5   7
    final TreeNode root = TreeNodes.getTreeLevelOrder(4, 2, 6, 1, 3, 5, 7);
    assertEquals(3, solution.longestConsecutive(root));
  }

}