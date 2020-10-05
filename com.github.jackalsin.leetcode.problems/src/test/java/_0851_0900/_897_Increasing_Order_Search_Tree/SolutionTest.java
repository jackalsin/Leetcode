package _0851_0900._897_Increasing_Order_Search_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(5, 3, 6, 2, 4, null, 8);

    final TreeNode actual = solution.increasingBST(root);
    System.out.print(actual);
  }
}