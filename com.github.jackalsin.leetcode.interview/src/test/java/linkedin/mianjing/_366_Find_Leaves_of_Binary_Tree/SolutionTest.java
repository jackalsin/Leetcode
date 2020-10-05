package linkedin.mianjing._366_Find_Leaves_of_Binary_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5);
    List<Set<Integer>> expected = List.of(Set.of(4, 5, 3), Set.of(2), Set.of(1));
    List<List<Integer>> actual = solution.findLeaves(root);
    for (int i = 0; i < actual.size(); ++i) {
      assertEquals(expected.get(i), new HashSet<>(actual.get(i)));
    }
    assertEquals(expected.size(), actual.size());
  }

  @Test
  void testEmpty() throws Exception {
    assertEquals(new ArrayList<>(), solution.findLeaves(null));
  }

}