package interviews.pinterest._114_Flatten_Binary_Tree_to_Linked_List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() {
    TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 5, 3, 4, null, 6);
    solution.flatten(input);
    TreeNode expected = new TreeNode(1);
    expected.right = new TreeNode(2);
    expected.right.right = new TreeNode(3);
    expected.right.right.right = new TreeNode(4);
    expected.right.right.right.right = new TreeNode(5);
    expected.right.right.right.right.right = new TreeNode(6);
    assertEquals(expected, input);
  }

  @Test
  void testOnlineCase1() {
    TreeNode input = TreeNodes.getTreeLevelOrder(1, null, 2);
    input.right.left = new TreeNode(3);
    solution.flatten(input);
    TreeNode expected = new TreeNode(1);
    expected.right = new TreeNode(2);
    expected.right.right = new TreeNode(3);
    assertEquals(expected, input);
  }
}