package _0851_0900._872_Leaf_Similar_Trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 9/13/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final TreeNode root1 = TreeNodes.getTreeLevelOrder(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4),
        root2 = TreeNodes.getTreeLevelOrder(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8);
    assertTrue(solution.leafSimilar(root1, root2));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}