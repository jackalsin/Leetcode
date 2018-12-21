package _0651_0700._655_Print_Binary_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, null);
    final List<List<String>> expected = List.of(
        List.of("", "1", ""),
        List.of("2", "", "")
    );
    final List<List<String>> actual = solution.printTree(input);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3, null, 4);
    final List<List<String>> expected = List.of(
        List.of("", "", "", "1", "", "", ""),
        List.of("", "2", "", "", "", "3", ""),
        List.of("", "", "4", "", "", "", "")
    );
    final List<List<String>> actual = solution.printTree(input);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase3() {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 5, 3);
    input.left.left.left = new TreeNode(4);
    final List<List<String>> expected = List.of(
        List.of("", "", "", "", "", "", "", "1", "", "", "", "", "", "", ""),
        List.of("", "", "", "2", "", "", "", "", "", "", "", "5", "", "", ""),
        List.of("", "3", "", "", "", "", "", "", "", "", "", "", "", "", ""),
        List.of("4", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
    );
    final List<List<String>> actual = solution.printTree(input);
    assertEquals(expected, actual);
  }
}