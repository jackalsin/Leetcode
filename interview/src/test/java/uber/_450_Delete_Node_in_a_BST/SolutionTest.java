package uber._450_Delete_Node_in_a_BST;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    TreeNode root = TreeNodes.getTreeLevelOrder(5, 3, 6, 2, 4, null, 7);
    final TreeNode actual = solution.deleteNode(root, 3);
    System.out.println(actual);
    final Set<TreeNode> expected = Set.of(
        Objects.requireNonNull(TreeNodes.getTreeLevelOrder(5, 4, 6, 2, null, null, 7)),
        Objects.requireNonNull(TreeNodes.getTreeLevelOrder(5, 2, 6, null, 4, null, 7))
    );
    assertTrue(expected.contains(actual));
  }
}