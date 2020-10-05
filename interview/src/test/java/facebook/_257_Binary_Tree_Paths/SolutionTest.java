package facebook._257_Binary_Tree_Paths;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testNull() {
    assertEquals(new ArrayList<>(), solution.binaryTreePaths(null));
  }

  @Test
  void testOnlineCase() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3, null, 5);
    final List<String> actual = solution.binaryTreePaths(root);
    final Set<String> expected = new HashSet<>();
    expected.add("1->2->5");
    expected.add("1->3");
    assertEquals(expected, new HashSet<>(actual));
  }
}