package interviews.microsoft.noodleEssence.econdLargestInBST;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testLeftTreeMax() {
    //            9
    //           /  \
    //          7   15
    //              /
    //            10
    //              \
    //              12
    //               \
    //               14

    final TreeNode root = TreeNodes.getTreeLevelOrder(9, 7, 15);
    root.right.left = new TreeNode(10);
    root.right.left.right = new TreeNode(12);
    root.right.left.right.right = new TreeNode(14);

    assertEquals(14, solution.getSecondLargest(root));
  }

  @Test
  void testOnlineCase1() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(9, 7, 15);
    assertEquals(9, solution.getSecondLargest(root));
  }

  @Test
  void testSingleElement() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(15);
    assertThrows(IllegalStateException.class, () -> solution.getSecondLargest(root));
  }

  @Test
  void testNull() {
    assertThrows(NullPointerException.class, () -> solution.getSecondLargest(null));
  }
}