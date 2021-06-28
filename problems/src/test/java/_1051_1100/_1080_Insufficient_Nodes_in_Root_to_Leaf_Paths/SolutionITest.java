package _1051_1100._1080_Insufficient_Nodes_in_Root_to_Leaf_Paths;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 6/27/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, -99, -99, 7, 8, 9, -99, -99, 12, 13, -99, 14),
        expected = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, null, null, 7, 8, 9, null, 14),
        actual = solution.sufficientSubset(input, 1);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final TreeNode input = TreeNodes.getTreeLevelOrder(5, 4, 8, 11, null, 17, 4, 7, 1, null, null, 5, 3),
        expected = TreeNodes.getTreeLevelOrder(5, 4, 8, 11, null, 17, 4, 7, null, null, null, 5),
        actual = solution.sufficientSubset(input, 22);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}