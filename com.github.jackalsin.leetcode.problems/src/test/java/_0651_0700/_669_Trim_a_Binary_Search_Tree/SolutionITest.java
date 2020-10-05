package _0651_0700._669_Trim_a_Binary_Search_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/11/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(
        1,
        0, 2
    ), expected = TreeNodes.getTreeLevelOrder(
        1,
        null, 2
    );
    assertEquals(expected, solution.trimBST(root, 1, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(
        3,
        0, 4,
        null, 2, null, null,
        1
    ), expected = TreeNodes.getTreeLevelOrder(
        3,
        2, null,
        1
    );
    assertEquals(expected, solution.trimBST(root, 1, 3));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}