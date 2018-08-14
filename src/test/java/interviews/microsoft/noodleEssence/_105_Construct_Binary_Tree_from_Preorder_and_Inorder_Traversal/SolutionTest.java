package interviews.microsoft.noodleEssence._105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testEmpty() throws Exception {
    assertNull(solution.buildTree(new int[]{}, new int[]{}));
  }

  @Test
  void test3Levels() throws Exception {
    final int[] preOrder = new int[]{1, 2, 4, 5, 3, 6, 7};
    final int[] levelOrder = new int[]{1, 2, 3, 4, 5, 6, 7};
    final int[] inOrder = new int[]{4, 2, 5, 1, 6, 3, 7};
    final TreeNode root = TreeNodes.getTreeLevelOrder(levelOrder);
    assertEquals(root, solution.buildTree(preOrder, inOrder));
  }


}