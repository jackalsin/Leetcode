package _0201_0250._226_Invert_Binary_Tree;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/16/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOneNode() throws Exception {
    TreeNode expected = new TreeNode(1);
    TreeNode actual = solution.invertTree(expected);
    assertEquals(expected, actual);
  }

  @Test
  void test3LevelNodes() throws Exception {
    TreeNode input = TreeNodes.getTreeLevelOrder(4, 2, 7, 1, 3, 6, 9);
    TreeNode actual = solution.invertTree(input);
    TreeNode expected = TreeNodes.getTreeLevelOrder(4, 7, 2, 9, 6, 3, 1);
    assertEquals(expected, actual);
  }

}
