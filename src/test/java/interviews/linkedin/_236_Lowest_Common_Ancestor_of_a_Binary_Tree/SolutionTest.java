package interviews.linkedin._236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
class SolutionTest {
  private Solution solution;
  private TreeNode root = TreeNodes.getTreeLevelOrder(3, 5, 1, 6, 2, 0, 8);

  @BeforeEach
  void setUp() {
    solution = new SolutionII();
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
  }

  @Test
  void testOnlineCase1() {
    assertEquals(3, solution.lowestCommonAncestor(root, root.left, root.right).val);
  }

  @Test
  void testOnlineCase2() {
    assertEquals(5, solution.lowestCommonAncestor(root, root.left, root.left.right.right).val);
  }

}
