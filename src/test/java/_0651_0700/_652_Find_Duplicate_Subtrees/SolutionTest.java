package _0651_0700._652_Find_Duplicate_Subtrees;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(6, 3, 4, null, null, null, 6);
    List<TreeNode> actual = solution.findDuplicateSubtrees(root);
    assertTrue(actual.isEmpty());
  }

  @Test
  public void testOnlineCase1() throws Exception {
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
