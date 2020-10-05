package _0651_0700._687_Longest_Univalue_Path;

import org.junit.Before;
import org.junit.Test;
import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
//        5
//       / \
//      4   5
//     / \   \
//    1   1   5
    TreeNode root = TreeNodes.getTreeLevelOrder(5, 4, 5, 1, 1, null, 5);
    assertEquals(2, solution.longestUnivaluePath(root));
  }

  @Test
  public void testOnlineCase2() throws Exception {
//           1
//          / \
//         4   5
//        / \   \
//       4   4   5
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 4, 5, 4, 4, null, 5);
    assertEquals(2, solution.longestUnivaluePath(root));
  }

  @Test
  public void testNull() {
    assertEquals(0, solution.longestUnivaluePath(null));
  }
}