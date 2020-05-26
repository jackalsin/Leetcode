package interviews.oracle.findCommonChild;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/3/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final TreeNode rootA = TreeNodes.getTreeLevelOrder(
        1,
        2, 3,
        null, null, 4, 5
    ), rootB = TreeNodes.getTreeLevelOrder(
        3, 4, 5
    );
    final Set<Integer> expected = Set.of(
        3, 4, 5
    );
    final List<Integer> actual = solution.getCommonChild(rootA, rootB);
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testGetMostRecentCommonChild(Solution solution) {
    final TreeNode rootA = TreeNodes.getTreeLevelOrder(
        1,
        2, 3,
        null, null, 4, 5
    ), rootB = TreeNodes.getTreeLevelOrder(
        3, 4, 5
    );
    final int expected = 3;
    final int actual = solution.getMostRecentCommonChild(rootA, rootB);
    assertEquals(expected, actual);
  }


  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}