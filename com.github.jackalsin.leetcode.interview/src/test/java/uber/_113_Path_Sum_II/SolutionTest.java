package uber._113_Path_Sum_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() {
    TreeNode root = TreeNodes.getTreeLevelOrder(5, 4, 8, 11, null, 13, 4);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    root.right.right.left = new TreeNode(5);
    root.right.right.right = new TreeNode(1);
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(5, 4, 11, 2));
    expected.add(Arrays.asList(5, 8, 4, 5));
    assertEquals(expected, solution.pathSum(root, 22));
  }

}