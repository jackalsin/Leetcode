package _1101_1150._1110_Delete_Nodes_And_Return_Forest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/15/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(
        1, 2, 3, 4, 5, 6, 7
    );
    final int[] toDelete = {3, 5};
    final Set<TreeNode> expected = Set.of(
        TreeNodes.getTreeLevelOrder(1, 2, null, 4),
        TreeNodes.getTreeLevelOrder(6),
        TreeNodes.getTreeLevelOrder(7)
    );
    final List<TreeNode> actual = solution.delNodes(root, toDelete);
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(
        1, 2, null, 4, 3
    );
    final int[] toDelete = {2, 3};
    final Set<TreeNode> expected = Set.of(
        TreeNodes.getTreeLevelOrder(1),
        TreeNodes.getTreeLevelOrder(4)
    );
    final List<TreeNode> actual = solution.delNodes(root, toDelete);
    assertEquals(expected, new HashSet<>(actual));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}