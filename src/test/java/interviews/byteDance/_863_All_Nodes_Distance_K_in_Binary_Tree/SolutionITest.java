package interviews.byteDance._863_All_Nodes_Distance_K_in_Binary_Tree;

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
 * @version 1.0 on 5/10/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
    final List<Integer> actual = solution.distanceK(root, root.left, 2);
    final Set<Integer> expected = Set.of(7, 4, 1);
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
    final List<Integer> actual = solution.distanceK(root, root.left, 0);
    final Set<Integer> expected = Set.of(5);
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseRoot(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
    final List<Integer> actual = solution.distanceK(root, root, 0);
    final Set<Integer> expected = Set.of(3);
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseLeaf(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(0, 1, null, 3, 2);
    final List<Integer> actual = solution.distanceK(root, root.left.left, 1);
    final Set<Integer> expected = Set.of(1);
    assertEquals(expected, new HashSet<>(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}