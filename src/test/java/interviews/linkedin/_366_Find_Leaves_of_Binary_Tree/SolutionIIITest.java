package interviews.linkedin._366_Find_Leaves_of_Binary_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIIITest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new SolutionIII();
  }

  @Test
  void testOnlineCase1() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5);
    final List<List<Integer>> actual = solution.findLeaves(root);
    final List<List<Integer>> expected = List.of(
        List.of(4, 5, 3),
        List.of(2),
        List.of(1)
    );
    assertEquals(expected, actual);
  }
}