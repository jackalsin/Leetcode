package _0601_0650._617_Merge_Two_Binary_Trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/5/18
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final TreeNode t1 = TreeNodes.getTreeLevelOrder(1, 3, 2, 5),
        t2 = TreeNodes.getTreeLevelOrder(2, 1, 3, null, 4, null, 7),
        expected = TreeNodes.getTreeLevelOrder(3, 4, 5, 5, 4, null, 7);
    final TreeNode actual = solution.mergeTrees(t1, t2);
    assertEquals(expected, actual);
  }
}