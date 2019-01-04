package interviews.uber._652_Find_Duplicate_Subtrees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase2() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(6, 3, 4, null, null, null, 6);
    List<TreeNode> actual = solution.findDuplicateSubtrees(root);
    assertTrue(actual.isEmpty());
  }

  @Test
  void testOnlineCase1() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, null, 2, 4);
    root.right.left.left = new TreeNode(4);
    List<TreeNode> expected = List.of(
        Objects.requireNonNull(TreeNodes.getTreeLevelOrder(2, 4, null)),
        Objects.requireNonNull(TreeNodes.getTreeLevelOrder(4))
    );
    List<TreeNode> actual = solution.findDuplicateSubtrees(root);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

}